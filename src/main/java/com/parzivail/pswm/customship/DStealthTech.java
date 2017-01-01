package com.parzivail.pswm.customship;

import com.parzivail.util.driven.Pilotable;

/**
 * Created by colby on 10/30/2016.
 */
public class DStealthTech extends SStealthTech
{
	private final String partDesignation;
	private final String partManufacturer;
	private final int cloakTime;
	private final float energyPerTick;
	private final boolean visPlayer;
	private final boolean visRadar;

	public DStealthTech(String partDesignation, String partManufacturer, int cloakTime, float energyPerTick, boolean visPlayer, boolean visRadar)
	{
		this.partDesignation = partDesignation;
		this.partManufacturer = partManufacturer;
		this.cloakTime = cloakTime;
		this.energyPerTick = energyPerTick;
		this.visPlayer = visPlayer;
		this.visRadar = visRadar;
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
		return ship.data.stealthActive ? energyPerTick : 0;
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
	public float getCloakingTime()
	{
		return cloakTime;
	}

	@Override
	public boolean isVisibleToPlayers()
	{
		return visPlayer;
	}

	@Override
	public boolean isVisibleToRadar()
	{
		return visRadar;
	}
}
