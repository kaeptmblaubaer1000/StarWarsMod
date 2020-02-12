package com.parzivail.pswm.entities;

import com.parzivail.util.entity.EntityUtils;
import com.parzivail.util.math.RaytraceHit;
import com.parzivail.util.math.RotatedAxes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBlasterVariableBolt extends EntityBlasterBoltBase
{
	public EntityBlasterVariableBolt(World par1World)
	{
		super(par1World, 3);
	}

	public EntityBlasterVariableBolt(World par1World, float damage)
	{
		super(par1World, damage);
	}

	public EntityBlasterVariableBolt(World world, float dx, float dy, float dz, float length, int rgb)
	{
		super(world, dx, dy, dz, 1.0f, rgb);
	}

	public EntityBlasterVariableBolt(World par1World, EntityLivingBase par2EntityLivingBase, float damage)
	{
		super(par1World, par2EntityLivingBase, damage);
	}

	@Override
	public void recreate(EntityPlayer player)
	{
		//Lumberjack.log(hit);
//		EntityBlasterBoltBase bolt = new EntityBlasterVariableBolt(this.worldObj, hit, 3.0f);
//		this.worldObj.spawnEntityInWorld(bolt);
//		this.setDead();

		RotatedAxes ra = new RotatedAxes(270 - player.rotationYaw, -player.rotationPitch, 0);

		Vec3 look = Vec3.createVectorHelper(Math.cos(ra.getPitch() / 180f * Math.PI) * Math.cos(ra.getYaw() / 180f * Math.PI), Math.sin(ra.getPitch() / 180f * Math.PI), Math.cos(ra.getPitch() / 180f * Math.PI) * Math.sin(-ra.getYaw() / 180f * Math.PI));
		RaytraceHit hit2 = EntityUtils.rayTrace(look, 5, player, new Entity[0], true);

		EntityBlasterBoltBase e = new EntityBlasterRifleBolt(this.worldObj, player);
		e.setPosition(player.posX, player.posY + player.getEyeHeight(), player.posZ);
		this.worldObj.spawnEntityInWorld(e);

		this.setDead();
	}
}
