package com.parzi.starwarsmod.mobs;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class MobGNK extends EntityLiving implements IAnimals
{
	public MobGNK(World par1World)
	{
		super(par1World);
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
	}

	@Override
	protected String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "mob.gonk.die";
	}

	@Override
	protected String getLivingSound()
	{
		return StarWarsMod.MODID + ":" + "mob.gonk.say";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobGNK.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */