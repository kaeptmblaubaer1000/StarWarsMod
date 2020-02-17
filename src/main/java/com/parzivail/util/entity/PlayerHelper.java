package com.parzivail.util.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

/**
 * A class to help get information about the client's ship
 */
public class PlayerHelper
{
	Minecraft mc;

	public PlayerHelper(Minecraft mc)
	{
		this.mc = mc;
	}

	/**
	 * Gets the ship's held itemstack, with failsafes
	 */
	public ItemStack getHeldItemStack()
	{
		try
		{
			return this.mc.thePlayer.inventory.getCurrentItem();
		}
		catch (NullPointerException e)
		{
			return null;
		}
	}

	/**
	 * Gets the ship's username, with failsafes
	 */
	public String getUsername()
	{
		try
		{
			return this.mc.getSession().getUsername();
		}
		catch (NullPointerException e)
		{
			return "";
		}
	}
}