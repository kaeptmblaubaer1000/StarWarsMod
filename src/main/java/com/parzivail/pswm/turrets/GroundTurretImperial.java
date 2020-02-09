package com.parzivail.pswm.turrets;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

import java.util.UUID;

import static java.util.UUID.fromString;

public class GroundTurretImperial extends TurretBaseImperial
{
	private static final UUID field_110189_bq = fromString("49453349-7EC5-45BA-B886-3B90B23A1791");

	public GroundTurretImperial(World world) {
		super(world);
		setSize(2.0f, 2.0f);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(120.0D);
	}

	@Override
	protected String getDeathSound()
	{
		return null;
	}

	@Override
	protected String getHurtSound()
	{
		return null;
	}
}
