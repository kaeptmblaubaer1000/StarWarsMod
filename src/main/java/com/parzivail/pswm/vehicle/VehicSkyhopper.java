package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.PilotableSFoils;
import net.minecraft.world.World;

/**
 * Created by colby on 1/17/2017.
 */
public class VehicSkyhopper extends PilotableSFoils
{
	public VehicSkyhopper(World world)
	{
		super(world, 1.75f, 40);
	}

	public VehicSkyhopper(World world, double i, double j, double k)
	{
		super(world, i, j, k, 1.75f, 40);
	}

	@Override
	public double getMountedYOffset()
	{
		return 3f;
	}

	public float getCameraY()
	{
		return 0.4f;
	}
}
