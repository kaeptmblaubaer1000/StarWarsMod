package com.parzivail.pswm.mobs.trooper;

import com.parzivail.pswm.mobs.MobDroidAstromech;
import com.parzivail.pswm.mobs.MobDroidProtocol;
import com.parzivail.util.entity.trade.WeightedLoot;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.parzivail.pswm.Resources.MODID;
import static com.parzivail.pswm.StarWarsItems.*;
import static com.parzivail.pswm.utils.LootGenUtils.baseRarity;
import static com.parzivail.pswm.utils.LootGenUtils.getWeightedItemFromList;
import static java.util.UUID.fromString;

public class MobSandtrooper extends MobTrooper
{
	private static final UUID field_110189_bq = fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");

	public MobSandtrooper(World par1World)
	{
		super(par1World);
		setCurrentItemOrArmor(4, new ItemStack(sandtrooperHelmet, 1));
		setCurrentItemOrArmor(3, new ItemStack(sandtrooperChest, 1));
		setCurrentItemOrArmor(2, new ItemStack(sandtrooperLegs, 1));
		setCurrentItemOrArmor(1, new ItemStack(sandtrooperBoots, 1));
		switch (rand.nextInt(4))
		{
			case 0:
				setCurrentItemOrArmor(0, blasterRifle.getMeta("Stormtrooper"));
				break;
			case 1:
				setCurrentItemOrArmor(0, blasterHeavy.getMeta("T21"));
				break;
			case 2:
				setCurrentItemOrArmor(0, blasterHeavy.getMeta("Dlt19"));
				break;
			case 3:
				setCurrentItemOrArmor(0, blasterHeavy.getMeta("Rt97c"));
				break;
		}
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		List<WeightedLoot> drop = new ArrayList();
		drop.add(new WeightedLoot(blasterRifle.getMeta("Stormtrooper"), baseRarity / 2.0F));
		drop.add(new WeightedLoot(blasterHeavy.getMeta("T21"), baseRarity / 2.0F));
		drop.add(new WeightedLoot(blasterHeavy.getMeta("Rt97c"), baseRarity / 2.0F));
		switch (rand.nextInt(5))
		{
			case 0:
				entityDropItem(getWeightedItemFromList(drop, rand), 0.0F);
		}
	}

	@Override
	protected String getDeathSound()
	{
		return MODID + ":" + "mob.sandtrooper.die";
	}

	@Override
	protected String getHurtSound()
	{
		return MODID + ":" + "mob.sandtrooper.hit";
	}

	@Override
	protected String getLivingSound()
	{
		EntityTameable e = (EntityTameable)worldObj.findNearestEntityWithinAABB(EntityTameable.class, boundingBox.expand(10.0D, 10.0D, 10.0D), this);
		if (e instanceof MobDroidAstromech || e instanceof MobDroidProtocol)
			return MODID + ":" + "mob.sandtrooper.droid";
		return MODID + ":" + "mob.sandtrooper.say";
	}
}
