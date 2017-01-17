package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.PilotableLand;
import net.minecraft.world.World;

/**
 * Created by colby on 1/17/2017.
 */
public class VehicSpeederBike extends PilotableLand
{
	public VehicSpeederBike(World world)
	{
		super(world);
	}

	public VehicSpeederBike(World world, double i, double j, double k)
	{
		super(world, i, j, k);
	}

	public float getCameraY()
	{
		this.data.cameraDistance = 1;
		return 2.5f;
	}
}
