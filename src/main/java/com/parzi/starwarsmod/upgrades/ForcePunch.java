package com.parzi.starwarsmod.upgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ForcePunch extends PowerBase
{

	public ForcePunch()
	{
		internalName = "effectForcePunch";
		displayName = "Force Punch";
		internalElement = "animals";
		displayElement = "fauna";
	}

	@Override
	public void doPower(World world, EntityPlayer player, ItemStack robe)
	{
		if (robe.stackTagCompound.getInteger(internalName) > 0)
		{
			player.addPotionEffect(new PotionEffect(5, 1800, robe.stackTagCompound.getInteger(internalName), false)); // strength
		}
	}
}
