package com.parzivail.util.driven;

import com.parzivail.pswm.customship.IEnergyConsumer;
import com.parzivail.pswm.customship.IStarshipWeapon;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by colby on 10/17/2016.
 */
public class PhysicalWeaponData implements IEnergyConsumer, IStarshipWeapon
{
	public int amountRemaining;

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
