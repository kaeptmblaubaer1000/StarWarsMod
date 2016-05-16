package com.parzivail.pswm.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityBlasterEzraBolt extends EntityBlasterBoltBase
{
	public EntityBlasterEzraBolt(World par1World)
	{
		super(par1World, 2.0f);
	}

	public EntityBlasterEzraBolt(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6, 2.0f);
	}

	public EntityBlasterEzraBolt(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 2.0f);
	}
}
