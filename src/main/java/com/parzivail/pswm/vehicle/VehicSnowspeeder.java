package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.Pilotable;
import net.minecraft.world.World;

/**
 * Created by colby on 1/17/2017.
 */
public class VehicSnowspeeder extends Pilotable
{
	public VehicSnowspeeder(World world)
	{
		super(world);
	}

	public VehicSnowspeeder(World world, double i, double j, double k)
	{
		super(world, i, j, k);
	}

	@Override
	protected void setupShipData()
	{
		this.data.cameraDistance = 5;
	}

	public float getCameraY()
	{
		return 0.5f;
	}
}
