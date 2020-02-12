package com.parzivail.pswm.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBlasterHeavyBolt extends EntityBlasterBoltBase
{
	public EntityBlasterHeavyBolt(World par1World)
	{
		super(par1World, 8.0f);
	}

	public EntityBlasterHeavyBolt(World world, float dx, float dy, float dz, float length, int rgb)
	{
		super(world, dx, dy, dz, 1.0f, rgb);
	}

	public EntityBlasterHeavyBolt(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 8.0f);
	}

	@Override
	public void recreate(EntityPlayer hit)
	{
		EntityBlasterBoltBase bolt = new EntityBlasterHeavyBolt(this.worldObj, hit);
		this.worldObj.spawnEntityInWorld(bolt);
		this.setDead();
	}
}
