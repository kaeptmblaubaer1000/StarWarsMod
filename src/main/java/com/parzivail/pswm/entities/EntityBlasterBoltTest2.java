package com.parzivail.pswm.entities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBlasterBoltTest2 extends EntityBlasterBoltTest
{

	private float look;
	private float yCoord;
	private float look2;
	private float length;
	private int rgb;
	private float damage;

	public EntityBlasterBoltTest2(World world)
	{
		this(world, 0, 0, 0, 1.0f, 0xFF0000, 5);
	}

	public EntityBlasterBoltTest2(World world, float dx, float dy, float dz, float length, int rgb, float damage)
	{
		super(world);
		this.damage = damage;
		setSize(0.1f, 0.1f);
		setDx(dx);
		setDy(dy);
		setDz(dz);
		setLength(length);
		setColor(rgb);
	}

	@Override
	public void recreate(EntityPlayer hit)
	{
		EntityBlasterBoltTest bolt = new EntityBlasterBoltTest2(this.worldObj, this.look, this.yCoord, this.look2, this.length, this.rgb, this.damage);
		this.worldObj.spawnEntityInWorld(bolt);
		this.setDead();
	}
}
