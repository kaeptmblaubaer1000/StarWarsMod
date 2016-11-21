package com.parzivail.pswm.customship;

/**
 * Created by colby on 10/30/2016.
 */
public class DPowerPlant extends SPowerPlant
{
	private final String partDesignation;
	private final String partManufacturer;
	private final float energyPerTick;
	private final float weight;

	public DPowerPlant(String partDesignation, String partManufacturer, float energyPerTick, float weight)
	{
		this.partDesignation = partDesignation;
		this.partManufacturer = partManufacturer;
		this.energyPerTick = energyPerTick;
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
	public float getAmbientPowerGeneration()
	{
		return energyPerTick;
	}
}
