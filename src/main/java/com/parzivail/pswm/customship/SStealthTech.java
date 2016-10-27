package com.parzivail.pswm.customship;

/**
 * Created by colby on 10/25/2016.
 */
public abstract class SStealthTech implements IStarshipPart, IEnergyConsumer
{
	public abstract float getCloakingTime();

	public abstract boolean isVisibleToPlayers();

	public abstract boolean isVisibleToRadar();
}
