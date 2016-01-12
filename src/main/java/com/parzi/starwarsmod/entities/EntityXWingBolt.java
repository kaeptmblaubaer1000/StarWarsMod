package com.parzi.starwarsmod.entities;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
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
		double dx = vec3.xCoord * this.extent;
		double dy = vec3.yCoord * this.extent;
		double dz = vec3.zCoord * this.extent;

		this.posX += dx;
		this.posY += dy;
		this.posZ += dz;
	}

	public EntityXWingBolt(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, 16.0f);

		Vec3 vec3 = par2EntityLivingBase.getLookVec();
		double dx = vec3.xCoord * this.extent;
		double dy = vec3.yCoord * this.extent;
		double dz = vec3.zCoord * this.extent;

		this.posX += dx;
		this.posY += dy;
		this.posZ += dz;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\entities\EntityBlasterHeavyBolt.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */