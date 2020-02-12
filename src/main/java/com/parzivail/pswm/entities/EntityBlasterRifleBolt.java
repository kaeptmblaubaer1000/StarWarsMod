package com.parzivail.pswm.entities;

import com.parzivail.util.entity.EntityUtils;
import com.parzivail.util.math.RaytraceHit;
import com.parzivail.util.math.RotatedAxes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBlasterRifleBolt extends EntityBlasterBoltBase
{
	public EntityBlasterRifleBolt(World par1World)
	{
		super(par1World, 5.0f);
	}

	public EntityBlasterRifleBolt(World world, float dx, float dy, float dz, float length, int rgb)
	{
		super(world, dx, dy, dz, 1.0f, rgb);
	}

	public EntityBlasterRifleBolt(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 5.0f);
	}

	public EntityBlasterRifleBolt(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, 5.0f);
	}

	@Override
	public void recreate(EntityPlayer player)
	{
//		EntityBlasterBoltBase bolt = new EntityBlasterRifleBolt(this.worldObj, hit);
//		bolt.setPosition(hit.playerLocation.posX, hit.playerLocation.posY + hit.getEyeHeight(), hit.playerLocation.posZ);
//		this.worldObj.spawnEntityInWorld(bolt);
		RotatedAxes ra = new RotatedAxes(270 - player.rotationYaw, -player.rotationPitch, 0);

		Vec3 look = Vec3.createVectorHelper(Math.cos(ra.getPitch() / 180f * Math.PI) * Math.cos(ra.getYaw() / 180f * Math.PI), Math.sin(ra.getPitch() / 180f * Math.PI), Math.cos(ra.getPitch() / 180f * Math.PI) * Math.sin(-ra.getYaw() / 180f * Math.PI));
		RaytraceHit hit2 = EntityUtils.rayTrace(look, 5, player, new Entity[0], true);

		EntityBlasterBoltBase e = new EntityBlasterRifleBolt(this.worldObj, player);
		e.setPosition(player.posX, player.posY + player.getEyeHeight(), player.posZ);
		this.worldObj.spawnEntityInWorld(e);

		this.setDead();
	}
}
