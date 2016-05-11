package com.parzivail.pswm.tileentities;

import net.minecraft.tileentity.TileEntity;

public class TileEntityHyperdrive extends TileEntity
{
	private float ticks = 0;

	@Override
	public void updateEntity()
	{
		super.updateEntity();
		this.ticks++;
		if (ticks > 360)
			ticks = 0;
	}

	public float getTicks()
	{
		return ticks;
	}
}