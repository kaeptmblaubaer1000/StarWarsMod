package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.utils.LootGenUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class ItemDebugLootGen extends Item
{
	public String name = "debugLootGen";

	public ItemDebugLootGen()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par1, float par2, float par3, float par4)
	{
		y += 1;
		world.setBlock(x, y, z, Blocks.chest);
		TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, y, z);
		LootGenUtils.fillLootChest(player.dimension, itemRand, chest);
		System.out.println("Added Loot Chest: " + x + ", " + y + ", " + z);
		return true;
	}
}
