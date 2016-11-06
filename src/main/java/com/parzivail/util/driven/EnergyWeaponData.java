package com.parzivail.util.driven;

import com.parzivail.pswm.customship.IEnergyConsumer;
import com.parzivail.pswm.customship.IStarshipWeapon;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by colby on 10/17/2016.
 */
public class EnergyWeaponData implements IEnergyConsumer, IStarshipWeapon
{
	public boolean enabled = true;
	public float overheatTimer = 1;

	@Override
	public boolean canUse(EntityPlayer user)
	{
		return false;
	}

	@Override
	public void use(EntityPlayer user)
	{

	}

	@Override
	public String getPartDesignation()
	{
		return null;
	}

	@Override
	public String getPartManufacturer()
	{
		return null;
	}

	@Override
	public float getWeight()
	{
		return 0;
	}

	@Override
	public float getAmbientPowerDrain(Pilotable ship)
	{
		return 0;
	}

	@Override
	public float getPowerDrainPerUse(Pilotable ship)
	{
		return 0;
	}

	@Override
	public boolean hasSufficientPower(Pilotable ship)
	{
		return false;
	}
}
