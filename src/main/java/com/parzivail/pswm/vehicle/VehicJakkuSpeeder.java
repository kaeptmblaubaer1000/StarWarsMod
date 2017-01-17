package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.PilotableLand;
import net.minecraft.world.World;

/**
 * Created by colby on 1/17/2017.
 */
public class VehicJakkuSpeeder extends PilotableLand
{
	public VehicJakkuSpeeder(World world)
	{
		super(world);
	}

	public VehicJakkuSpeeder(World world, double i, double j, double k)
	{
		super(world, i, j, k);
	}

	@Override
	public double getMountedYOffset()
	{
		return 1f;
	}

	public float getCameraY()
	{
		return 2.5f;
	}
}
