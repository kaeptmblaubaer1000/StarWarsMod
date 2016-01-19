package com.parzivail.util.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class PlayerHelper
{
	Minecraft mc;

	public PlayerHelper(Minecraft mc)
	{
		this.mc = mc;
	}

	public int getHeading(int div)
	{
		try
		{
			return net.minecraft.util.MathHelper.floor_double(this.mc.thePlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & div;
		}
		catch (NullPointerException e)
		{
			return 0;
		}
	}

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