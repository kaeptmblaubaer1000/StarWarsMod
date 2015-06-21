package com.parzi.starwarsmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityBlasterBolt extends EntityThrowable
{
	private EntityPlayer sender;
	private int timeAlive = 0;

	public EntityBlasterBolt(World par1World)
	{
		super(par1World);
	}

	public EntityBlasterBolt(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
		sender = (EntityPlayer)par2EntityLivingBase;
	}

	public EntityBlasterBolt(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer p_70100_1_)
	{
		return;
	}

	@Override
	public void onUpdate()
	{
		if (timeAlive++ > 100)
		{
			this.setDead();
		}
		super.onUpdate();
	}

	@Override
	protected void onImpact(MovingObjectPosition pos)
	{
		if (pos.typeOfHit == MovingObjectType.ENTITY && pos.entityHit != sender)
		{
			pos.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(sender), 5f);
			pos.entityHit.setFire(8);
		}
		else
		{
			if (worldObj.getBlock(pos.blockX, pos.blockY + 1, pos.blockZ) == Blocks.air)
			{
				worldObj.setBlock(pos.blockX, pos.blockY + 1, pos.blockZ, Blocks.fire);
			}
		}
		this.setDead();
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0f;
	}
}