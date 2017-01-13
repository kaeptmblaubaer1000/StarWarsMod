package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.PilotableSFoils;
import net.minecraft.world.World;

/**
 * Created by colby on 1/1/2017.
 */
public class VehicUWing extends PilotableSFoils
{
	public VehicUWing(World world)
	{
		super(world, (float)Math.toRadians(120), 20);
	}

	public VehicUWing(World world, double i, double j, double k)
	{
		super(world, i, j, k, (float)Math.toRadians(120), 20);
	}
}
