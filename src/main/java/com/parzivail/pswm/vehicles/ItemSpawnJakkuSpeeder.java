package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSpawnJakkuSpeeder extends net.minecraft.item.Item
{
	public String name = "spawnJakkuSpeeder";

	public ItemSpawnJakkuSpeeder()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.SequelStarWarsTab);
		this.maxStackSize = 1;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par1, float par2, float par3, float par4)
	{
		if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(StarWarsMod.spawnJakkuSpeeder))
			if (!world.isRemote)
			{
				VehicJakkuSpeeder newVehic = new VehicJakkuSpeeder(world);
				newVehic.setPosition(x + 0.5D, y + 1, z + 0.5D);
				world.spawnEntityInWorld(newVehic);
			}
		return true;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\vehicles\ItemSpawnSpeederBike.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */