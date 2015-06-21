package com.parzi.starwarsmod.upgrades;

import net.minecraft.block.BlockBeacon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ForceLeap extends PowerBase
{

	public ForceLeap()
	{
		this.internalName = "effectForceLeap";
		this.displayName = "Force Leap";
		this.internalElement = "plants";
		this.displayElement = "flora";
	}

	@Override
	public void doPower(World world, EntityPlayer player, ItemStack robe)
	{
		if (robe.stackTagCompound.getInteger(this.internalName) > 0)
		{
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 1800, robe.stackTagCompound.getInteger(this.internalName), false));
		}
	}
}
