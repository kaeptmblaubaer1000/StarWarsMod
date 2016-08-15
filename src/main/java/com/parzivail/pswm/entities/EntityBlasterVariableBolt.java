package com.parzivail.pswm.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBlasterVariableBolt extends EntityBlasterBoltBase
{
	public EntityBlasterVariableBolt(World par1World)
	{
		super(par1World, 3);
	}

	public EntityBlasterVariableBolt(World par1World, float damage)
	{
		super(par1World, damage);
	}

	public EntityBlasterVariableBolt(World par1World, double par2, double par4, double par6, float damage)
	{
		super(par1World, par2, par4, par6, damage);
	}

	public EntityBlasterVariableBolt(World par1World, EntityLivingBase par2EntityLivingBase, float damage)
	{
		super(par1World, par2EntityLivingBase, damage);
	}

	@Override
	public void recreate(EntityPlayer hit)
	{
		//Lumberjack.log(hit);
		EntityBlasterBoltBase bolt = new EntityBlasterVariableBolt(this.worldObj, hit, 3.0f);
		this.worldObj.spawnEntityInWorld(bolt);
		this.setDead();
	}
}
