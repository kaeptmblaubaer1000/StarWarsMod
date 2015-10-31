package com.parzi.starwarsmod.mobs;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class MobTusken extends EntityMob implements IMob, IRangedAttackMob
{
	private int angerLevel;
	private Entity angryAt = null;
	private EntityAIArrowAttack aiArrow;

	public MobTusken(World par1World)
	{
		super(par1World);
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setEnterDoors(true);
		this.tasks.addTask(0, new net.minecraft.entity.ai.EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.7D, false));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 0.7D, true));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityZombie.class, 0.7D, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new net.minecraft.entity.ai.EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, false));
		switch (this.rand.nextInt(3))
		{
			case 0:
				this.setCurrentItemOrArmor(0, new ItemStack(StarWarsMod.gaffiStick, 1));
				break;
			case 1:
				this.setCurrentItemOrArmor(0, StarWarsMod.blasterRifle.getMeta("Cycler"));
				this.tasks.addTask(1, this.aiArrow = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
		}
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.55D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
	{
		Entity entity = p_70097_1_.getEntity();
		if (entity instanceof EntityPlayer)
		{
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));
			for (int i = 0; i < list.size(); i++)
			{
				Entity entity1 = (Entity)list.get(i);
				if (entity1 instanceof MobTusken)
				{
					MobTusken tusken = (MobTusken)entity1;
					tusken.becomeAngryAt(entity);
				}
			}
			this.becomeAngryAt(entity);
		}
		return super.attackEntityFrom(p_70097_1_, p_70097_2_);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
	{
		this.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(this.rand, -0.2D, 0.2D));
		this.worldObj.spawnEntityInWorld(new com.parzi.starwarsmod.entities.EntityBlasterRifleBolt(this.worldObj, this, this.getAttackTarget()));
	}

	private void becomeAngryAt(Entity p_70835_1_)
	{
		this.entityToAttack = p_70835_1_;
		this.angerLevel = 400 + this.rand.nextInt(400);
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}

	@Override
	protected String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "mob.tusken.die";
	}

	@Override
	protected String getHurtSound()
	{
		return StarWarsMod.MODID + ":" + "mob.tusken.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return StarWarsMod.MODID + ":" + "mob.tusken.say";
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void onUpdate()
	{
		this.angryAt = this.entityToAttack;
		super.onUpdate();
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobTusken.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */