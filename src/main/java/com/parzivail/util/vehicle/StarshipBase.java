package com.parzivail.util.vehicle;

import com.parzivail.pswm.utils.StatTrack;
import com.parzivail.util.math.RotatedAxes;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by colby on 9/30/2016.
 */
public class StarshipBase extends EntityLiving
{
	public ShipMovementHandler shipMovementHandler;
	private boolean canMove = true;
	private boolean canCollide = false;

	public StarshipBase(World world)
	{
		super(world);
		shipMovementHandler = new ShipMovementHandler(this);
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
	{
		// Do nothing. Should never be called.
	}

	@Override
	protected boolean isMovementBlocked()
	{
		return this.getHealth() <= 0.0F || !this.canMove;
	}

	@Override
	protected boolean interact(EntityPlayer player)
	{
		if (!this.worldObj.isRemote && this.riddenByEntity == null)
		{
			shipMovementHandler.rotation.xCoord = 90;

			shipMovementHandler.velocity = Vec3.createVectorHelper(0, 0, 0);

			player.mountEntity(this);
			StatTrack.addStat("ride-" + this.getCommandSenderName().replaceAll("\\W", ""));
			return true;
		}
		return false;
	}

	private void starshipFly()
	{
		this.handleMovementInput();
		this.calculateVelocity();
		this.calculateRotation();
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
	}

	private void calculateRotation()
	{
		if (this.riddenByEntity == null)
		{
			shipMovementHandler.rotation.xCoord = 0;
			shipMovementHandler.rotation.zCoord = 0;
		} else
		{
			//GFX.changeCameraRoll((float)-shipMovementHandler.getRoll());
			//this.riddenByEntity.rotationYaw = 0;//(float)(MathHelper.sin((float)shipMovementHandler.getRollRad()) * shipMovementHandler.getPitch());
			//this.riddenByEntity.rotationPitch = (float)shipMovementHandler.getPitch();//(float)(MathHelper.cos((float)shipMovementHandler.getRollRad()) * shipMovementHandler.getPitch());

			//GFX.changeCameraRoll((float)(-shipMovementHandler.rotation.zCoord));
			//this.riddenByEntity.rotationYaw = -(float)(shipMovementHandler.rotation.xCoord * MathHelper.sin((float)(-shipMovementHandler.rotation.zCoord / 180 * Math.PI)));
			//this.riddenByEntity.rotationPitch = (float)(shipMovementHandler.rotation.xCoord * MathHelper.cos((float)(-shipMovementHandler.rotation.zCoord / 180 * Math.PI)));
		}
	}

	public RotatedAxes getAxes()
	{
		return shipMovementHandler.rotatedAxes;
	}

	@Override
	public Vec3 getLookVec()
	{
		float f1;
		float f2;
		float f3;
		float f4;

		f1 = MathHelper.cos((float)(-shipMovementHandler.rotation.yCoord * 0.017453292F - (float)Math.PI));
		f2 = MathHelper.sin((float)(-shipMovementHandler.rotation.yCoord * 0.017453292F - (float)Math.PI));
		f3 = -MathHelper.cos((float)(-shipMovementHandler.rotation.xCoord * 0.017453292F));
		f4 = MathHelper.sin((float)(-shipMovementHandler.rotation.xCoord * 0.017453292F));
		return Vec3.createVectorHelper((double)(f2 * f3), (double)f4, (double)(f1 * f3));
	}

	private Matrix4f Rotation(float angle, Vec3 v)
	{
		Matrix4f m = new Matrix4f();
		// Angle in radians.
		float radians = (float)Math.toRadians(angle);

		// Rotations.
		float s = MathHelper.sin(radians);
		float c = MathHelper.cos(radians);
		float t = 1.0F - c;

		float x = (float)v.xCoord, y = (float)v.yCoord, z = (float)v.zCoord;

		m.m00 = t * x * x + c;
		m.m10 = t * x * y + s * z;
		m.m20 = t * x * z - s * y;
		m.m30 = 0.0F;

		m.m01 = t * y * x - s * z;
		m.m11 = t * y * y + c;
		m.m21 = t * y * z + s * x;
		m.m31 = 0.0F;

		m.m02 = t * z * x + s * y;
		m.m12 = t * z * y - s * x;
		m.m22 = t * z * z + c;
		m.m32 = 0.0F;

		m.m03 = 0.0F;
		m.m13 = 0.0F;
		m.m23 = 0.0F;
		m.m33 = 1.0F;

		return m;
	}

	public void setRotationFromVector(Vec3 vector)
	{
		double f3 = MathHelper.sqrt_double(vector.xCoord * vector.xCoord + vector.zCoord * vector.zCoord);
		this.prevRotationYaw = this.rotationYaw = -(float)(Math.atan2(vector.xCoord, vector.zCoord) * 180.0D / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(vector.yCoord, f3) * 180.0D / Math.PI);
	}

	private void calculateVelocity()
	{
		this.setVelocity(shipMovementHandler.velocity.xCoord, shipMovementHandler.velocity.yCoord, shipMovementHandler.velocity.zCoord);
	}

	@Override
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
		{
			this.riddenByEntity.setPosition(this.posX, this.posY, this.posZ);
		}
	}

	@Override
	public void onLivingUpdate()
	{
		/*
			Stop movement if it's negligible
		 */
		if (Math.abs(this.motionX) < 0.005D)
		{
			this.motionX = 0.0D;
		}

		if (Math.abs(this.motionY) < 0.005D)
		{
			this.motionY = 0.0D;
		}

		if (Math.abs(this.motionZ) < 0.005D)
		{
			this.motionZ = 0.0D;
		}

		/*
			AI
		 */
		this.worldObj.theProfiler.startSection("ai");

		if (this.isMovementBlocked())
		{
			this.isJumping = false;
			this.moveStrafing = 0.0F;
			this.moveForward = 0.0F;
			this.randomYawVelocity = 0.0F;
		}

		this.worldObj.theProfiler.endSection();

		/*
			Movement
		 */
		this.worldObj.theProfiler.startSection("travel");
		this.starshipFly();
		this.worldObj.theProfiler.endSection();

		/*
			Collision
		 */
		this.worldObj.theProfiler.startSection("push");

		if (!this.worldObj.isRemote && canCollide)
		{
			this.collideWithNearbyEntities();
		}

		this.worldObj.theProfiler.endSection();
	}

	@Override
	public void readFromNBT(NBTTagCompound p_70020_1_)
	{
		super.readFromNBT(p_70020_1_);
		shipMovementHandler.loadMovement(p_70020_1_);
	}

	@Override
	public void writeToNBT(NBTTagCompound p_70109_1_)
	{
		super.writeToNBT(p_70109_1_);
		shipMovementHandler.saveMovement(p_70109_1_);
	}

	@Override
	public ItemStack getHeldItem()
	{
		return null;
	}

	@Override
	public ItemStack getEquipmentInSlot(int i)
	{
		return null;
	}

	@Override
	public void setCurrentItemOrArmor(int i, ItemStack stack)
	{

	}

	@Override
	public ItemStack[] getLastActiveItems()
	{
		return new ItemStack[0];
	}

	public void handleMovementInput()
	{
		shipMovementHandler.handleMovement();
	}
}