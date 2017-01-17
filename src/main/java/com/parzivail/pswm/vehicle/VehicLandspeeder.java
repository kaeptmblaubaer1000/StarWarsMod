package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.Pilotable;
import net.minecraft.world.World;

/**
 * Created by colby on 1/17/2017.
 */
public class VehicLandspeeder extends Pilotable
{
	public VehicLandspeeder(World world)
	{
		super(world);
	}

	public VehicLandspeeder(World world, double i, double j, double k)
	{
		super(world, i, j, k);
	}
}
