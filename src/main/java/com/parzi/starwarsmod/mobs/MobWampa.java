package com.parzi.starwarsmod.mobs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class MobWampa extends EntityMob implements IMob
{
	public MobWampa(World par1World)
	{
		super(par1World);
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.7D, false));
		tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		tasks.addTask(7, new EntityAIWander(this, 1.0D));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(8, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		setSize(2, 3);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0D);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(45.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.55);
	}

	@Override
	public boolean getCanSpawnHere()
	{
		int i = MathHelper.floor_double(boundingBox.minY);

		if (i >= 63)
		{
			return false;
		}
		else
		{
			int j = MathHelper.floor_double(posX);
			int k = MathHelper.floor_double(posZ);
			int l = worldObj.getBlockLightValue(j, i, k);
			byte b0 = 4;

			b0 = 7;

			if (rand.nextInt(100) < 90) { return false; }

			return l > rand.nextInt(b0) ? false : super.getCanSpawnHere();
		}
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	 @Override
	 protected String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "mob.wampa.die";
	}

	 /**
	  * Returns the sound this mob makes when it is hurt.
	  */
	 @Override
	 protected String getHurtSound()
	 {
		 return StarWarsMod.MODID + ":" + "mob.wampa.hit";
	 }

	 @Override
	 protected String getLivingSound()
	 {
		 return StarWarsMod.MODID + ":" + "mob.wampa.say";
	 }

	 @Override
	protected boolean isAIEnabled()
	{
		return true;
	}
}