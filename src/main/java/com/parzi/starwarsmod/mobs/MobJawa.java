package com.parzi.starwarsmod.mobs;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.LootGenUtils;
import com.parzi.starwarsmod.utils.WeightedLoot;

public class MobJawa extends EntityMob implements IMob
{
	private int angerLevel;
	private Entity angryAt;

	public MobJawa(World par1World)
	{
		super(par1World);
		this.setSize(0.5F, 1.5F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		// this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
		// EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
	}

	@Override
    public boolean getCanSpawnHere()
    {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && this.rand.nextInt(20) == 0;
    }

	@Override
    protected boolean isValidLightLevel()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);

        return (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > 11);
    }

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.325D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
	}

	@Override
	protected String getLivingSound()
	{
		return StarWarsMod.MODID + ":" + "mob.jawa.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return StarWarsMod.MODID + ":" + "mob.jawa.hit";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "mob.jawa.die";
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		List<WeightedLoot> drop = new ArrayList<WeightedLoot>();

		drop.add(new WeightedLoot(new ItemStack(StarWarsMod.hiltMetelCompound, 1), LootGenUtils.baseRarity));
		drop.add(new WeightedLoot(new ItemStack(StarWarsMod.droidCaller, 1), LootGenUtils.baseRarity / 1.2F));
		drop.add(new WeightedLoot(StarWarsMod.blasterRifle.getMeta("Ionization"), LootGenUtils.baseRarity / 2F));

		switch (this.rand.nextInt(5))
		{
			case 0:
				this.entityDropItem(LootGenUtils.getWeightedItemFromList(drop, this.rand), 0F);
				break;
		}
	}



	@Override
	protected Entity findPlayerToAttack()
	{
		return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	@Override
	public void onUpdate()
	{
		this.angryAt = this.entityToAttack;

		super.onUpdate();
	}

	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
	{
		Entity entity = p_70097_1_.getEntity();

		if (entity instanceof EntityPlayer)
		{
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

			for (int i = 0; i < list.size(); ++i)
			{
				Entity entity1 = (Entity)list.get(i);

				if (entity1 instanceof MobJawa)
				{
					MobJawa jawa = (MobJawa)entity1;
					jawa.becomeAngryAt(entity);
				}
			}

			this.becomeAngryAt(entity);
		}

		return super.attackEntityFrom(p_70097_1_, p_70097_2_);
	}

	private void becomeAngryAt(Entity p_70835_1_)
	{
		this.entityToAttack = p_70835_1_;
		this.angerLevel = 400 + this.rand.nextInt(400);
	}
}