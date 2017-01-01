package com.parzivail.pswm.customship;

import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.math.MathUtils;

/**
 * Created by colby on 10/25/2016.
 */
public abstract class SSublightEngine implements IStarshipPart, IEnergyConsumer
{
	public abstract float getSpeed();

	public abstract float getEnergyIdle();

	public abstract float getEnergyFull();

	@Override
	public float getAmbientPowerDrain(Pilotable ship)
	{
		return MathUtils.lerp(getEnergyIdle(), getEnergyFull(), ship.throttle);
	}
}
