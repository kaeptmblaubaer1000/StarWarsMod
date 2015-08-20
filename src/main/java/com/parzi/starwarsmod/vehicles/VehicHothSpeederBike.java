package com.parzi.starwarsmod.vehicles;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class VehicHothSpeederBike extends VehicleLandBase
{
	public VehicHothSpeederBike(World par1World)
	{
		super(par1World);
		setSize(1, 1);

		vehicYOffset = 0.4F;

		moveModifier = 3F;

		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		dropItem(StarWarsMod.spawnHothSpeederBike, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (hasCustomNameTag())
		{
			return getCustomNameTag();
		}
		else
		{
			return "74-Z Speeder Bike";
		}
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.speeder.move";
	}
}
