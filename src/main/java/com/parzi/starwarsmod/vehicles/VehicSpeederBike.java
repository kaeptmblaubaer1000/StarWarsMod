package com.parzi.starwarsmod.vehicles;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class VehicSpeederBike extends VehicleBase
{

	public VehicSpeederBike(World par1World)
	{
		super(par1World);
		this.setSize(1, 1);

		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
		{
			return this.getCustomNameTag();
		}
		else
		{
			return "Speeder Bike";
		}
	}
}
