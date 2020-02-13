package com.parzivail.pswm.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBlasterProbeBolt extends EntityBlasterBoltBase
{
	public EntityBlasterProbeBolt(World par1World)
	{
		super(par1World, 5.0f);
	}

	public EntityBlasterProbeBolt(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6, 5.0f);
	}

	public EntityBlasterProbeBolt(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 5.0f);
	}

	public EntityBlasterProbeBolt(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, 5.0f);
	}

	@Override
	public void recreate(EntityPlayer hit)
	{
		EntityBlasterBoltBase bolt = new EntityBlasterProbeBolt(this.worldObj, hit);
		this.worldObj.spawnEntityInWorld(bolt);
		this.setDead();
	}
}