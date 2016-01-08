package com.parzi.starwarsmod.mobs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzi.starwarsmod.Resources;

public class MobWampa extends EntityMob implements IMob
{
	public MobWampa(World par1World)
	{
		super(par1World);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.7D, false));
		this.tasks.addTask(5, new net.minecraft.entity.ai.EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(9, new net.minecraft.entity.ai.EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.setSize(2.0F, 3.0F);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.55D);
	}

	@Override
	public boolean getCanSpawnHere()
	{
		int i = MathHelper.floor_double(this.boundingBox.minY);
		if (i >= 63)
			return false;
		int j = MathHelper.floor_double(this.posX);
		int k = MathHelper.floor_double(this.posZ);
		int l = this.worldObj.getBlockLightValue(j, i, k);
		byte b0 = 4;
		b0 = 7;
		if (this.rand.nextInt(100) < 90)
			return false;
		return l > this.rand.nextInt(b0) ? false : super.getCanSpawnHere();
	}

	@Override
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.wampa.die";
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.wampa.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return Resources.MODID + ":" + "mob.wampa.say";
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobWampa.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */