package com.parzi.starwarsmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.LootGenUtils;

public class ItemDebugLootGen extends Item
{
	private String name = "debugLootGen";

	public ItemDebugLootGen()
	{
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par1, float par2, float par3, float par4)
	{
		y = y + 1;
		world.setBlock(x, y, z, Blocks.chest);
		TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, y, z);
		LootGenUtils.fillLootChest(player.dimension, itemRand, chest);
		System.out.println("Added Loot Chest: " + x + ", " + y + ", " + z);
		return true;
	}
}
