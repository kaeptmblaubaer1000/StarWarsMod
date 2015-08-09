package com.parzi.starwarsmod.upgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ForceFeed extends PowerBase
{

	public ForceFeed()
	{
		internalName = "effectForceFeed";
		displayName = "Jedi Stamina";
		internalElement = "animals";
		displayElement = "fauna";
	}

	@Override
	public void doPower(World world, EntityPlayer player, ItemStack robe)
	{
		if (robe.stackTagCompound.getInteger(internalName) > 0)
		{
			player.addPotionEffect(new PotionEffect(23, 1800, robe.stackTagCompound.getInteger(internalName), false)); // saturation
		}
	}
}
