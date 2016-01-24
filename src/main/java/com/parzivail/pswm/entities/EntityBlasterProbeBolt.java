package com.parzivail.pswm.entities;

import net.minecraft.entity.EntityLivingBase;
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
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\entities\EntityBlasterProbeBolt.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */