package com.parzi.starwarsmod.mobs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.ai.AiFreqMove;
import com.parzi.starwarsmod.entities.EntityBlasterProbeBolt;

public class MobDroidProbe extends EntityMob implements IRangedAttackMob
{
	private EntityAIArrowAttack aiArrow;

	public MobDroidProbe(World par1World)
	{
		super(par1World);
		this.setSize(1.0F, 2.0F);
		this.tasks.addTask(1, this.aiArrow = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
		this.tasks.addTask(2, new AiFreqMove(this, 1.0D, 3));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.255D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
	{
		this.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(this.rand, -0.2D, 0.2D));
		this.worldObj.spawnEntityInWorld(new EntityBlasterProbeBolt(this.worldObj, this, p_82196_1_));
	}

	@Override
	public boolean canDespawn()
	{
		return false;
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsMod.spawnProbe, 1);
	}

	@Override
	protected void dropRareDrop(int par1)
	{
	}

	@Override
	protected void fall(float par1)
	{
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}

	@Override
	protected String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "mob.probe.die";
	}

	@Override
	protected String getHurtSound()
	{
		return StarWarsMod.MODID + ":" + "mob.probe.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return StarWarsMod.MODID + ":" + "mob.probe.say";
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobDroidProbe.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */