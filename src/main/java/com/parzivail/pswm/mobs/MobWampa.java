package com.parzivail.pswm.mobs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.ai.AiFreqMove;

public class MobWampa extends EntityMob implements IMob
{
	public MobWampa(World par1World)
	{
		super(par1World);
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1, false));
		this.tasks.addTask(1, new AiFreqMove(this, 1, 0));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
		this.setSize(2.0F, 3.0F);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
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