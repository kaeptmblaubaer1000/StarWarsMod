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

	public float getCameraY()
	{
		this.data.cameraDistance = 5;
		return 0.5f;
	}
}
