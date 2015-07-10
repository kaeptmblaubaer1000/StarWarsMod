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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class MobDroidProtocol extends EntityAnimal implements IAnimals
{
	public MobDroidProtocol(World par1World)
	{
		super(par1World);
		this.setSize(1, 2);
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
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if (this.rand.nextInt(1000) == 0 && this.worldObj.findNearestEntityWithinAABB(MobDroidAstromech.class, this.boundingBox.expand(5, 5, 5), this) instanceof MobDroidAstromech) {
			this.playSound(StarWarsMod.MODID + ":" + "mob.protocol.r2d2rare", 1F, 1F);
		}
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
		return StarWarsMod.spawnProtocol;
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

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_)
	{
		// TODO Auto-generated method stub
		return null;
	}
}