package com.parzivail.pswm.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySpeederBlasterRifleBolt extends EntityBlasterBoltBase
{
	private static float extent = 3;

	public EntitySpeederBlasterRifleBolt(World par1World)
	{
		super(par1World, 8.0f);
	}

	public EntitySpeederBlasterRifleBolt(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6, 8.0f);
	}

	public EntitySpeederBlasterRifleBolt(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 8.0f);

		Vec3 vec3 = par2EntityLivingBase.getLookVec();
		double dx = vec3.xCoord * EntitySpeederBlasterRifleBolt.extent;
		double dy = vec3.yCoord * EntitySpeederBlasterRifleBolt.extent;
		double dz = vec3.zCoord * EntitySpeederBlasterRifleBolt.extent;

		this.posX += dx;
		this.posY += dy;
		this.posZ += dz;
	}

	@Override
	public void recreate(EntityPlayer hit)
	{
		EntityBlasterBoltBase bolt = new EntitySpeederBlasterRifleBolt(this.worldObj, hit);
		this.worldObj.spawnEntityInWorld(bolt);
		this.setDead();
	}
}
