package com.parzivail.pswm.customship;

import com.parzivail.util.driven.Pilotable;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by colby on 10/30/2016.
 */
public class DEnergyWeapon extends SEnergyWeapon
{
	private final String partDesignation;
	private final String partManufacturer;
	private final float energyPerUse;
	private final float weight;

	public DEnergyWeapon(String partDesignation, String partManufacturer, float energyPerUse, float weight)
	{
		this.partDesignation = partDesignation;
		this.partManufacturer = partManufacturer;
		this.energyPerUse = energyPerUse;
		this.weight = weight;
	}

	@Override
	public String getPartDesignation()
	{
		return partDesignation;
	}

	@Override
	public String getPartManufacturer()
	{
		return partManufacturer;
	}

	@Override
	public float getWeight()
	{
		return weight;
	}

	@Override
	public float getAmbientPowerDrain(Pilotable ship)
	{
		return 0;
	}

	@Override
	public float getPowerDrainPerUse(Pilotable ship)
	{
		return energyPerUse;
	}

	@Override
	public boolean hasSufficientPower(Pilotable ship)
	{
		return getAmbientPowerDrain(ship) <= ship.data.energyTotalPercentage * ship.data.maxEnergyUnits;
	}

	@Override
	public boolean canUse(EntityPlayer user)
	{
		return user.getRidingEntity() instanceof Pilotable && hasSufficientPower((Pilotable)user.getRidingEntity());
	}

	@Override
	public void use(EntityPlayer user)
	{
		// TODO: fire blaster
	}
}
