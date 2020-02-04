package com.parzivail.pswm.mobs.trooper;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.UUID;

import static com.parzivail.pswm.Resources.MODID;
import static com.parzivail.pswm.StarWarsItems.*;
import static java.util.UUID.fromString;

public class MobRebelPilotY extends MobTrooper
{
	private static final UUID field_110189_bq = fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");

	public MobRebelPilotY(World par1World)
	{
		super(par1World);
		setCurrentItemOrArmor(4, new ItemStack(rebelYPilotHelmet, 1));
		setCurrentItemOrArmor(3, new ItemStack(rebelYPilotChest, 1));
		setCurrentItemOrArmor(2, new ItemStack(rebelYPilotLegs, 1));
		setCurrentItemOrArmor(1, new ItemStack(rebelYPilotBoots, 1));
		if (rand.nextInt(2) == 1)
		{
			setCurrentItemOrArmor(0, blasterPistol.getMeta("Dh17"));
		}
	}

	@Override
	protected String getDeathSound()
	{
		return MODID + ":" + "mob.rebel.die";
	}

	@Override
	protected String getHurtSound()
	{
		return MODID + ":" + "mob.rebel.hit";
	}

	@Override
	protected String getLivingSound()
	{
		return MODID + ":" + "mob.rebel.say";
	}
}
