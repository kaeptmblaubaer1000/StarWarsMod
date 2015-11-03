package com.parzi.starwarsmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemGorrnar extends ItemFood
{
	private String name = "gorrnar";

	public ItemGorrnar()
	{
		super(5, 0.0F, false);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public ItemStack onEaten(ItemStack item, World world, EntityPlayer player)
	{
		player.setFire(2);
		return super.onEaten(item, world, player);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemGorrnar.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */