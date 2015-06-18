package com.parzi.starwarsmod.upgrades;

import net.minecraft.block.BlockBeacon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ForceFeed extends PowerBase {

	public ForceFeed() {
		this.internalName = "effectForceFeed";
		this.displayName = "Force Feed";
		this.internalElement = "animals";
		this.displayElement = "fauna";
	}

	@Override
	public void doPower(World world, EntityPlayer player, ItemStack robe) {
		if (robe.stackTagCompound.getInteger(this.internalName) > 0) {
			player.addPotionEffect(new PotionEffect(23, 1800, robe.stackTagCompound.getInteger(this.internalName), false)); // saturation
		}
	}
}
