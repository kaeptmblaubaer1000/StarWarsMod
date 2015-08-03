package com.parzi.starwarsmod.vehicles;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class VehicSpeederBike extends VehicleLandBase
{
	public VehicSpeederBike(World par1World)
	{
		super(par1World);
		this.setSize(1, 1);

		this.vehicYOffset = 0.4F;

		this.moveModifier = 3F;

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.speeder.move";
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsMod.spawnSpeederBike, 1);
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
			return "74-Z Speeder Bike";
		}
	}
}
