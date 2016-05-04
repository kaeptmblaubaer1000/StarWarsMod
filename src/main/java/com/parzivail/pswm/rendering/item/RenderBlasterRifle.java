package com.parzivail.pswm.rendering.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import java.util.HashMap;

public class RenderBlasterRifle implements IItemRenderer
{
	HashMap<Integer, IItemRenderer> renderers = new HashMap<>();

	public RenderBlasterRifle()
	{
		// "A280", "Ee3", "Ionization", "Cycler", "Stormtrooper"
		int id = 0;
		renderers.put(id++, new RenderA280());
		renderers.put(id++, new RenderEE3());
		renderers.put(id++, new RenderIonization());
		renderers.put(id++, new RenderCycler());
		renderers.put(id++, new RenderE11());
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