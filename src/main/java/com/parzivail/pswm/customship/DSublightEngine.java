package com.parzivail.pswm.customship;

import com.parzivail.util.driven.Pilotable;

/**
 * Created by colby on 10/30/2016.
 */
public class DSublightEngine extends SSublightEngine
{
	private final String partDesignation;
	private final String partManufacturer;
	private final float speed;
	private final float energyIdle;
	private final float energyFull;
	private final float weight;

	public DSublightEngine(String partDesignation, String partManufacturer, float speed, float energyIdle, float energyFull, float weight)
	{

		this.partDesignation = partDesignation;
		this.partManufacturer = partManufacturer;
		this.speed = speed;
		this.energyIdle = energyIdle;
		this.energyFull = energyFull;
		this.weight = weight;
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
		return weight;
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
	public float getSpeed()
	{
		return speed;
	}

	@Override
	public float getEnergyIdle()
	{
		return energyIdle;
	}

	@Override
	public float getEnergyFull()
	{
		return energyFull;
	}
}
