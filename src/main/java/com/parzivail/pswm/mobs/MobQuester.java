package com.parzivail.pswm.mobs;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.ai.AiFreqMove;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MobQuester extends EntityCreature
{
	public MobQuester(World par1World)
	{
		super(par1World);
		setSize(0.6F, 1.8F);
		tasks.addTask(0, new AiFreqMove(this, 1, 0));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
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

	@Override
	public boolean interact(EntityPlayer player)
	{
		return false;
	}
}
