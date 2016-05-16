package com.parzivail.util.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

/**
 * A class to help get information about the client's player
 */
public class PlayerHelper
{
	Minecraft mc;

	public PlayerHelper(Minecraft mc)
	{
		this.mc = mc;
	}

	/**
	 * Gets the player's held itemstack, with failsafes
	 *
	 * @return
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
	 * Gets the player's username, with failsafes
	 *
	 * @return
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