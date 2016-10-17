package com.parzivail.util.driven;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by colby on 10/17/2016.
 */
public class EnergyWeaponData implements IPowered, IStarshipWeapon
{
	public boolean enabled = true;
	public float overheatTimer = 1;

	@Override
	public float calculateAmbientPowerDrain()
	{
		return 0;
	}

	@Override
	public float calculatePowerDrainPerUse()
	{
		return 0;
	}

	@Override
	public boolean hasPowerRequirements()
	{
		return true;
	}

	@Override
	public boolean canUse(EntityPlayer user)
	{
		return false;
	}

	@Override
	public void use(EntityPlayer user)
	{

	}
}
