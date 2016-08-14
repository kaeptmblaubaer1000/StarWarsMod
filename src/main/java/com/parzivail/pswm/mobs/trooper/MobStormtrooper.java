package com.parzivail.pswm.mobs.trooper;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.UUID;

import static com.parzivail.pswm.Resources.MODID;
import static com.parzivail.pswm.StarWarsItems.*;
import static java.util.UUID.fromString;

public class MobStormtrooper extends MobTrooper
{
	private static final UUID field_110189_bq = fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");

	public MobStormtrooper(World par1World)
	{
		super(par1World);
		setCurrentItemOrArmor(4, new ItemStack(stormtrooperHelmet, 1));
		setCurrentItemOrArmor(3, new ItemStack(stormtrooperChest, 1));
		setCurrentItemOrArmor(2, new ItemStack(stormtrooperLegs, 1));
		setCurrentItemOrArmor(1, new ItemStack(stormtrooperBoots, 1));
		switch (rand.nextInt(2))
		{
			case 0:
				setCurrentItemOrArmor(0, blasterRifle.getMeta("Stormtrooper"));
				break;
			case 1:
				setCurrentItemOrArmor(0, blasterHeavy.getMeta("Dlt19"));
				break;
		}
	}

	@Override
	protected String getDeathSound()
	{
		return MODID + ":" + "mob.stormtrooper.die";
	}

	@Override
	protected String getHurtSound()
	{
		return MODID + ":" + "mob.stormtrooper.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return getImperialSound();
	}
}
