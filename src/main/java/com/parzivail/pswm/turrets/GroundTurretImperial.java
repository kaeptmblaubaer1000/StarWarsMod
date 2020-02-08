package com.parzivail.pswm.turrets;

import net.minecraft.world.World;

import java.util.UUID;

import static com.parzivail.pswm.Resources.MODID;
import static java.util.UUID.fromString;

public class GroundTurretImperial extends TurretBase
{
	private static final UUID field_110189_bq = fromString("49453349-7EC5-45BA-B886-3B90B23A1791");

	public GroundTurretImperial(World world) {
		super(world);
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
