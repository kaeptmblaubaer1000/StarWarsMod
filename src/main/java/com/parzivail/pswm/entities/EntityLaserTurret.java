package com.parzivail.pswm.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityLaserTurret extends EntityLaserTurretBase
{
	public EntityLaserTurret(World par1World)
	{
		super(par1World, 10.0f);
	}

	public EntityLaserTurret(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6, 10.0f);
	}

	public EntityLaserTurret(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 10.0f);
	}

	@Override
	public void recreate(EntityPlayer hit)
	{
		EntityLaserTurretBase bolt = new EntityLaserTurret(this.worldObj, hit);
		this.worldObj.spawnEntityInWorld(bolt);
		this.setDead();
	}
}
