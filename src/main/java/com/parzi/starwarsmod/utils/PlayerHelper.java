package com.parzi.starwarsmod.utils;

import net.minecraft.client.Minecraft;

public class PlayerHelper
{
	Minecraft mc;

	public PlayerHelper(Minecraft mc)
	{
		this.mc = mc;
	}

	public int getHeading(int div)
	{
		return net.minecraft.util.MathHelper.floor_double(this.mc.thePlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & div;
	}

	public net.minecraft.item.ItemStack getHeldItem()
	{
		return this.mc.thePlayer.inventory.getCurrentItem();
	}

	public String getUsername()
	{
		return mc.getSession().getUsername();
	}
}