package com.parzi.starwarsmod.mobs;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class MobDroidProtocol extends EntityLiving implements IAnimals
{
	public MobDroidProtocol(World par1World)
	{
		super(par1World);
		// this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
		// EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
	}

	@Override
	protected String getLivingSound()
	{
		return StarWarsMod.MODID + ":" + "mob.protocol.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return StarWarsMod.MODID + ":" + "mob.protocol.hit";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "mob.protocol.die";
	}

	@Override
	protected Item getDropItem()
	{
		return Items.iron_ingot;
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}
	
	@Override
    protected float getSoundPitch()
    {
        return 1.0F;
    }

	@Override
	protected void dropRareDrop(int par1)
	{
		/*
		 * switch (this.rand.nextInt(1)) { case 0:
		 * this.dropItem(StarWarsMod.gaffiStick, 1); break; }
		 */
	}
}