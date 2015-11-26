package com.parzi.starwarsmod.vehicles;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.Lumberjack;

public class VehicleAirBase extends VehicleBase
{

	public VehicleAirBase(World p_i1689_1_)
	{
		super(p_i1689_1_);
	}
	
	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
	{
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer)
		{
			this.motionY = -(((EntityPlayer)this.riddenByEntity).rotationPitch / 180F) * ((EntityLivingBase)this.riddenByEntity).moveForward * this.moveModifier;

			this.rotationLast = this.rotationYaw = this.riddenByEntity.rotationYaw;
			this.rotationPitchLast = this.rotationPitch = ((EntityPlayer)this.riddenByEntity).rotationPitch;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
			p_70612_1_ = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
			p_70612_2_ = ((EntityLivingBase)this.riddenByEntity).moveForward * (this.moveModifier / 8.0F) * (1 - Math.abs(((EntityPlayer)this.riddenByEntity).rotationPitch / 90F));

			float f2 = MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F);
			float f3 = MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F);
			this.motionX += (-0.4F * f2 * p_70612_2_);
			this.motionZ += (0.4F * f3 * p_70612_2_);

			this.stepHeight = 1.0F;
			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
			if (!this.worldObj.isRemote)
			{
				//this.setAIMoveSpeed(p_70612_2_);
				super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
			}
		}
		else
		{
			this.motionY = 0;
			super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
		}
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if ((int)this.posX != (int)this.prevPosX || (int)this.posY != (int)this.prevPosY || (int)this.posZ != (int)this.prevPosZ)
		{
			this.playSound(StarWarsMod.MODID + ":" + this.getMovingSound(), 1, 1);
		}
	}
}