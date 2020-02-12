package com.parzivail.pswm.entities;

import com.parzivail.util.entity.EntityUtils;
import com.parzivail.util.math.RaytraceHit;
import com.parzivail.util.math.RaytraceHitEntity;
import com.parzivail.util.math.RotatedAxes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBlasterBoltEntity extends EntityBlasterBoltBaseFX
{

	private float look;
	private float yCoord;
	private float look2;
	private float length;
	private int rgb;
	private float damage;

	public EntityBlasterBoltEntity(World world)
	{
		this(world, 0, 0, 0, 1.0f, 0xFF0000, 5);
	}

	public EntityBlasterBoltEntity(World world, float dx, float dy, float dz, float length, int rgb, float damage)
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
	public void recreate(EntityPlayer player)
	{
		this.setDead();
		RotatedAxes ra = new RotatedAxes(270 - player.rotationYaw, -player.rotationPitch, 0);

		float hS = (worldObj.rand.nextFloat() * 2 - 1) * 2;
		float vS = (worldObj.rand.nextFloat() * 2 - 1) * 2;

		float hSR = 1 - 5;
		float vSR = 1 - 5;

		ra.rotateGlobalYaw(hS * hSR);
		ra.rotateGlobalPitch(vS * vSR);
		Vec3 look = Vec3.createVectorHelper(Math.cos(ra.getPitch() / 180f * Math.PI) * Math.cos(ra.getYaw() / 180f * Math.PI), Math.sin(ra.getPitch() / 180f * Math.PI), Math.cos(ra.getPitch() / 180f * Math.PI) * Math.sin(-ra.getYaw() / 180f * Math.PI));
		RaytraceHit hit = EntityUtils.rayTrace(look, 100, player, new Entity[0], true);

		Entity e = new EntityBlasterBoltEntity(this.worldObj, (float)look.xCoord, (float)look.yCoord, (float)look.zCoord, 10, 0xFF0000, 5.0f);
		e.setPosition(player.posX, player.posY + player.getEyeHeight(), player.posZ);
		worldObj.spawnEntityInWorld(e);

		if (hit instanceof RaytraceHitEntity && ((RaytraceHitEntity)hit).entity instanceof EntityLiving)
		{
			EntityLiving entity = (EntityLiving)((RaytraceHitEntity)hit).entity;
			entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 10);
		}
	}
}
