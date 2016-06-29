package com.parzivail.pswm.gui;

import com.parzivail.pswm.tileentities.TileEntityAntenna;
import com.parzivail.util.math.Animation;

/**
 * Created by Colby on 5/7/2016.
 */
public class AnimationAntennaOpen extends Animation
{
	TileEntityAntenna antenna;

	public AnimationAntennaOpen(TileEntityAntenna antenna)
	{
		super(100, false, false);
		this.antenna = antenna;
	}

	@Override
	public void tick()
	{
		this.antenna.setOpenFrame(this.tick);
		super.tick();
	}
}
