package com.parzivail.pswm.mobs.trooper;

import net.minecraft.world.World;

import java.util.UUID;

import static com.parzivail.pswm.Resources.MODID;
import static java.util.UUID.fromString;

public class MobImperialOfficer extends MobTrooper
{
	private static final UUID field_110189_bq = fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");

	public MobImperialOfficer(World par1World)
	{
		super(par1World);
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
