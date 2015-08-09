package com.parzi.starwarsmod.weaponry;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class WeaponSwivelBase extends EntityLiving
{
	public float vehicXOffset = 0;
	public float vehicYOffset = 0;
	public float vehicZOffset = 0;

	public float pitch;

	public WeaponSwivelBase(World p_i1689_1_)
	{
		super(p_i1689_1_);
		setSize(0.9F, 0.9F);
	}

	@Override
	public void fall(float p1)
	{
		return;
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	{
		playSound(StarWarsMod.MODID + ":" + getMovingSound(), 0.15F, 1.0F);
	}

	public String getMovingSound()
	{
		return "vehicle.default.move";
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	@Override
	public boolean interact(EntityPlayer p_70085_1_)
	{
		if (!worldObj.isRemote && (riddenByEntity == null || riddenByEntity == p_70085_1_))
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
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
	{
		if (riddenByEntity != null && riddenByEntity instanceof EntityLivingBase)
		{
			prevRotationYaw = rotationYaw = riddenByEntity.rotationYaw;
			rotationYaw = riddenByEntity.rotationYaw + 180;
			setRotation(riddenByEntity.rotationYaw, riddenByEntity.rotationPitch);
			rotationYawHead = renderYawOffset = rotationYaw;

			pitch = riddenByEntity.rotationPitch;
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		moveEntityWithHeading(0, 0);
	}

	@Override
	public void updateRiderPosition()
	{
		if (riddenByEntity != null)
		{
			riddenByEntity.setPosition(posX + vehicXOffset, posY + getMountedYOffset() + riddenByEntity.getYOffset() + vehicYOffset, posZ + vehicZOffset);
		}
	}
}