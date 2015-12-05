package com.parzi.starwarsmod.rendering.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import scala.Int;

public class PGui// extends Gui
{
	private static ResourceLocation vignetteTexPath = new ResourceLocation("textures/misc/vignette.png");
	private static ResourceLocation icons = new ResourceLocation("textures/PGui/icons.png");
	private static float prevVignetteBrightness = 1.0F;
	private static Minecraft mc;

	public static int getRGB(int r, int g, int b)
	{
		int rgb = r;
		rgb = (rgb << 8) + g;
		rgb = (rgb << 8) + b;
		return rgb;
	}

	public static int rainbowColor(int phaseMod)
	{
		float frequency = 0.001F;
		float phase = Math.abs(Minecraft.getSystemTime() % Int.MaxValue() - Int.MaxValue() / 2);
		int r = (int)(Math.sin(frequency * phase + 0 + phaseMod) * 127 + 128);
		int g = (int)(Math.sin(frequency * phase + 2 + phaseMod) * 127 + 128);
		int b = (int)(Math.sin(frequency * phase + 4 + phaseMod) * 127 + 128);
		return getRGB(r, g, b);
	}

	public PGui(Minecraft minecraft)
	{
		PGui.mc = minecraft;
	}

	/**
	 * Draws center-aligned text
	 *
	 * @param fontRendererIn
	 *            The font renderer
	 * @param text
	 *            The text to draw
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 * @param color
	 *            The color
	 */
	public void drawCenteredString(int x, int y, String string, int color)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		PGui.mc.fontRenderer.drawStringWithShadow(string, x - PGui.mc.fontRenderer.getStringWidth(string) / 2, y - PGui.mc.fontRenderer.FONT_HEIGHT / 2, color);
	}

	/**
	 * Draws a texture on-screen
	 *
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 * @param textureX
	 *            The x position of the texture
	 * @param textureY
	 *            The y position of the texture
	 * @param width
	 *            The width on-screen
	 * @param height
	 *            The height on-screen
	 */
	public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		float f = 0.00390625F;
		float f1 = 0.00390625F;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(x + 0, y + height, 1, (textureX + 0) * f, (textureY + height) * f1);
		tessellator.addVertexWithUV(x + width, y + height, 1, (textureX + width) * f, (textureY + height) * f1);
		tessellator.addVertexWithUV(x + width, y + 0, 1, (textureX + width) * f, (textureY + 0) * f1);
		tessellator.addVertexWithUV(x + 0, y + 0, 1, (textureX + 0) * f, (textureY + 0) * f1);
		tessellator.draw();
	}

	/**
	 * Draws an IIcon
	 *
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 * @param icon
	 *            The icon to draw
	 * @param width
	 *            The width of the icon
	 * @param height
	 *            The height of the icon
	 */
	public void drawTexturedModelRectFromIcon(int x, int y, IIcon icon, int width, int height)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(x + 0, y + height, 1, icon.getMinU(), icon.getMaxV());
		tessellator.addVertexWithUV(x + width, y + height, 1, icon.getMaxU(), icon.getMaxV());
		tessellator.addVertexWithUV(x + width, y + 0, 1, icon.getMaxU(), icon.getMinV());
		tessellator.addVertexWithUV(x + 0, y + 0, 1, icon.getMinU(), icon.getMinV());
		tessellator.draw();
	}

	/**
	 * Renders a progress bar on-screen
	 *
	 * @param caption
	 *            The string to display above the bar
	 * @param percent
	 *            The percentage full of the bar (0-1)
	 * @param xpBar
	 *            True if you want to draw an XP-style bar instead of a boss bar
	 */
	public void renderBarOnscreen(String caption, float percent, boolean xpBar)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		PGui.mc.getTextureManager().bindTexture(icons);
		GL11.glEnable(3042);
		FontRenderer fontrenderer = PGui.mc.fontRenderer;
		ScaledResolution scaledresolution = new ScaledResolution(mc, PGui.mc.displayWidth, PGui.mc.displayHeight);
		int i = scaledresolution.getScaledWidth();
		short short1 = 182;
		int j = i / 2 - short1 / 2;
		int k = (int)(percent * (short1 + 1));
		byte b0 = 12;
		this.drawTexturedModalRect(j, b0, 0, xpBar ? 64 : 74, short1, 5);
		this.drawTexturedModalRect(j, b0, 0, xpBar ? 64 : 74, short1, 5);
		if (k > 0) this.drawTexturedModalRect(j, b0, 0, xpBar ? 69 : 79, k, 5);
		fontrenderer.drawStringWithShadow(caption, i / 2 - fontrenderer.getStringWidth(caption) / 2, b0 - 10, 16777215);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(3042);
	}

	/**
	 * Renders some hearts on-screen
	 *
	 * @param x
	 *            The x position of the hearts
	 * @param y
	 *            The y position of the hearts
	 * @param amount
	 *            The amount of full hearts, in half hearts
	 * @param max
	 *            The maximum number of hearts displayed, in half hearts
	 * @param wrap
	 *            The amount of hearts per row, -1 for infinite
	 */
	public void renderHearts(int x, int y, int amount, int max, int wrap)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		PGui.mc.getTextureManager().bindTexture(icons);
		GL11.glEnable(3042);
		int sx = x;
		ScaledResolution scaledresolution = new ScaledResolution(mc, PGui.mc.displayWidth, PGui.mc.displayHeight);
		scaledresolution.getScaledWidth();
		scaledresolution.getScaledHeight();
		int health = amount;
		int healthMax = max;
		int healthRows = MathHelper.ceiling_float_int(healthMax / 2.0F / 10.0F);
		int rowHeight = Math.max(10 - (healthRows - 2), 3);
		if (rowHeight != 10)
		{
		}
		int MARGIN = 16;
		for (int i = 0; i < MathHelper.ceiling_float_int(healthMax / 2.0F); i++)
		{
			this.drawTexturedModalRect(x, y, 16, 0, 9, 9);
			if (i * 2 + 1 < health)
				this.drawTexturedModalRect(x, y, MARGIN + 36, 0, 9, 9);
			else if (i * 2 + 1 == health) this.drawTexturedModalRect(x, y, MARGIN + 45, 0, 9, 9);
			if ((i + 1) % wrap == 0 && wrap != -1)
			{
				x = sx;
				y += 8;
			}
			else
				x += 8;
		}
		GL11.glDisable(3042);
	}

	/**
	 * Renders an item on-screen
	 *
	 * @param x
	 *            The x position of the item
	 * @param y
	 *            The y position of the item
	 * @param item
	 *            The item to render (stackSize == 0 ? don't render text :
	 *            render stack size)
	 */
	public void renderItem(int x, int y, ItemStack item)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glDisable(3008);
		GL11.glDisable(2929);
		RenderItem r = RenderItem.getInstance();
		r.renderItemIntoGUI(PGui.mc.fontRenderer, PGui.mc.getTextureManager(), item, x, y, true);
		r.renderItemOverlayIntoGUI(PGui.mc.fontRenderer, PGui.mc.getTextureManager(), item, x, y, item.stackSize > 0 ? String.valueOf(item.stackSize) : "");
		GL11.glEnable(3008);
		GL11.glEnable(32826);
		GL11.glEnable(2929);
		GL11.glDisable(3042);
		net.minecraft.client.renderer.RenderHelper.enableGUIStandardItemLighting();
	}

	/**
	 * Renders an overlay on-screen, stretching to fit
	 *
	 * @param PGuiTexture
	 *            The resource to render
	 */
	public void renderOverlay(ResourceLocation PGuiTexture)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		ScaledResolution scaledresolution = new ScaledResolution(mc, PGui.mc.displayWidth, PGui.mc.displayHeight);
		int k = scaledresolution.getScaledWidth();
		int l = scaledresolution.getScaledHeight();
		GL11.glDisable(2929);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(3008);
		PGui.mc.getTextureManager().bindTexture(PGuiTexture);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(0.0D, l, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(k, l, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(k, 0.0D, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
		tessellator.draw();
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glEnable(2929);
		GL11.glEnable(3008);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	/**
	 * Renders an overlay on-screen
	 *
	 * @param PGuiTexture
	 *            The resource to render
	 * @param x
	 *            The x position of the overlay
	 * @param y
	 *            The y position of the overlay
	 * @param w
	 *            The width of the overlay
	 * @param h
	 *            The height of the overlay
	 */
	public void renderOverlay(ResourceLocation PGuiTexture, int x, int y, int w, int h)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		int k = w;
		int l = h;
		GL11.glDisable(2929);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(3008);
		PGui.mc.getTextureManager().bindTexture(PGuiTexture);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(x, l + y, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(k + x, l + y, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(k + x, y, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(x, y, -90.0D, 0.0D, 0.0D);
		tessellator.draw();
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glEnable(2929);
		GL11.glEnable(3008);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	/**
	 * Renders a string on-screen
	 *
	 * @param x
	 *            The x position of the string
	 * @param y
	 *            The y position of the string
	 * @param string
	 *            The string to render
	 * @param color
	 *            The color of the string
	 */
	public void renderString(int x, int y, String string, int color)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		PGui.mc.fontRenderer.drawStringWithShadow(string, x, y, color);
	}

	/**
	 * Renders a vignette on-screen
	 *
	 * @param brightness
	 *            The brightness (0-1)
	 */
	public void renderVignette(float brightness)
	{
		GL11.glEnable(3042);
		PGui.mc.entityRenderer.setupOverlayRendering();
		ScaledResolution scaledresolution = new ScaledResolution(mc, PGui.mc.displayWidth, PGui.mc.displayHeight);

		int width = scaledresolution.getScaledWidth();
		int height = scaledresolution.getScaledHeight();

		brightness = 1.0F - brightness;
		if (brightness < 0.0F) brightness = 0.0F;
		if (brightness > 1.0F) brightness = 1.0F;

		prevVignetteBrightness = (float)(prevVignetteBrightness + (brightness - prevVignetteBrightness) * 0.01D);

		GL11.glDisable(2929);
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(0, 769, 1, 0);
		GL11.glColor4f(prevVignetteBrightness, prevVignetteBrightness, prevVignetteBrightness, 1.0F);

		PGui.mc.getTextureManager().bindTexture(vignetteTexPath);

		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(0.0D, height, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(width, height, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(width, 0.0D, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
		tessellator.draw();
		GL11.glDepthMask(true);
		GL11.glEnable(2929);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glDisable(3042);
	}
}
