package com.parzivail.util.driven;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.handlers.KeyHandler;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.RotatedAxes;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class Pilotable extends Entity implements IEntityAdditionalSpawnData
{
	private Seat DEFAULT_SEAT = new Seat(0, 0, 0);
	public EntitySeat[] seats;

	public boolean syncFromServer = true;
	public double serverPosX, serverPosY, serverPosZ;
	public int serverPositionTransitionTicker;

	public float throttle;

	public float maxThrottle = 0.25f;
	public float prevRotationRoll;

	public double serverYaw, serverPitch, serverRoll;

	public RotatedAxes prevAxes;
	public RotatedAxes axes;

	public Vector3f angularVelocity = new Vector3f(0F, 0F, 0F);
	public static final float ANGULAR_DRAG_COEFFICIENT = 0.8f;

	@SideOnly(Side.CLIENT)
	public EntityLivingBase camera;

	public float cameraDistance = 1;
	protected int numPassengers = 1;

	public Pilotable(World world)
	{
		super(world);
		axes = new RotatedAxes();
		prevAxes = new RotatedAxes();
		preventEntitySpawning = true;
		setSize(1F, 1F);
		yOffset = 6F / 16F;
		ignoreFrustumCheck = true;
		renderDistanceWeight = 200D;
		initType(this.worldObj.isRemote);
	}

	void initType(boolean clientSide)
	{
		seats = new EntitySeat[numPassengers];
		if (!clientSide)
		{
			for (int i = 0; i < numPassengers; i++)
			{
				seats[i] = new EntitySeat(worldObj, this, i);
				worldObj.spawnEntityInWorld(seats[i]);
			}
		}
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag)
	{
		tag.setFloat("RotationYaw", axes.getYaw());
		tag.setFloat("RotationPitch", axes.getPitch());
		tag.setFloat("RotationRoll", axes.getRoll());
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag)
	{
		Lumberjack.debug("read NBT");
		initType(false);

		prevRotationYaw = tag.getFloat("RotationYaw");
		prevRotationPitch = tag.getFloat("RotationPitch");
		prevRotationRoll = tag.getFloat("RotationRoll");
		axes = new RotatedAxes(prevRotationYaw, prevRotationPitch, prevRotationRoll);
	}

	@Override
	public void writeSpawnData(ByteBuf data)
	{
		data.writeFloat(axes.getYaw());
		data.writeFloat(axes.getPitch());
		data.writeFloat(axes.getRoll());
	}

	@Override
	public void readSpawnData(ByteBuf data)
	{
		try
		{
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

		if (this.camera == null)
		{
			camera = new EntityCamera(worldObj, this);
			worldObj.spawnEntityInWorld(camera);
		}
	}

	@SideOnly(Side.CLIENT)
	public EntityLivingBase getCamera()
	{
		return camera;
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
		if (!(riddenByEntity instanceof EntityPlayer) || !StarWarsMod.proxy.isThePlayer((EntityPlayer)riddenByEntity))
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

	public Vector3f getInWorldPositionOf(Vector3f modelCoordinate)
	{
		Vector3f coord = new Vector3f(modelCoordinate);
		coord.scale(1 / 16f); // Convert from model coordinated to vehicle local world coordinates
		Vector3f found = this.axes.findLocalVectorGlobally(coord);
		found.translate((float)posX, (float)posY, (float)posZ);
		return found; // convert from local to global world coordinates
	}

	public Vector3f getLookVec3f()
	{
		return axes.getXAxis();
	}

	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
	{
		this.setDead();
		return true;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (this.worldObj.isRemote)
			KeyHandler.handleVehicleMovement();

		maxThrottle = 0.4f;

		//		if (seats[0] == null && !worldObj.isRemote)
		//		{
		//			for (int i = 0; i < numPassengers; i++)
		//			{
		//				if (seats[i] == null)
		//					seats[i] = new EntitySeatOld(worldObj, this, i);
		//				if (!seats[i].addedToChunk)
		//					worldObj.spawnEntityInWorld(seats[i]);
		//			}
		//
		//			StarWarsMod.network.sendToDimension(new MessageSetSeats(this, seats), worldObj.provider.dimensionId);
		//		}

		//if (!this.worldObj.isRemote)
		//	StarWarsMod.network.sendToDimension(new MessageSetSeats(this, this.seats), this.dimension);

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

		this.moveEntity(this.motionX, this.motionY, this.motionZ);
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
		if (seats == null || seats.length == 0 || seats[0] == null)
			return null;
		return seats[0].getControllingEntity();
	}

	public Seat getSeatData(int id)
	{
		// TODO: make seats pull right info
		return DEFAULT_SEAT;
	}

	public boolean isControlling(EntityPlayer thePlayer)
	{
		return getControllingEntity() != null && thePlayer != null && getControllingEntity().getEntityId() == thePlayer.getEntityId();
	}

	public void acceptInput(ShipInput input)
	{
		if (this.seats[0] == null)
			return;

		this.seats[0].acceptInput(input);
	}
}
