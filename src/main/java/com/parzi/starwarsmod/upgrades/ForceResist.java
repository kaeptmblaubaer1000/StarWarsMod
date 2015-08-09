package com.parzi.starwarsmod.upgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ForceResist extends PowerBase
{

	public ForceResist()
	{
		internalName = "effectForceResist";
		displayName = "Force Resist";
		internalElement = "earth";
		displayElement = "terra";
	}

	@Override
	public void doPower(World world, EntityPlayer player, ItemStack robe)
	{
		if (robe.stackTagCompound.getInteger(internalName) > 0)
		{
			player.addPotionEffect(new PotionEffect(11, 1800, robe.stackTagCompound.getInteger(internalName), false)); // resistance
		}
	}
}
