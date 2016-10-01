package com.parzivail.util.vehicle;

import com.parzivail.pswm.utils.StatTrack;
import com.parzivail.util.ui.GFX;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

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
			GFX.changeCameraRoll(-(float)shipMovementHandler.rotation.zCoord);
			this.riddenByEntity.rotationPitch = (float)shipMovementHandler.rotation.xCoord;
		}
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