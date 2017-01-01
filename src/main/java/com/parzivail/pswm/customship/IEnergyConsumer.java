package com.parzivail.pswm.customship;

import com.parzivail.util.driven.Pilotable;

/**
 * Created by colby on 10/17/2016.
 */
public interface IEnergyConsumer
{
	float getAmbientPowerDrain(Pilotable ship);

	float getPowerDrainPerUse(Pilotable ship);

	boolean hasSufficientPower(Pilotable ship);
}
