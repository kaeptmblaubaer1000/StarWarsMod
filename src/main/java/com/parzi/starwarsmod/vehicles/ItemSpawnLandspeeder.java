package com.parzi.starwarsmod.vehicles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemSpawnLandspeeder extends Item
{
	private String name = "spawnLandspeeder";

	public ItemSpawnLandspeeder()
	{
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		maxStackSize = 1;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par1, float par2, float par3, float par4)
	{
		if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(StarWarsMod.spawnLandspeeder))
		{
			if (!world.isRemote)
			{
				VehicLandspeeder newVehic = new VehicLandspeeder(world);
				newVehic.setPosition(x, y + 1, z);
				world.spawnEntityInWorld(newVehic);
			}
		}
		return true;
	}
}
