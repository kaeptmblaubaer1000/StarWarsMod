package com.parzivail.pswm.customship;

import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.entity.EntityUtils;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by colby on 10/30/2016.
 */
public class DPhysicalWeapon extends SPhysicalWeapon
{
	private final String partDesignation;
	private final String partManufacturer;
	private final float weight;
	private final SPhysicalWeapon.Type type;

	public DPhysicalWeapon(String partDesignation, String partManufacturer, float weight, SPhysicalWeapon.Type type)
	{
		this.partDesignation = partDesignation;
		this.partManufacturer = partManufacturer;
		this.weight = weight;
		this.type = type;
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
	public boolean canUse(EntityPlayer user)
	{
		return EntityUtils.getShipRiding(user) instanceof Pilotable && ((Pilotable)EntityUtils.getShipRiding(user)).data.numPhysicalWeapons > 0;
	}

	@Override
	public void use(EntityPlayer user)
	{

	}

	@Override
	public Type getType()
	{
		return type;
	}
}
