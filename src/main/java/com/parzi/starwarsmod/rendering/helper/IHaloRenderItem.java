package com.parzi.starwarsmod.rendering.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract interface IHaloRenderItem
{
	@SideOnly(Side.CLIENT)
	public abstract boolean drawHalo(ItemStack paramItemStack);

	@SideOnly(Side.CLIENT)
	public abstract boolean drawPulseEffect(ItemStack paramItemStack);

	@SideOnly(Side.CLIENT)
	public abstract int getHaloColour(ItemStack paramItemStack);

	@SideOnly(Side.CLIENT)
	public abstract int getHaloSize(ItemStack paramItemStack);

	@SideOnly(Side.CLIENT)
	public abstract IIcon getHaloTexture(ItemStack paramItemStack);
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\helper\IHaloRenderItem.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */