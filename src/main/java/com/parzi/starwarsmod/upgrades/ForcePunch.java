package com.parzi.starwarsmod.upgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.utils.PotionList;

public class ForcePunch extends PowerBase
{
	public ForcePunch()
	{
		this.internalName = "effectForcePunch";
		this.displayName = "Force Punch";
		this.internalElement = "animals";
		this.displayElement = "fauna";
	}

	@Override
	public void doPower(World world, EntityPlayer player, ItemStack robe)
	{
		if (robe.stackTagCompound.getInteger(this.internalName) > 0)
			PotionList.addAmbientEffect(player, PotionList.STRENGTH, 10, robe.stackTagCompound.getInteger(this.internalName));
	}
}