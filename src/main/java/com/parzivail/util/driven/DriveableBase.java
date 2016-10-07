package com.parzivail.util.driven;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.entity.EntityCamera;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.RotatedAxes;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class DriveableBase extends Entity implements IEntityAdditionalSpawnData
{
	static final boolean MOUSE_CONTROL_MODE = false;

	public boolean syncFromServer = true;
	/**
	 * Ticks since last server update. Use to smoothly transition to new position
	 */
	public int serverPositionTransitionTicker;
	/**
	 * Server side position, as synced by PacketVehicleControl packets
	 */
	public double serverPosX, serverPosY, serverPosZ;
	/**
	 * Server side rotation, as synced by PacketVehicleControl packets
	 */
	public double serverYaw, serverPitch, serverRoll;

	/**
	 * The shortName of the driveable type, used to obtain said type
	 */
	public String driveableType;

	/**
	 * The throttle, in the range -1, 1 is multiplied by the maxThrottle (or maxNegativeThrottle) from the plane type to obtain the thrust
	 */
	public float throttle;

	public boolean fuelling;
	/**
	 * Extra prevRoation field for smoothness in all 3 rotational axes
	 */
	public float prevRotationRoll;
	/**
	 * Angular velocity
	 */
	public Vector3f angularVelocity = new Vector3f(0F, 0F, 0F);

	/**
	 * Whether each mouse button is held
	 */
	public boolean leftMouseHeld = false, rightMouseHeld = false;

	/**
	 * Shoot delay variables
	 */
	public int shootDelayPrimary, shootDelaySecondary;
	/**
	 * Minigun speed variables
	 */
	public float minigunSpeedPrimary, minigunSpeedSecondary;
	/**
	 * Current gun variables for alternating weapons.
	 */
	public int currentGunPrimary, currentGunSecondary;

	/**
	 * Angle of harvester aesthetic piece
	 */
	public float harvesterAngle;

	public RotatedAxes prevAxes;
	public RotatedAxes axes;

	public EntitySeat[] seats;

	/**
	 * The ID of the slot that we are pulling fuel from. -1 means we have not found one
	 */
	private int foundFuel = -1;
	/**
	 * True if we need fuel but could not find any in the inventory. Reset when the inventory updated
	 */
	public boolean couldNotFindFuel = false;

	@SideOnly(Side.CLIENT)
	public EntityLivingBase camera;

	public float cameraDistance = 1;
	protected int numPassengers = 1;
	public float moveDrag;

	public DriveableBase(World world)
	{
		super(world);
		axes = new RotatedAxes();
		prevAxes = new RotatedAxes();
		preventEntitySpawning = true;
		setSize(1F, 1F);
		yOffset = 6F / 16F;
		ignoreFrustumCheck = true;
		renderDistanceWeight = 200D;
	}

	protected void initType(boolean clientSide)
	{
		seats = new EntitySeat[numPassengers + 1];
		for (int i = 0; i < numPassengers + 1; i++)
		{
			if (!clientSide)
			{
				seats[i] = new EntitySeat(worldObj, this, i);
				worldObj.spawnEntityInWorld(seats[i]);
			}
		}

		//Register Plane to Radar on Spawning
		//if(type.onRadar == true)
		//	RadarRegistry.register(this);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag)
	{
		tag.setString("Type", driveableType);
		tag.setFloat("RotationYaw", axes.getYaw());
		tag.setFloat("RotationPitch", axes.getPitch());
		tag.setFloat("RotationRoll", axes.getRoll());
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag)
	{
		initType(false);

		prevRotationYaw = tag.getFloat("RotationYaw");
		prevRotationPitch = tag.getFloat("RotationPitch");
		prevRotationRoll = tag.getFloat("RotationRoll");
		axes = new RotatedAxes(prevRotationYaw, prevRotationPitch, prevRotationRoll);
	}

	@Override
	public void writeSpawnData(ByteBuf data)
	{
		ByteBufUtils.writeUTF8String(data, driveableType);

		data.writeFloat(axes.getYaw());
		data.writeFloat(axes.getPitch());
		data.writeFloat(axes.getRoll());
	}

	@Override
	public void readSpawnData(ByteBuf data)
	{
		try
		{
			initType(true);

			axes.setAngles(data.readFloat(), data.readFloat(), data.readFloat());
			prevRotationYaw = axes.getYaw();
			prevRotationPitch = axes.getPitch();
			prevRotationRoll = axes.getRoll();

		}
		catch (Exception e)
		{
			super.setDead();
			e.printStackTrace();
		}

		camera = new EntityCamera(worldObj, this);
		worldObj.spawnEntityInWorld(camera);
	}

	/**
	 * Called with the movement of the mouse. Used in controlling vehicles if need be.
	 *
	 * @param deltaY
	 * @param deltaX
	 * @return if mouse movement was handled.
	 */
	public abstract void onMouseMoved(int deltaX, int deltaY);

	@SideOnly(Side.CLIENT)
	public EntityLivingBase getCamera()
	{
		return camera;
	}

	protected boolean canSit(int seat)
	{
		return numPassengers >= seat && seats[seat].riddenByEntity == null;
	}

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	protected void entityInit()
	{
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity)
	{
		return null;//entity.boundingBox;
	}

	@Override
	public AxisAlignedBB getBoundingBox()
	{
		return boundingBox;
	}

	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	public double getMountedYOffset()
	{
		return -0.3D;
	}

	@Override
	public void setDead()
	{
		super.setDead();

		if (worldObj.isRemote)
			camera.setDead();

		for (EntitySeat seat : seats)
			if (seat != null)
				seat.setDead();
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
	{
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return !isDead;
	}

	@Override
	public void applyEntityCollision(Entity entity)
	{
		if (!isPartOfThis(entity))
			super.applyEntityCollision(entity);
	}

	@Override
	public void setPositionAndRotation2(double d, double d1, double d2, float f, float f1, int i)
	{
		if (ticksExisted > 1)
			return;
		if (riddenByEntity instanceof EntityPlayer && StarWarsMod.proxy.isThePlayer((EntityPlayer)riddenByEntity))
		{
		}
		else
		{
			if (syncFromServer)
			{
				serverPositionTransitionTicker = i + 5;
			}
			else
			{
				double var10 = d - posX;
				double var12 = d1 - posY;
				double var14 = d2 - posZ;
				double var16 = var10 * var10 + var12 * var12 + var14 * var14;

				if (var16 <= 1.0D)
				{
					return;
				}

				serverPositionTransitionTicker = 3;
			}
			serverPosX = d;
			serverPosY = d1;
			serverPosZ = d2;
			serverYaw = f;
			serverPitch = f1;
		}
	}

	public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw)
	{
		if (worldObj.isRemote)
		{
			serverPosX = x;
			serverPosY = y;
			serverPosZ = z;
			serverYaw = yaw;
			serverPitch = pitch;
			serverRoll = roll;
			serverPositionTransitionTicker = 5;
		}
		else
		{
			setPosition(x, y, z);
			prevRotationYaw = yaw;
			prevRotationPitch = pitch;
			prevRotationRoll = roll;
			setRotation(yaw, pitch, roll);
		}
		//Set the motions regardless of side.
		motionX = motX;
		motionY = motY;
		motionZ = motZ;
		angularVelocity = new Vector3f(velYaw, velPitch, velRoll);
		throttle = throt;
	}


	@Override
	public void setVelocity(double d, double d1, double d2)
	{
		motionX = d;
		motionY = d1;
		motionZ = d2;
	}

	public boolean pressKey(int key, EntityPlayer player)
	{
		return false;
	}

	public void updateKeyHeldState(int key, boolean held)
	{
		if (worldObj.isRemote)
		{
			// TODO: packets
			//FlansMod.getPacketHandler().sendToServer(new PacketDriveableKeyHeld(key, held));
		}
		switch (key)
		{
			case 9:
				leftMouseHeld = held;
				break;
			case 8:
				rightMouseHeld = held;
				break;
		}
	}

	public Vector3f getLookVector()
	{
		return axes.getXAxis();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (!worldObj.isRemote)
		{
			for (int i = 0; i < numPassengers + 1; i++)
			{
				if (seats[i] == null || !seats[i].addedToChunk)
				{
					seats[i] = new EntitySeat(worldObj, this, i);
					worldObj.spawnEntityInWorld(seats[i]);
				}
			}
		}

		boolean driverIsCreative = seats != null && seats[0] != null && seats[0].riddenByEntity instanceof EntityPlayer && ((EntityPlayer)seats[0].riddenByEntity).capabilities.isCreativeMode;

		prevRotationYaw = axes.getYaw();
		prevRotationPitch = axes.getPitch();
		prevRotationRoll = axes.getRoll();
		prevAxes = axes.clone();

		if (riddenByEntity != null && riddenByEntity.isDead)
		{
			riddenByEntity = null;
		}
		if (riddenByEntity != null && isDead)
		{
			riddenByEntity.mountEntity(null);
		}
		if (riddenByEntity != null)
			riddenByEntity.fallDistance = 0F;

		boolean canThrust = (seats[0] != null && seats[0].riddenByEntity instanceof EntityPlayer);

		//If the player jumps out or dies, smoothly return the throttle to 0 so the plane might actually come down again */
		if ((seats[0] != null && seats[0].riddenByEntity == null) || !canThrust)
		{
			throttle *= 0.98F;
			rightMouseHeld = leftMouseHeld = false;
		}
	}

	@Override
	protected void fall(float k)
	{
	}

	/**
	 * Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates
	 */
	public Vector3f rotate(Vector3f inVec)
	{
		return axes.findLocalVectorGlobally(inVec);
	}

	/**
	 * Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates
	 */
	public Vector3f rotate(Vec3 inVec)
	{
		return rotate(inVec.xCoord, inVec.yCoord, inVec.zCoord);
	}

	/**
	 * Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates
	 */
	public Vector3f rotate(double x, double y, double z)
	{
		return rotate(new Vector3f((float)x, (float)y, (float)z));
	}

	//Rotate the plane locally by some angle about the yaw axis
	public void rotateYaw(float rotateBy)
	{
		if (Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalYaw(rotateBy);
		updatePrevAngles();
	}

	//Rotate the plane locally by some angle about the pitch axis
	public void rotatePitch(float rotateBy)
	{
		if (Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalPitch(rotateBy);
		updatePrevAngles();
	}

	//Rotate the plane locally by some angle about the roll axis
	public void rotateRoll(float rotateBy)
	{
		if (Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalRoll(rotateBy);
		updatePrevAngles();
	}

	public void updatePrevAngles()
	{
		//Correct angles that crossed the +/- 180 line, so that rendering doesnt make them swing 360 degrees in one tick.
		double dYaw = axes.getYaw() - prevRotationYaw;
		if (dYaw > 180)
			prevRotationYaw += 360F;
		if (dYaw < -180)
			prevRotationYaw -= 360F;

		double dPitch = axes.getPitch() - prevRotationPitch;
		if (dPitch > 180)
			prevRotationPitch += 360F;
		if (dPitch < -180)
			prevRotationPitch -= 360F;

		double dRoll = axes.getRoll() - prevRotationRoll;
		if (dRoll > 180)
			prevRotationRoll += 360F;
		if (dRoll < -180)
			prevRotationRoll -= 360F;
	}

	public void setRotation(float rotYaw, float rotPitch, float rotRoll)
	{
		axes.setAngles(rotYaw, rotPitch, rotRoll);
	}

	//Used to stop self collision
	public boolean isPartOfThis(Entity ent)
	{
		for (EntitySeat seat : seats)
		{
			if (seat == null)
				continue;
			if (ent == seat)
				return true;
			if (seat.riddenByEntity == ent)
				return true;
		}
		return ent == this;
	}

	@Override
	public float getShadowSize()
	{
		return 0.0F;
	}

	public boolean isDead()
	{
		return isDead;
	}

	public Entity getControllingEntity()
	{
		return seats[0].getControllingEntity();
	}

	public double getSpeedXYZ()
	{
		return Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
	}

	public double getSpeedXZ()
	{
		return Math.sqrt(motionX * motionX + motionZ * motionZ);
	}

	public float getPlayerRoll()
	{
		return axes.getRoll();
	}

	public float getCameraDistance()
	{
		return cameraDistance;
	}

	public Seat getSeatData(int id)
	{
		return null;
	}
}
