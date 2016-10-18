package com.parzivail.pswm.vehicles;

import com.parzivail.util.driven.Pilotable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSpawnVehicle extends net.minecraft.item.Item
{
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		float i = (float)entityplayer.posX;
		float j = (float)entityplayer.posY;
		float k = (float)entityplayer.posZ;
		if (!world.isRemote)
		{
			world.spawnEntityInWorld(getVehicle(itemstack, world, entityplayer, i, j, k));
		}
		if (!entityplayer.capabilities.isCreativeMode)
		{
			itemstack.stackSize--;
		}

		return itemstack;
	}

	protected Pilotable getVehicle(ItemStack itemstack, World world, EntityPlayer entityplayer, double i, double j, double k)
	{
		return null;
	}
}
