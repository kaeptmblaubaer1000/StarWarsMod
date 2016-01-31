package com.parzivail.pswm.mobs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.ai.AiFreqMove;
import com.parzivail.pswm.utils.LootGenUtils;
import com.parzivail.util.entity.trade.WeightedLoot;

public class MobWookiee extends EntityMob implements IMob
{
	private int angerLevel;
	private Entity angryAt;
	private static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier field_110190_br = (new AttributeModifier(field_110189_bq, "Attacking speed boost", 1, 0)).setSaved(false);

	public MobWookiee(World par1World)
	{
		super(par1World);
		this.setSize(0.5F, 2.0F);
		this.getNavigator().setEnterDoors(true);
		this.tasks.addTask(0, new AiFreqMove(this, 1, 0));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		Entity entity = source.getEntity();
		if (entity instanceof EntityPlayer)
		{
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));
			for (int i = 0; i < list.size(); i++)
			{
				Entity entity1 = (Entity)list.get(i);
				if (entity1 instanceof MobWookiee)
				{
					MobWookiee wook = (MobWookiee)entity1;
					wook.becomeAngryAt(entity);
				}
			}
			this.becomeAngryAt(entity);
		}
		return super.attackEntityFrom(source, amount);
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
		drop.add(new WeightedLoot(new ItemStack(StarWarsMod.bowcaster, 1), LootGenUtils.baseRarity / 2.0F));
		switch (this.rand.nextInt(5))
		{
			case 0:
				this.entityDropItem(LootGenUtils.getWeightedItemFromList(drop, this.rand), 0.0F);
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
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
		return Resources.MODID + ":" + "mob.wookiee.die";
	}

	@Override
	protected String getHurtSound()
	{
		return Resources.MODID + ":" + "mob.wookiee.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return Resources.MODID + ":" + "mob.wookiee.say";
	}

	@Override
	public void onUpdate()
	{
		if (this.angryAt != this.entityToAttack && !this.worldObj.isRemote)
		{
			IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			iattributeinstance.removeModifier(field_110190_br);

			if (this.entityToAttack != null)
			{
				iattributeinstance.applyModifier(field_110190_br);
			}
		}

		this.angryAt = this.entityToAttack;
		super.onUpdate();
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\mobs\MobWookiee.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */