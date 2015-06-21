package com.parzi.starwarsmod.upgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ForceStep extends PowerBase
{

	public ForceStep()
	{
		this.internalName = "effectStepUp";
		this.displayName = "Force Step";
		this.internalElement = "earth";
		this.displayElement = "terra";
	}

	@Override
	public void doPower(World world, EntityPlayer player, ItemStack robe)
	{
		if (robe.stackTagCompound.getInteger(this.internalName) > 0)
		{
			player.stepHeight = robe.stackTagCompound.getInteger(this.internalName) + 0.001F;
		}
		else
		{
			player.stepHeight = 0.5001F;
		}
	}
}
