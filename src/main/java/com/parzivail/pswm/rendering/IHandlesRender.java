package com.parzivail.pswm.rendering;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public interface IHandlesRender
{
	void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data);

	boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type);

	boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper);

	ResourceLocation getResourceLocation(boolean alt);
}
