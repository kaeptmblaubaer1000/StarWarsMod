package com.parzivail.pswm.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBomb extends EntityBlasterBoltBase
{
	public EntityBomb(World par1World)
	{
		super(par1World, 100.0f);
		this.speed = 2;
	}

	public EntityBomb(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6, 100.0f);
		this.speed = 1;
	}

	public EntityBomb(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 100.0f);
		this.speed = 1;
	}

	public EntityBomb(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, 100.0f);
		this.speed = 1;
	}

	@Override
	protected void onImpact(MovingObjectPosition pos)
	{
		if ((pos.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY && pos.entityHit == getSender()) || this.ticksExisted < 10)
			return;

		super.onImpact(pos);
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 5, true);
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0.2F;
	}

	@Override
	public void recreate(EntityPlayer hit)
	{
		this.setDead();
	}
}
