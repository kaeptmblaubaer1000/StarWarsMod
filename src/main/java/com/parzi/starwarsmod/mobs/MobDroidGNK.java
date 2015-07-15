package com.parzi.starwarsmod.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class MobDroidGNK extends EntityAnimal implements IAnimals
{
	public MobDroidGNK(World par1World)
	{
		super(par1World);
		this.setSize(1, 1);
		this.tasks.taskEntries.clear();
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new EntityAITempt(this, 2.0D, StarWarsMod.droidCaller, false));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
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
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsMod.spawnGonk, 1);
	}
	@Override
	protected String getLivingSound()
	{
		return StarWarsMod.MODID + ":" + "mob.gonk.say";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "mob.gonk.die";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_)
	{
		// TODO Auto-generated method stub
		return null;
	}
}