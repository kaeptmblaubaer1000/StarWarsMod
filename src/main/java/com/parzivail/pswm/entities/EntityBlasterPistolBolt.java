package com.parzivail.pswm.entities;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.jedirobes.ArmorJediRobes;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBlasterPistolBolt extends EntityBlasterBoltBase
{
	public EntityBlasterPistolBolt(World par1World)
	{
		super(par1World, 2.0f);
	}

	public EntityBlasterPistolBolt(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6, 2.0f);
	}

	public EntityBlasterPistolBolt(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase, 2.0f);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\entities\EntityBlasterPistolBolt.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */