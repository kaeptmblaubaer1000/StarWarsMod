package com.parzivail.pswm.rendering;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public interface IHandlesRender
{
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data);

	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type);

	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper);

	public ResourceLocation getResourceLocation(boolean alt);
}
