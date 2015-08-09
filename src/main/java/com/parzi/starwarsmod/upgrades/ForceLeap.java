package com.parzi.starwarsmod.upgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ForceLeap extends PowerBase
{

	public ForceLeap()
	{
		internalName = "effectForceLeap";
		displayName = "Force Leap";
		internalElement = "plants";
		displayElement = "flora";
	}

	@Override
	public void doPower(World world, EntityPlayer player, ItemStack robe)
	{
		if (robe.stackTagCompound.getInteger(internalName) > 0)
		{
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 1800, robe.stackTagCompound.getInteger(internalName), false));
		}
	}
}
