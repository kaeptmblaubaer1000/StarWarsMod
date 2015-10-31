package com.parzi.starwarsmod.upgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.utils.PotionList;

public class ForceResist extends PowerBase
{
	public ForceResist()
	{
		this.internalName = "effectForceResist";
		this.displayName = "Force Resist";
		this.internalElement = "earth";
		this.displayElement = "terra";
	}

	@Override
	public void doPower(World world, EntityPlayer player, ItemStack robe)
	{
		if (robe.stackTagCompound.getInteger(this.internalName) > 0) PotionList.addAmbientEffect(player, PotionList.RESISTANCE, 10, robe.stackTagCompound.getInteger(this.internalName));
	}
}