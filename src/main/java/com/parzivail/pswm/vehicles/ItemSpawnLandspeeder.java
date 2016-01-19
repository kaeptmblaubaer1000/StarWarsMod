package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSpawnLandspeeder extends net.minecraft.item.Item
{
	public String name = "spawnLandspeeder";

	public ItemSpawnLandspeeder()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.maxStackSize = 1;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par1, float par2, float par3, float par4)
	{
		if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(StarWarsMod.spawnLandspeeder))
			if (!world.isRemote)
			{
				VehicLandspeeder newVehic = new VehicLandspeeder(world);
				newVehic.setPosition(x + 0.5D, y + 1, z + 0.5D);
				world.spawnEntityInWorld(newVehic);
			}
		return true;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\vehicles\ItemSpawnLandspeeder.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */