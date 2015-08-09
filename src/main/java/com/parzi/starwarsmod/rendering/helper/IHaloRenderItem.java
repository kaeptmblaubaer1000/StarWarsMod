package com.parzi.starwarsmod.rendering.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IHaloRenderItem
{
	// Thanks SpitefulFox!
	// https://github.com/SpitefulFox/Avaritia/
	@SideOnly(Side.CLIENT)
	public boolean drawHalo(ItemStack stack);

	@SideOnly(Side.CLIENT)
	public boolean drawPulseEffect(ItemStack stack);

	@SideOnly(Side.CLIENT)
	public int getHaloColour(ItemStack stack);

	@SideOnly(Side.CLIENT)
	public int getHaloSize(ItemStack stack);

	@SideOnly(Side.CLIENT)
	public IIcon getHaloTexture(ItemStack stack);
}
