package com.parzivail.util.vehicle;

import com.parzivail.pswm.utils.StatTrack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * Created by colby on 9/30/2016.
 */
public class StarshipBase extends EntityLiving
{
	private ShipMovementHandler shipMovementHandler;
	private boolean canMove = true;
	private boolean canCollide = false;

	public StarshipBase(World world)
	{
		super(world);
		shipMovementHandler = new ShipMovementHandler(this);
	}

	@Override
	public void mountEntity(Entity entity)
	{
		super.mountEntity(entity);

		shipMovementHandler.rotation = entity.getLookVec();
	}

	@Override
	public void dismountEntity(Entity entity)
	{
		super.dismountEntity(entity);

		shipMovementHandler.rotation.xCoord = 90;
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
		this.setRotationFromVector(this.shipMovementHandler.rotation);
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
	public void onLivingUpdate()
	{
		/*
			Enforce movement and rotation
		 */
		if (this.newPosRotationIncrements > 0)
		{
			double d0 = this.posX + (this.newPosX - this.posX) / (double)this.newPosRotationIncrements;
			double d1 = this.posY + (this.newPosY - this.posY) / (double)this.newPosRotationIncrements;
			double d2 = this.posZ + (this.newPosZ - this.posZ) / (double)this.newPosRotationIncrements;
			double d3 = MathHelper.wrapAngleTo180_double(this.newRotationYaw - (double)this.rotationYaw);
			this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.newPosRotationIncrements);
			this.rotationPitch = (float)((double)this.rotationPitch + (this.newRotationPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
			--this.newPosRotationIncrements;
			this.setPosition(d0, d1, d2);
			this.setRotation(this.rotationYaw, this.rotationPitch);
		} else if (!this.isClientWorld())
		{
			this.motionX *= 0.98D;
			this.motionY *= 0.98D;
			this.motionZ *= 0.98D;
		}

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
		} else if (this.isClientWorld())
		{
			this.worldObj.theProfiler.startSection("oldAi");
			this.updateEntityActionState();
			this.worldObj.theProfiler.endSection();
			this.rotationYawHead = this.rotationYaw;
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