package com.parzi.starwarsmod.upgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.utils.PotionList;

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
		if (robe.stackTagCompound.getInteger(this.internalName) > 0) PotionList.addAmbientEffect(player, PotionList.JUMP_BOOST, 10, robe.stackTagCompound.getInteger(this.internalName));
	}
}