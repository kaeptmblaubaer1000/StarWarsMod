package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.registry.KeybindRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ItemSpawnHothSpeederBike extends net.minecraft.item.Item
{
	public String name = "spawnHothSpeederBike";

	public ItemSpawnHothSpeederBike()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.maxStackSize = 1;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		String s = KeybindRegistry.keyShootVehicle.getKeyCode() <= 0 ? "UNKNOWN" : Keyboard.getKeyName(KeybindRegistry.keyShootVehicle.getKeyCode());
		list.add(String.format("Press %s to fire lasers.", s));
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par1, float par2, float par3, float par4)
	{
		if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(StarWarsMod.spawnHothSpeederBike))
			if (!world.isRemote)
			{
				VehicHothSpeederBike newVehic = new VehicHothSpeederBike(world);
				newVehic.setPosition(x + 0.5D, y + 1, z + 0.5D);
				world.spawnEntityInWorld(newVehic);
			}
		return true;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\vehicles\ItemSpawnHothSpeederBike.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */