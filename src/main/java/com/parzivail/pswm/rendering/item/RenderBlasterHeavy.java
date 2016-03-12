package com.parzivail.pswm.rendering.item;

import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RenderBlasterHeavy implements IItemRenderer
{
	HashMap<Integer, IItemRenderer> renderers = new HashMap<>();

	public RenderBlasterHeavy()
	{
		// "Dlt19", "T21", "Rt97c"
		int id = 0;
		renderers.put(id++, new RenderDlt19());
		renderers.put(id++, new RenderT21());
		renderers.put(id++, new RenderRT97C());
	}

	@Override
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	{
		IItemRenderer r = getRendererForStack(item);
		if (r != null)
			return r.handleRenderType(item, type);
		return true;
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
	{
		IItemRenderer r = getRendererForStack(item);
		if (r != null)
			r.renderItem(type, item, data);
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	{
		IItemRenderer r = getRendererForStack(item);
		if (r != null)
			return r.shouldUseRenderHelper(type, item, helper);
		return true;
	}

	private IItemRenderer getRendererForStack(ItemStack stack)
	{
		if (renderers.containsKey(stack.getItemDamage()))
			return renderers.get(stack.getItemDamage());
		return null;
	}
}