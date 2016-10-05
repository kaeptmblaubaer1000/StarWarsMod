package com.parzivail.util.vehicle;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.RotatedAxes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class DrivenBase extends EntityLiving
{
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
	public double serverYaw, serverPitch;

	/**
	 * Extra prevRoation field for smoothness in all 3 rotational axes
	 */
	public float prevRotationRoll;

	/**
	 * Angle of harvester aesthetic piece
	 */
	public float harvesterAngle;

	public RotatedAxes prevAxes;
	public RotatedAxes axes;

	private int numSeats = 1;
	public EntitySeat[] seats;
	public Vec3[] seatOffsets;

	@SideOnly(Side.CLIENT)
	public EntityLivingBase camera;

	public DrivenBase(World world)
	{
		super(world);
		axes = new RotatedAxes();
		prevAxes = new RotatedAxes();
		preventEntitySpawning = true;
		setSize(1F, 1F);
		yOffset = 6F / 16F;
		ignoreFrustumCheck = true;
		renderDistanceWeight = 200D;
		seatOffsets = new Vec3[numSeats];
		for (int i = 0; i < numSeats; i++)
			seatOffsets[i] = Vec3.createVectorHelper(0, 0, 0);
		initType(world.isRemote);
	}

	protected void initType(boolean clientSide)
	{
		seats = new EntitySeat[numSeats];
		for (int i = 0; i < numSeats; i++)
		{
			if (!clientSide)
			{
				seats[i] = new EntitySeat(worldObj);
				worldObj.spawnEntityInWorld(seats[i]);
			}
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tag)
	{
		tag.setFloat("RotationYaw", axes.getYaw());
		tag.setFloat("RotationPitch", axes.getPitch());
		tag.setFloat("RotationRoll", axes.getRoll());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tag)
	{
		initType(false);

		prevRotationYaw = tag.getFloat("RotationYaw");
		prevRotationPitch = tag.getFloat("RotationPitch");
		prevRotationRoll = tag.getFloat("RotationRoll");
		axes = new RotatedAxes(prevRotationYaw, prevRotationPitch, prevRotationRoll);
	}

	@SideOnly(Side.CLIENT)
	public EntityLivingBase getCamera()
	{
		return camera;
	}

	protected boolean canSit(int seat)
	{
		return seats.length > seat && seats[seat].riddenByEntity == null;
	}

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	public void setDead()
	{
		super.setDead();

		//Unregister to Radar
		//RadarRegistry.unregister(this);
		if (worldObj.isRemote) camera.setDead();

		for (EntitySeat seat : seats)
			if (seat != null) seat.setDead();
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return !isDead;
	}

	@Override
	public void setPositionAndRotation2(double d, double d1, double d2, float f, float f1, int i)
	{
		if (ticksExisted > 1) return;
		if (!(riddenByEntity instanceof EntityPlayer) || riddenByEntity != StarWarsMod.mc.thePlayer)
		{
			if (syncFromServer)
			{
				serverPositionTransitionTicker = i + 5;
			} else
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


	@Override
	public void setVelocity(double d, double d1, double d2)
	{
		motionX = d;
		motionY = d1;
		motionZ = d2;
	}

	public Vec3 getOffsetForSeat(int seat)
	{
		return seatOffsets[seat];
	}

	public void setOffsetForSeat(int seat, Vec3 offset)
	{
		seatOffsets[seat] = offset;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (!worldObj.isRemote)
		{
			for (int i = 0; i < numSeats; i++)
			{
				if (seats[i] == null || !seats[i].addedToChunk)
				{
					seats[i] = new EntitySeat(worldObj);
					worldObj.spawnEntityInWorld(seats[i]);
				}
			}
		}

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
		if (riddenByEntity != null) riddenByEntity.fallDistance = 0F;
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
		if (Math.abs(rotateBy) < 0.01F) return;
		axes.rotateLocalYaw(rotateBy);
		updatePrevAngles();
	}

	//Rotate the plane locally by some angle about the pitch axis
	public void rotatePitch(float rotateBy)
	{
		if (Math.abs(rotateBy) < 0.01F) return;
		axes.rotateLocalPitch(rotateBy);
		updatePrevAngles();
	}

	//Rotate the plane locally by some angle about the roll axis
	public void rotateRoll(float rotateBy)
	{
		if (Math.abs(rotateBy) < 0.01F) return;
		axes.rotateLocalRoll(rotateBy);
		updatePrevAngles();
	}

	public void updatePrevAngles()
	{
		//Correct angles that crossed the +/- 180 line, so that rendering doesnt make them swing 360 degrees in one tick.
		double dYaw = MathHelper.wrapAngleTo180_double(axes.getYaw() - prevRotationYaw);

		double dPitch = MathHelper.wrapAngleTo180_double(axes.getPitch() - prevRotationPitch);

		double dRoll = MathHelper.wrapAngleTo180_double(axes.getRoll() - prevRotationRoll);
	}

	public void setRotation(float rotYaw, float rotPitch, float rotRoll)
	{
		axes.setAngles(rotYaw, rotPitch, rotRoll);
	}

	@Override
	public float getShadowSize()
	{
		return 0.0F;
	}

	public double getSpeedXYZ()
	{
		return Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
	}

	public double getSpeedXZ()
	{
		return Math.sqrt(motionX * motionX + motionZ * motionZ);
	}
}