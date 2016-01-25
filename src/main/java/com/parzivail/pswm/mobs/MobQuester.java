package com.parzivail.pswm.mobs;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.ai.AiFreqMove;

public class MobQuester extends EntityCreature
{
	public MobQuester(World par1World)
	{
		super(par1World);
		this.setSize(0.6F, 1.8F);
		this.tasks.addTask(0, new AiFreqMove(this, 1, 0));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		return false;
	}

	@Override
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.commoner.die";
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.commoner.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return Resources.MODID + ":" + "mob.commoner.say";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobJawa.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */