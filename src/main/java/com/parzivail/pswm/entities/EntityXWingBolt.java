package com.parzivail.pswm.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityXWingBolt extends EntityBlasterBoltBase
{
	private static float extent = 6;

	public EntityXWingBolt(World par1World)
	{
		super(par1World, 16.0f);
	}

	public EntityXWingBolt(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6, 16.0f);
	}

	public EntityXWingBolt(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 16.0f);

		Vec3 vec3 = par2EntityLivingBase.getLookVec();
		double dx = vec3.xCoord * EntityXWingBolt.extent;
		double dy = vec3.yCoord * EntityXWingBolt.extent;
		double dz = vec3.zCoord * EntityXWingBolt.extent;

		this.posX += dx;
		this.posY += dy;
		this.posZ += dz;
	}

	public EntityXWingBolt(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, 16.0f);

		Vec3 vec3 = par2EntityLivingBase.getLookVec();
		double dx = vec3.xCoord * EntityXWingBolt.extent;
		double dy = vec3.yCoord * EntityXWingBolt.extent;
		double dz = vec3.zCoord * EntityXWingBolt.extent;

		this.posX += dx;
		this.posY += dy;
		this.posZ += dz;
	}
}
