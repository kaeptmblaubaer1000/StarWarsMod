package com.parzivail.pswm.entities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBlasterBoltFX extends EntityBlasterBoltBaseFX
{

	private float look;
	private float yCoord;
	private float look2;
	private float length;
	private int rgb;
	private float damage;

	public EntityBlasterBoltFX(World world)
	{
		this(world, 0xFF0000, 5);
	}

	public EntityBlasterBoltFX(World world, int rgb, float damage)
	{
		super(world);
		this.damage = damage;
		setSize(0.1f, 0.1f);
//		setDx(dx);
//		setDy(dy);
//		setDz(dz);
//		setLength(length);
		setColor(rgb);
	}

	public EntityBlasterBoltFX(World par1World, double par2, double par4, double par6, float damage)
	{
		super(par1World, par2, par4, par6);
		this.damage = damage;
	}

	@Override
	public void recreate(EntityPlayer hit)
	{
//		EntityBlasterBoltFX bolt = new EntityBlasterBoltFX(this.worldObj, this.look, this.yCoord, this.look2, this.length, this.rgb, this.damage);
//		this.worldObj.spawnEntityInWorld(bolt);
//		this.setDead();
	}
}
