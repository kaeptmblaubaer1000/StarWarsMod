package com.parzi.starwarsmod.rendering.helper;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class FancyHaloRenderer implements IItemRenderer
{
	public Random rand = new Random();

	@Override
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	{
		Item itype = item.getItem();
		if (itype instanceof IHaloRenderItem)
		{
			IHaloRenderItem ihri = (IHaloRenderItem)itype;
			if (!ihri.drawHalo(item) && !ihri.drawPulseEffect(item)) return false;
		}
		switch (type)
		{
			case INVENTORY:
				return true;
			default:
				break;
		}
		return false;
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
	{
		boolean renderHalo = false;
		boolean renderPulse = false;
		int spread = 0;
		IIcon halo = null;
		int haloColour = 0;
		Item itype = item.getItem();
		if (itype instanceof IHaloRenderItem)
		{
			IHaloRenderItem ihri = (IHaloRenderItem)itype;
			spread = ihri.getHaloSize(item);
			halo = ihri.getHaloTexture(item);
			haloColour = ihri.getHaloColour(item);
			renderHalo = ihri.drawHalo(item);
			renderPulse = ihri.drawPulseEffect(item);
		}
		RenderItem r = RenderItem.getInstance();
		Minecraft mc = Minecraft.getMinecraft();
		Tessellator t = Tessellator.instance;
		switch (type)
		{
			case ENTITY:
				break;
			case INVENTORY:
				GL11.glPushMatrix();
				GL11.glEnable(3042);
				GL11.glBlendFunc(770, 771);
				RenderHelper.enableGUIStandardItemLighting();
				GL11.glDisable(3008);
				GL11.glDisable(2929);
				if (renderHalo)
				{
					float ca = (haloColour >> 24 & 0xFF) / 255.0F;
					float cr = (haloColour >> 16 & 0xFF) / 255.0F;
					float cg = (haloColour >> 8 & 0xFF) / 255.0F;
					float cb = (haloColour & 0xFF) / 255.0F;
					GL11.glColor4f(cr, cg, cb, ca);
					t.startDrawingQuads();
					t.addVertexWithUV(0 - spread, 0 - spread, 0.0D, halo.getMinU(), halo.getMinV());
					t.addVertexWithUV(0 - spread, 16 + spread, 0.0D, halo.getMinU(), halo.getMaxV());
					t.addVertexWithUV(16 + spread, 16 + spread, 0.0D, halo.getMaxU(), halo.getMaxV());
					t.addVertexWithUV(16 + spread, 0 - spread, 0.0D, halo.getMaxU(), halo.getMinV());
					t.draw();
				}
				if (renderPulse)
				{
					GL11.glPushMatrix();
					double xs = this.rand.nextGaussian() * 0.15D + 0.95D;
					double ox = (1.0D - xs) / 2.0D;
					GL11.glEnable(3042);
					GL11.glTranslated(ox * 16.0D, ox * 16.0D, 1.0D);
					GL11.glScaled(xs, xs, 1.0D);
					IIcon icon = item.getItem().getIcon(item, 0);
					t.startDrawingQuads();
					t.setColorRGBA_F(1.0F, 1.0F, 1.0F, 0.6F);
					t.addVertexWithUV(0.0D - ox, 0.0D - ox, 0.0D, icon.getMinU(), icon.getMinV());
					t.addVertexWithUV(0.0D - ox, 16.0D + ox, 0.0D, icon.getMinU(), icon.getMaxV());
					t.addVertexWithUV(16.0D + ox, 16.0D + ox, 0.0D, icon.getMaxU(), icon.getMaxV());
					t.addVertexWithUV(16.0D + ox, 0.0D - ox, 0.0D, icon.getMaxU(), icon.getMinV());
					t.draw();
					GL11.glPopMatrix();
				}
				r.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), item, 0, 0, true);
				GL11.glEnable(3008);
				GL11.glEnable(32826);
				GL11.glEnable(2929);
				r.renderWithColor = true;
				GL11.glDisable(3042);
				GL11.glPopMatrix();
				break;
			default:
				break;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	{
		return false;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\helper\FancyHaloRenderer.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */