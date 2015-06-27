package com.parzi.starwarsmod.vehicles;

import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class VehicleLandBase extends EntityLiving
{
	public float vehicXOffset = 0;
	public float vehicYOffset = 0;
	public float vehicZOffset = 0;

	public float moveModifier = 1F;

	public VehicleLandBase(World p_i1689_1_)
	{
		super(p_i1689_1_);
		this.setSize(0.9F, 0.9F);
	}

	@Override
	public void fall(float p1)
	{
		return;
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	public String getMovingSound()
	{
		return "vehicle.default.move";
	}

	@Override
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
		{
			this.riddenByEntity.setPosition(this.posX + this.vehicXOffset, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + this.vehicYOffset, this.posZ + this.vehicZOffset);
		}
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	{
		this.playSound(StarWarsMod.MODID + ":" + this.getMovingSound(), 0.15F, 1.0F);
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	@Override
	public boolean interact(EntityPlayer p_70085_1_)
	{
		if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == p_70085_1_))
		{
			p_70085_1_.mountEntity(this);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		this.moveEntityWithHeading(0, 0);
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
	{
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase)
		{
			this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
			this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
			p_70612_1_ = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
			p_70612_2_ = ((EntityLivingBase)this.riddenByEntity).moveForward * (moveModifier / 8);

			if (this.onGround)
			{
				float f2 = MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F);
				float f3 = MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F);
				this.motionX += (double)(-0.4F * f2 * p_70612_2_);
				this.motionZ += (double)(0.4F * f3 * p_70612_2_);
			}

			this.stepHeight = 1.0F;
			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

			if (!this.worldObj.isRemote)
			{
				this.setAIMoveSpeed(p_70612_2_);
				super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
			}
		}
	}
}