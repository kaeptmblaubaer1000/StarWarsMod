package com.parzi.starwarsmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.PotionList;

public class ItemAcidBeets extends ItemFood
{
	private String name = "acidBeets";

	public ItemAcidBeets()
	{
		super(3, 0.0F, false);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public ItemStack onEaten(ItemStack item, World world, EntityPlayer player)
	{
		PotionList.addAmbientEffect(player, PotionList.NAUSEA, 10, 10.0F);
		return super.onEaten(item, world, player);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemAcidBeets.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */