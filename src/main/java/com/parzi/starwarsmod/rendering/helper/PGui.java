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

import com.parzi.starwarsmod.StarWarsMod;

public class PGui// extends Gui
{
	private static ResourceLocation vignetteTexPath = new ResourceLocation("textures/misc/vignette.png");
	private static ResourceLocation icons = new ResourceLocation("textures/gui/icons.png");
	private static float prevVignetteBrightness = 1.0F;
	private static Minecraft mc;

	public PGui(Minecraft minecraft)
	{
		PGui.mc = minecraft;
	}

	public static void drawModalRectWithCustomSizedText(int x, int y, float u, float v, int width, int height, float textureWidth, float textureHeight)
	{
		float f4 = 1.0F / textureWidth;
		float f5 = 1.0F / textureHeight;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(x, y + height, 0.0D, u * f4, (v + height) * f5);
		tessellator.addVertexWithUV(x + width, y + height, 0.0D, (u + width) * f4, (v + height) * f5);
		tessellator.addVertexWithUV(x + width, y, 0.0D, (u + width) * f4, v * f5);
		tessellator.addVertexWithUV(x, y, 0.0D, u * f4, v * f5);
		tessellator.draw();
	}

	/**
	 * Draws a solid color rectangle with the specified coordinates and color.
	 * Args: x1, y1, x2, y2, color
	 */
	public static void drawRect(int x1, int y1, int x2, int y2, int color)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();

		int j1;

		if (x1 < x2)
		{
			j1 = x1;
			x1 = x2;
			x2 = j1;
		}

		if (y1 < y2)
		{
			j1 = y1;
			y1 = y2;
			y2 = j1;
		}
		float f3 = (color >> 24 & 255) / 255.0F;
		float f = (color >> 16 & 255) / 255.0F;
		float f1 = (color >> 8 & 255) / 255.0F;
		float f2 = (color & 255) / 255.0F;
		Tessellator tessellator = Tessellator.instance;
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(f, f1, f2, f3);
		tessellator.startDrawingQuads();
		tessellator.addVertex(x1, y2, 0.0D);
		tessellator.addVertex(x2, y2, 0.0D);
		tessellator.addVertex(x2, y1, 0.0D);
		tessellator.addVertex(x1, y1, 0.0D);
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
	}

	/**
	 * Draws a solid color rectangle with the specified coordinates and color.
	 * Args: x1, y1, x2, y2, color
	 */
	public static void drawRect(int x1, int y1, int x2, int y2, int r, int g, int b, int a)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();

		int j1;

		if (x1 < x2)
		{
			j1 = x1;
			x1 = x2;
			x2 = j1;
		}

		if (y1 < y2)
		{
			j1 = y1;
			y1 = y2;
			y2 = j1;
		}
		Tessellator tessellator = Tessellator.instance;
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(r / 255f, g / 255f, b / 255f, a / 255f);
		tessellator.startDrawingQuads();
		tessellator.addVertex(x1, y2, 0.0D);
		tessellator.addVertex(x2, y2, 0.0D);
		tessellator.addVertex(x2, y1, 0.0D);
		tessellator.addVertex(x1, y1, 0.0D);
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
	}

	public static void drawScaledCustomSizeModalRect(int p_152125_0_, int p_152125_1_, float p_152125_2_, float p_152125_3_, int p_152125_4_, int p_152125_5_, int p_152125_6_, int p_152125_7_, float p_152125_8_, float p_152125_9_)
	{
		float f4 = 1.0F / p_152125_8_;
		float f5 = 1.0F / p_152125_9_;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(p_152125_0_, p_152125_1_ + p_152125_7_, 0.0D, p_152125_2_ * f4, (p_152125_3_ + p_152125_5_) * f5);
		tessellator.addVertexWithUV(p_152125_0_ + p_152125_6_, p_152125_1_ + p_152125_7_, 0.0D, (p_152125_2_ + p_152125_4_) * f4, (p_152125_3_ + p_152125_5_) * f5);
		tessellator.addVertexWithUV(p_152125_0_ + p_152125_6_, p_152125_1_, 0.0D, (p_152125_2_ + p_152125_4_) * f4, p_152125_3_ * f5);
		tessellator.addVertexWithUV(p_152125_0_, p_152125_1_, 0.0D, p_152125_2_ * f4, p_152125_3_ * f5);
		tessellator.draw();
	}

	public static int getRGB(int r, int g, int b)
	{
		int rgb = r;
		rgb = (rgb << 8) + g;
		rgb = (rgb << 8) + b;
		return rgb;
	}

	public static int getRGBA(int r, int g, int b, int a)
	{
		int rgba = a;
		rgba = (rgba << 8) + r;
		rgba = (rgba << 8) + g;
		rgba = (rgba << 8) + b;
		return rgba;
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
	 * Draws a filled circle
	 *
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 * @param radius
	 *            The radius
	 * @param color
	 *            The color
	 */
	public void drawFilledCircle(int x, int y, double radius, int color)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		float f = (color >> 24 & 0xff) / 255F;
		float f1 = (color >> 16 & 0xff) / 255F;
		float f2 = (color >> 8 & 0xff) / 255F;
		float f3 = (color & 0xff) / 255F;
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glBlendFunc(770, 771);
		GL11.glColor4f(f1, f2, f3, f);
		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		for (int i = 0; i <= 360; i++)
		{
			double nx = Math.sin(i * 3.141526D / 180) * radius;
			double ny = Math.cos(i * 3.141526D / 180) * radius;
			GL11.glVertex2d(nx + x, ny + y);
		}
		GL11.glEnd();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
	}

	/**
	 * Draws a filled isoceles triangle
	 *
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 * @param scale
	 *            The scale
	 * @param theta
	 *            The rotation theta
	 * @param color
	 *            The color
	 */
	public void drawFilledTriangle(double x, double y, int scale, float theta, int color)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		GL11.glTranslated(x, y, 0);
		GL11.glRotatef(180 + theta, 0F, 0F, 1.0F);
		float f = (color >> 24 & 0xff) / 255F;
		float f1 = (color >> 16 & 0xff) / 255F;
		float f2 = (color >> 8 & 0xff) / 255F;
		float f3 = (color & 0xff) / 255F;
		GL11.glColor4f(f1, f2, f3, f);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glBlendFunc(770, 771);
		GL11.glBegin(GL11.GL_TRIANGLES);

		GL11.glVertex2d(0, 1 * scale);
		GL11.glVertex2d(1 * scale, -(1 * scale));
		GL11.glVertex2d(-(1 * scale), -(1 * scale));

		GL11.glEnd();
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glRotatef(-180 - theta, 0F, 0F, 1.0F);
		GL11.glTranslated(-x, -y, 0);
	}

	/**
	 * Draws a rectangle with a vertical gradient between the specified colors.
	 */
	public void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();

		float f = (startColor >> 24 & 255) / 255.0F;
		float f1 = (startColor >> 16 & 255) / 255.0F;
		float f2 = (startColor >> 8 & 255) / 255.0F;
		float f3 = (startColor & 255) / 255.0F;
		float f4 = (endColor >> 24 & 255) / 255.0F;
		float f5 = (endColor >> 16 & 255) / 255.0F;
		float f6 = (endColor >> 8 & 255) / 255.0F;
		float f7 = (endColor & 255) / 255.0F;
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(f1, f2, f3, f);
		tessellator.addVertex(right, top, 0);
		tessellator.addVertex(left, top, 0);
		tessellator.setColorRGBA_F(f5, f6, f7, f4);
		tessellator.addVertex(left, bottom, 0);
		tessellator.addVertex(right, bottom, 0);
		tessellator.draw();
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	/**
	 * Draws a rectangle with a vertical gradient between the specified colors.
	 */
	public void drawGradientRectHoriz(int left, int top, int right, int bottom, int startColor, int endColor)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();

		float f = (startColor >> 24 & 255) / 255.0F;
		float f1 = (startColor >> 16 & 255) / 255.0F;
		float f2 = (startColor >> 8 & 255) / 255.0F;
		float f3 = (startColor & 255) / 255.0F;
		float f4 = (endColor >> 24 & 255) / 255.0F;
		float f5 = (endColor >> 16 & 255) / 255.0F;
		float f6 = (endColor >> 8 & 255) / 255.0F;
		float f7 = (endColor & 255) / 255.0F;
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(f1, f2, f3, f);
		tessellator.addVertex(right, top, 0);
		tessellator.addVertex(right, bottom, 0);
		tessellator.setColorRGBA_F(f5, f6, f7, f4);
		tessellator.addVertex(left, bottom, 0);
		tessellator.addVertex(left, top, 0);
		tessellator.draw();
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	/**
	 * Draws a hollow circle
	 *
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 * @param radius
	 *            The radius
	 * @param segments
	 *            The number of segments
	 * @param lineWidth
	 *            The width of the line
	 * @param color
	 *            The color
	 */
	public void drawHollowCircle(float x, float y, float radius, int segments, float lineWidth, int color)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		float f = (color >> 24 & 0xff) / 255F;
		float f1 = (color >> 16 & 0xff) / 255F;
		float f2 = (color >> 8 & 0xff) / 255F;
		float f3 = (color & 0xff) / 255F;
		float theta = (float)(2 * 3.1415926 / segments);
		float p = (float)Math.cos(theta);// calculate the sine and cosine
		float s = (float)Math.sin(theta);
		float t;
		GL11.glColor4f(f1, f2, f3, f);
		float nx = radius;
		float ny = 0;// start at angle = 0
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glBlendFunc(770, 771);
		GL11.glLineWidth(lineWidth);
		GL11.glBegin(GL11.GL_LINE_LOOP);
		for (int ii = 0; ii < segments; ii++)
		{
			GL11.glVertex2f(nx + x, ny + y);// final vertex vertex

			// rotate the stuff
			t = nx;
			nx = p * nx - s * ny;
			ny = s * t + p * ny;
		}
		GL11.glEnd();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
	}

	/**
	 * Draws a hollow isoceles triangle
	 *
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 * @param scale
	 *            The scale
	 * @param theta
	 *            The rotation theta
	 * @param lineWidth
	 *            The line width
	 * @param color
	 *            The color
	 */
	public void drawHollowTriangle(double x, double y, int scale, float theta, int lineWidth, int color)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		GL11.glTranslated(x, y, 0);
		GL11.glRotatef(180 + theta, 0F, 0F, 1.0F);
		float f = (color >> 24 & 0xff) / 255F;
		float f1 = (color >> 16 & 0xff) / 255F;
		float f2 = (color >> 8 & 0xff) / 255F;
		float f3 = (color & 0xff) / 255F;
		GL11.glColor4f(f1, f2, f3, f);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glBlendFunc(770, 771);
		GL11.glLineWidth(lineWidth);
		GL11.glBegin(GL11.GL_LINE_LOOP);

		GL11.glVertex2d(0, 1 * scale);
		GL11.glVertex2d(1 * scale, -(1 * scale));
		GL11.glVertex2d(-(1 * scale), -(1 * scale));

		GL11.glEnd();
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glRotatef(-180 - theta, 0F, 0F, 1.0F);
		GL11.glTranslated(-x, -y, 0);
	}

	/**
	 * Draws a line
	 *
	 * @param x1
	 *            The start x
	 * @param y1
	 *            The start y
	 * @param x2
	 *            The end x
	 * @param y2
	 *            The end y
	 * @param lineWidth
	 *            The line width
	 * @param color
	 *            The line color
	 */
	public void drawLine(double x1, double y1, double x2, double y2, int lineWidth, int color)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		float f = (color >> 24 & 0xff) / 255F;
		float f1 = (color >> 16 & 0xff) / 255F;
		float f2 = (color >> 8 & 0xff) / 255F;
		float f3 = (color & 0xff) / 255F;
		GL11.glColor4f(f1, f2, f3, f);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glBlendFunc(770, 771);
		GL11.glLineWidth(lineWidth);
		GL11.glBegin(GL11.GL_LINE_LOOP);

		GL11.glVertex2d(x1, y1);
		GL11.glVertex2d(x2, y2);

		GL11.glEnd();
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
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
		if (k > 0)
			this.drawTexturedModalRect(j, b0, 0, xpBar ? 69 : 79, k, 5);
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
			else if (i * 2 + 1 == health)
				this.drawTexturedModalRect(x, y, MARGIN + 45, 0, 9, 9);
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
	 * Renders an overlay on-screen, stretching to fit
	 *
	 * @param PGuiTexture
	 *            The resource to render
	 * @param offsetX
	 *            The x offset
	 * @param offsetY
	 *            The y offset
	 */
	public void renderOverlay(ResourceLocation PGuiTexture, float offsetX, float offsetY)
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
		tessellator.addVertexWithUV(0.0D + offsetX, l + offsetY, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(k + offsetX, l + offsetY, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(k + offsetX, 0.0D + offsetY, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D + offsetX, 0.0D + offsetY, -90.0D, 0.0D, 0.0D);
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
	public void renderOverlay(ResourceLocation PGuiTexture, float x, float y, float w, float h)
	{
		PGui.mc.entityRenderer.setupOverlayRendering();
		float k = w;
		float l = h;
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
		if (brightness < 0.0F)
			brightness = 0.0F;
		if (brightness > 1.0F)
			brightness = 1.0F;

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
