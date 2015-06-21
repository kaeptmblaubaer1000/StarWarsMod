package com.parzi.starwarsmod.upgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PowerBase
{
	public String internalName;
	public String displayName;
	public String internalElement;
	public String displayElement;

	public PowerBase()
	{
		internalName = "powerBase";
		displayName = "Base Power";
		internalElement = "none";
		displayElement = "none";
	}

	public void doPower(World world, EntityPlayer player, ItemStack robe)
	{
	}
}
