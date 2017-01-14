package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.PilotableSFoils;
import net.minecraft.world.World;

/**
 * Created by colby on 1/1/2017.
 */
public class VehicTIEStriker extends PilotableSFoils
{
	public VehicTIEStriker(World world)
	{
		super(world, (float)Math.toRadians(27), 20);
	}

	public VehicTIEStriker(World world, double i, double j, double k)
	{
		super(world, i, j, k, (float)Math.toRadians(27), 20);
	}
}
