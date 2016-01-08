package com.parzi.starwarsmod.mobs;

import java.util.ArrayList;
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
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.LootGenUtils;
import com.parzi.util.entity.trade.WeightedLoot;

public class MobSandtrooper extends EntityMob implements IMob, IRangedAttackMob
{
	private int angerLevel;
	private Entity angryAt = null;
	private EntityAIArrowAttack aiArrow;

	public MobSandtrooper(World par1World)
	{
		super(par1World);
		this.setSize(0.5F, 1.5F);
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setEnterDoors(true);
		this.tasks.addTask(0, new net.minecraft.entity.ai.EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.7D, false));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityZombie.class, 0.7D, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new net.minecraft.entity.ai.EntityAIHurtByTarget(this, true));
		this.setCurrentItemOrArmor(4, new ItemStack(StarWarsMod.sandtrooperHelmet, 1));
		this.setCurrentItemOrArmor(3, new ItemStack(StarWarsMod.sandtrooperChest, 1));
		this.setCurrentItemOrArmor(2, new ItemStack(StarWarsMod.sandtrooperLegs, 1));
		this.setCurrentItemOrArmor(1, new ItemStack(StarWarsMod.sandtrooperBoots, 1));
		switch (this.rand.nextInt(4))
		{
			case 0:
				this.setCurrentItemOrArmor(0, StarWarsMod.blasterRifle.getMeta("Stormtrooper"));
				break;
			case 1:
				this.setCurrentItemOrArmor(0, StarWarsMod.blasterHeavy.getMeta("T21"));
				break;
			case 2:
				this.setCurrentItemOrArmor(0, StarWarsMod.blasterHeavy.getMeta("Dlt19"));
				break;
			case 3:
				this.setCurrentItemOrArmor(0, StarWarsMod.blasterHeavy.getMeta("Rt97c"));
				break;
		}
		this.tasks.addTask(1, this.aiArrow = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
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
				if (entity1 instanceof MobSandtrooper)
				{
					MobSandtrooper s = (MobSandtrooper)entity1;
					s.becomeAngryAt(entity);
					this.angryAt = entity;
				}
			}
			this.becomeAngryAt(entity);
		}
		return super.attackEntityFrom(p_70097_1_, p_70097_2_);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
	{
		if (this.angryAt != null)
		{
			this.playSound(Resources.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(this.rand, -0.2D, 0.2D));
			this.worldObj.spawnEntityInWorld(new com.parzi.starwarsmod.entities.EntityBlasterRifleBolt(this.worldObj, this, this.getAttackTarget()));
		}
	}

	private void becomeAngryAt(Entity p_70835_1_)
	{
		this.entityToAttack = p_70835_1_;
		this.angerLevel = 400 + this.rand.nextInt(400);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		List<WeightedLoot> drop = new ArrayList();
		drop.add(new WeightedLoot(StarWarsMod.blasterRifle.getMeta("Stormtrooper"), LootGenUtils.baseRarity / 2.0F));
		drop.add(new WeightedLoot(StarWarsMod.blasterHeavy.getMeta("T21"), LootGenUtils.baseRarity / 2.0F));
		drop.add(new WeightedLoot(StarWarsMod.blasterHeavy.getMeta("Rt97c"), LootGenUtils.baseRarity / 2.0F));
		switch (this.rand.nextInt(5))
		{
			case 0:
				this.entityDropItem(LootGenUtils.getWeightedItemFromList(drop, this.rand), 0.0F);
		}
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.getDataWatcher().addObject(25, Integer.valueOf(this.rand.nextInt(2)));
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return this.worldObj.difficultySetting != net.minecraft.world.EnumDifficulty.PEACEFUL && this.isValidLightLevel() && this.rand.nextInt(20) == 0;
	}

	@Override
	protected String getDeathSound()
	{
		return Resources.MODID + ":" + "mob.sandtrooper.die";
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.sandtrooper.hit";
	}

	@Override
	protected String getLivingSound()
	{
		EntityTameable e = (EntityTameable)this.worldObj.findNearestEntityWithinAABB(EntityTameable.class, this.boundingBox.expand(10.0D, 10.0D, 10.0D), this);
		if (e instanceof MobDroidAstromech || e instanceof MobDroidProtocol)
			return Resources.MODID + ":" + "mob.sandtrooper.droid";
		return Resources.MODID + ":" + "mob.sandtrooper.say";
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected boolean isValidLightLevel()
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
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobSandtrooper.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */