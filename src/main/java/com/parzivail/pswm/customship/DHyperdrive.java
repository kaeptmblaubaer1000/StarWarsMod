package com.parzivail.pswm.customship;

/**
 * Created by colby on 10/30/2016.
 */
public class DHyperdrive extends SHyperdrive
{
	private final String partDesignation;
	private final String partManufacturer;
	private final float weight;
	private final float hyperdriveClass;

	public DHyperdrive(String partDesignation, String partManufacturer, float weight, float hyperdriveClass)
	{
		this.partDesignation = partDesignation;
		this.partManufacturer = partManufacturer;
		this.weight = weight;
		this.hyperdriveClass = hyperdriveClass;
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
	public float getHyperdriveClass()
	{
		return hyperdriveClass;
	}
}
