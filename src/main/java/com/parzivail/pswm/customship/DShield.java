package com.parzivail.pswm.customship;

import com.parzivail.util.driven.Pilotable;

/**
 * Created by colby on 10/30/2016.
 */
public class DShield extends SShield
{
	private final String partDesignation;
	private final String partManufacturer;
	private final float energyPerTick;
	private final float sbd;
	private final float weight;

	public DShield(String partDesignation, String partManufacturer, float energyPerTick, float sbd, float weight)
	{

		this.partDesignation = partDesignation;
		this.partManufacturer = partManufacturer;
		this.energyPerTick = energyPerTick;
		this.sbd = sbd;
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
	public float getAmbientPowerDrain(Pilotable ship)
	{
		return ship.data.shieldActive ? energyPerTick : 0;
	}

	public float getEnergyPerTick()
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
	public float getShieldDurability()
	{
		return sbd;
	}
}
