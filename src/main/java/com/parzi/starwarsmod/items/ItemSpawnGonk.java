package com.parzi.starwarsmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobDroidGNK;

public class ItemSpawnGonk extends Item
{
	private String name = "spawnGonk";

	public ItemSpawnGonk()
	{
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		maxStackSize = 1;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par1, float par2, float par3, float par4)
	{
		if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(StarWarsMod.spawnGonk))
		{
			if (!world.isRemote)
			{
				MobDroidGNK newDroid = new MobDroidGNK(world);
				newDroid.setPosition(x, y + 1, z);
				world.spawnEntityInWorld(newDroid);
			}
		}
		return true;
	}
}
