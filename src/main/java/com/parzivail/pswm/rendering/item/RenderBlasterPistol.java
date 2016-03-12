package com.parzivail.pswm.rendering.item;

import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RenderBlasterPistol implements IItemRenderer
{
	HashMap<Integer, IItemRenderer> renderers = new HashMap<>();

	public RenderBlasterPistol()
	{
		// "Dl44", "Dl18", "Dh17", "Sporting", "Dl21", "Scout", "Se14c"
		int id = 0;
		renderers.put(id++, new RenderDL44());
		renderers.put(id++, new RenderDL18());
		renderers.put(id++, new RenderDH17());
		renderers.put(id++, new RenderDefender());
		renderers.put(id++, new RenderDL21());
		renderers.put(id++, new RenderScout());
		renderers.put(id++, new RenderSE14C());
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