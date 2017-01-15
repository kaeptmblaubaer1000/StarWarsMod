package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.PilotableLand;
import net.minecraft.world.World;

/**
 * Created by colby on 1/1/2017.
 */
public class VehicJR4Swoop extends PilotableLand
{
	public VehicJR4Swoop(World world)
	{
		super(world);
	}

	public VehicJR4Swoop(World world, double i, double j, double k)
	{
		super(world, i, j, k);
	}

	@Override
	protected void setupShipData()
	{
		this.data.cameraDistance = 2;
		this.data.throttleStep = 0.1f;
		this.data.maxThrottle = 0.3f;
		this.stepHeight = 2;
	}

	@Override
	public double getMountedYOffset()
	{
		return 0.5f;
	}
}
