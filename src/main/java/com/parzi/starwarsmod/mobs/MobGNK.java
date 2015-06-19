package com.parzi.starwarsmod.mobs;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class MobGNK extends EntityLiving {
	public MobGNK(World par1World) {
		super(par1World);
		this.tasks.addTask(4, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(1.0D);
	}

	@Override
	protected String getLivingSound() {
		return StarWarsMod.MODID + ":" + "mob.jawa.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound() {
		return StarWarsMod.MODID + ":" + "mob.jawa.hit";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound() {
		return StarWarsMod.MODID + ":" + "mob.jawa.die";
	}
}