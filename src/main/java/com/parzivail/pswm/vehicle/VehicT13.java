package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.PilotableLand;
import net.minecraft.world.World;

/**
 * Created by colby on 1/1/2017.
 */
public class VehicT13 extends PilotableLand
{
	public VehicT13(World world)
	{
		super(world);
	}

	public VehicT13(World world, double i, double j, double k)
	{
		super(world, i, j, k);
	}

	@Override
	public void onUpdate()
	{
		this.data.cameraDistance = 1.2f;
		super.onUpdate();
	}

	@Override
	public float getCameraY()
	{
		return 1.5f;
	}
}
