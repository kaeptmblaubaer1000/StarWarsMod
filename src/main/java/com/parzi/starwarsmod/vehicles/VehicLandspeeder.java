package com.parzi.starwarsmod.vehicles;

import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class VehicLandspeeder extends VehicleLandBase
{
	public VehicLandspeeder(World par1World)
	{
		super(par1World);
		this.setSize(1, 1);

		this.vehicYOffset = 0.4F;

		this.moveModifier = 2.5F;

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.landspeeder.move";
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsMod.spawnLandspeeder, 1);
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
			return "X-34 Landspeeder";
		}
	}
}
