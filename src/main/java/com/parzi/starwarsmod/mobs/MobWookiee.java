package com.parzi.starwarsmod.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class MobWookiee extends EntityAnimal implements IAnimals
{
	public MobWookiee(World par1World)
	{
		super(par1World);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
	}

	@Override
	protected String getLivingSound()
	{
		return StarWarsMod.MODID + ":" + "mob.wookiee.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return StarWarsMod.MODID + ":" + "mob.wookiee.hit";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "mob.wookiee.die";
	}

	@Override
	protected Item getDropItem()
	{
		return Items.leather;
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		/*
		 * switch (this.rand.nextInt(1)) { case 0:
		 * this.dropItem(StarWarsMod.gaffiStick, 1); break; }
		 */
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_)
	{
		// TODO Auto-generated method stub
		return null;
	}
}