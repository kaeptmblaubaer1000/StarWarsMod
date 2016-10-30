package com.parzivail.pswm.customship;

import com.parzivail.util.driven.Pilotable;

/**
 * Created by colby on 10/30/2016.
 */
public class DTargetingComputer extends STargetingComputer
{
	private final String partDesignation;
	private final String partManufacturer;
	private final float energyPerTick;
	private final float range;

	public DTargetingComputer(String partDesignation, String partManufacturer, float energyPerTick, float range)
	{

		this.partDesignation = partDesignation;
		this.partManufacturer = partManufacturer;
		this.energyPerTick = energyPerTick;
		this.range = range;
	}

	@Override
	public String getPartDesignation()
	{
		return partDesignation;
	}

	@Override
	public String getPartManufacturer()
	{
		return partManufacturer;
	}

	@Override
	public float getWeight()
	{
		return 0;
	}

	@Override
	public float getAmbientPowerDrain(Pilotable ship)
	{
		return energyPerTick;
	}

	@Override
	public float getPowerDrainPerUse(Pilotable ship)
	{
		return 0;
	}

	@Override
	public boolean hasSufficientPower(Pilotable ship)
	{
		return getAmbientPowerDrain(ship) <= ship.data.energyTotalPercentage * ship.data.maxEnergyUnits;
	}

	@Override
	public float getRange()
	{
		return range;
	}
}
