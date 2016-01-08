package com.parzi.starwarsmod.weaponry;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.parzi.starwarsmod.Resources;

public class WeaponSwivelBase extends EntityLiving
{
	public float vehicXOffset = 0.0F;
	public float vehicYOffset = 0.0F;
	public float vehicZOffset = 0.0F;
	public float pitch;

	public WeaponSwivelBase(World p_i1689_1_)
	{
		super(p_i1689_1_);
		this.setSize(0.9F, 0.9F);
	}

	@Override
	public void fall(float p1)
	{
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	{
		this.playSound(Resources.MODID + ":" + this.getMovingSound(), 0.15F, 1.0F);
	}

	public String getMovingSound()
	{
		return "vehicle.default.move";
	}

	@Override
	public boolean interact(EntityPlayer p_70085_1_)
	{
		if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == p_70085_1_))
		{
			p_70085_1_.mountEntity(this);
			return true;
		}
		return false;
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
	{
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase)
		{
			this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
			this.rotationYaw = this.riddenByEntity.rotationYaw + 180.0F;
			this.setRotation(this.riddenByEntity.rotationYaw, this.riddenByEntity.rotationPitch);
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
			this.pitch = this.riddenByEntity.rotationPitch;
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		this.moveEntityWithHeading(0.0F, 0.0F);
	}

	@Override
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
			this.riddenByEntity.setPosition(this.posX + this.vehicXOffset, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + this.vehicYOffset, this.posZ + this.vehicZOffset);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\weaponry\WeaponSwivelBase.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */