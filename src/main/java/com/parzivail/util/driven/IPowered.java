package com.parzivail.util.driven;

/**
 * Created by colby on 10/17/2016.
 */
public interface IPowered
{
	float calculateAmbientPowerDrain();

	float calculatePowerDrainPerUse();

	boolean hasPowerRequirements();
}
