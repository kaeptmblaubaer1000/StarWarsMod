package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.Pilotable;
import net.minecraft.world.World;

/**
 * Created by colby on 1/1/2017.
 */
public class VehicTIE extends Pilotable
{
	public VehicTIE(World world)
	{
		super(world);
	}

	public VehicTIE(World world, double i, double j, double k)
	{
		super(world, i, j, k);
	}
}
