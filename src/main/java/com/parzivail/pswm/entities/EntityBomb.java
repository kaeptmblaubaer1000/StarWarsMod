package com.parzivail.pswm.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBomb extends EntityBlasterBoltBase
{
	public EntityBomb(World par1World)
	{
		super(par1World, 5.0f);
		this.speed = 2;
	}

	public EntityBomb(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6, 5.0f);
		this.speed = 1;
	}

	public EntityBomb(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 5.0f);
		this.speed = 1;
	}

	public EntityBomb(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, 5.0f);
		this.speed = 1;
	}

	@Override
	protected void onImpact(MovingObjectPosition pos)
	{
		super.onImpact(pos);
		if (pos.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 5, true);
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0.2F;
	}
}
