package com.parzivail.pswm.mobs;

import com.parzivail.pswm.ai.AiFreqMove;
import com.parzivail.util.entity.trade.WeightedLoot;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.parzivail.pswm.Resources.MODID;
import static com.parzivail.pswm.StarWarsItems.bowcaster;
import static com.parzivail.pswm.utils.LootGenUtils.baseRarity;
import static com.parzivail.pswm.utils.LootGenUtils.getWeightedItemFromList;
import static java.util.UUID.fromString;
import static net.minecraft.entity.SharedMonsterAttributes.maxHealth;
import static net.minecraft.entity.SharedMonsterAttributes.movementSpeed;

public class MobWookiee extends EntityCreature implements IMob
{
	private static final UUID field_110189_bq = fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier field_110190_br = new AttributeModifier(field_110189_bq, "Attacking speed boost", 1, 0).setSaved(false);
	private int angerLevel;
	private Entity angryAt;

	public MobWookiee(World par1World)
	{
		super(par1World);
		getNavigator().setCanSwim(true);
		setSize(0.5F, 2.0F);
		getNavigator().setEnterDoors(true);
		tasks.addTask(0, new AiFreqMove(this, 1, 0));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(maxHealth).setBaseValue(15.0D);
		getEntityAttribute(movementSpeed).setBaseValue(0.25D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		Entity entity = source.getEntity();
		if (entity instanceof EntityPlayer)
		{
			List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(32.0D, 32.0D, 32.0D));
			for (int i = 0; i < list.size(); i++)
			{
				Entity entity1 = (Entity)list.get(i);
				if (entity1 instanceof MobWookiee)
				{
					MobWookiee wook = (MobWookiee)entity1;
					wook.becomeAngryAt(entity);
				}
			}
			becomeAngryAt(entity);
		}
		return super.attackEntityFrom(source, amount);
	}

	private void becomeAngryAt(Entity p_70835_1_)
	{
		entityToAttack = p_70835_1_;
		angerLevel = 400 + rand.nextInt(400);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		List<WeightedLoot> drop = new ArrayList();
		drop.add(new WeightedLoot(new ItemStack(bowcaster, 1), baseRarity / 2.0F));
		switch (rand.nextInt(5))
		{
			case 0:
				entityDropItem(getWeightedItemFromList(drop, rand), 0.0F);
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		return angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}

	@Override
	protected String getDeathSound()
	{
		return MODID + ":" + "mob.wookiee.die";
	}

	@Override
	protected String getHurtSound()
	{
		return MODID + ":" + "mob.wookiee.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return MODID + ":" + "mob.wookiee.say";
	}
}
