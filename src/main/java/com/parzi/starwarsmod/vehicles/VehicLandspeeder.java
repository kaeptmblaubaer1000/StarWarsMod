package com.parzi.starwarsmod.vehicles;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class VehicLandspeeder extends VehicleLandBase
{
	public VehicLandspeeder(World par1World)
	{
		super(par1World);
		setSize(2, 2);

		vehicYOffset = -0.3F;

		moveModifier = 2.5F;

		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		dropItem(StarWarsMod.spawnLandspeeder, 1);
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
			return "X-34 Landspeeder";
		}
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.landspeeder.move";
	}
}
