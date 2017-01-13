package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.PilotableSFoils;
import net.minecraft.world.World;

/**
 * Created by colby on 1/1/2017.
 */
public class VehicXWing extends PilotableSFoils
{
	public VehicXWing(World world)
	{
		super(world, (float)Math.toRadians(18), 20);
	}

	public VehicXWing(World world, double i, double j, double k)
	{
		super(world, i, j, k, (float)Math.toRadians(120), 20);
	}
}
