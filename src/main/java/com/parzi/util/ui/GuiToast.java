package com.parzi.util.ui;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;

public class GuiToast extends Gui
{
	/** A short timespan, 4 seconds **/
	public static final int TIME_SHORT = 80;
	/** A long timespan, 8 seconds **/
	public static final int TIME_LONG = 160;
	/** All active toasts **/
	public static ArrayList<GuiToast> toasts = new ArrayList<GuiToast>();

	/** How many ticks are left in it's existence **/
	private int life = 0;
	/** The toast's text **/
	private String[] text;
	private int width;
	/** The position of the toast **/
	private int position = ToastPosition.BOTTOM | ToastPosition.MIDDLE;

	/**
	 * Private constructor for a new toast
	 * 
	 * @param text The text to show
	 * @param length The timespan it should be shown
	 * @param position The {@link ToastPosition} of the toast
	 */
	private GuiToast(String text, int length, int position)
	{
		this.life = length;
		this.position = position;

		this.text = TextUtils.splitIntoLine(text, 25);
		
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
		
		for (String line : this.text)
			if (fontRenderer.getStringWidth(line) > this.width)
				this.width = fontRenderer.getStringWidth(line);
	}

	/**
	 * Render method called by {@link GuiManager}
	 * @param stack The vertical stack size, for stacking
	 */
	public void render(int stack)
	{
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
		
		GL11.glPushMatrix();
		GL11.glEnable(3042);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		
		int height = (this.text.length + 1) * fontRenderer.FONT_HEIGHT;
		
		int x = ((this.position & ToastPosition.LEFT) == ToastPosition.LEFT) ? 5 : (((this.position & ToastPosition.MIDDLE) == ToastPosition.MIDDLE) ? res.getScaledWidth() / 2 - ((this.width + 8) / 2): res.getScaledWidth() - 13 - this.width);
		int y = ((this.position & ToastPosition.TOP) == ToastPosition.TOP) ? 5 : res.getScaledHeight() - 45 - height;

		y += (((this.position & ToastPosition.TOP) == ToastPosition.TOP) ? stack  : -stack) * (height + 2);
		
		drawBackdrop(x, y, this.width + 8, height, 255);

		GL11.glEnable(3042);
		
		for (int i = 0; i < this.text.length; i++)
			fontRenderer.drawStringWithShadow(this.text[i], x + 4, y + (i * (fontRenderer.FONT_HEIGHT + 1)) + 4, GlPalette.WHITE);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(this.icons);
		GL11.glPopMatrix();
	}

	/**
	 * Draws the tooltip backdrop
	 * @param x The x position
	 * @param y The y position
	 * @param width The width
	 * @param height The height
	 * @param opacity The opacity (0-255)
	 */
	private void drawBackdrop(int x, int y, int width, int height, int opacity)
	{
		int color = opacity << 24;
		this.drawRect(x + 1, y, x + width - 1, y + height, color);
		this.drawRect(x, y + 1, x + 1, y + height - 1, color);
		this.drawRect(x + width - 1, y + 1, x + width, y + height - 1, color);

		color = 0x28025C | opacity << 24;
		this.drawRect(x + 1, y + 1, x + width - 1, y + 2, color);
		this.drawRect(x + 1, y + height - 1, x + width - 1, y + height - 2, color);
		this.drawRect(x + 1, y + 1, x + 2, y + height - 1, color);
		this.drawRect(x + width - 1, y + 1, x + width - 2, y + height - 1, color);
	}

	/**
	 * Creates a new toast, but doesn't show it
	 * @param text The text to notify the player
	 * @param length The timespan to show for
	 * @param position The {@link ToastPotition} of the toast
	 * @return The new toast
	 */
	public static GuiToast makeText(Object text, int length, int position)
	{
		return new GuiToast(String.valueOf(text), length, position);
	}
	
	/**
	 * Creates a new toast in the default position (bottom right), but doesn't show it
	 * @param text The text to notify the player
	 * @param length The timespan to show for
	 * @return The new toast
	 */
	public static GuiToast makeText(Object text, int length)
	{
		return makeText(text, length, ToastPosition.BOTTOM | ToastPosition.RIGHT);
	}

	/**
	 * Adds the toast to the list of currently active toasts
	 */
	public void show()
	{
		toasts.add(this);
	}

	/**
	 * @return The amount of ticks remaining in the toast's lifespan
	 */
	public int getLife()
	{
		return this.life;
	}

	/**
	 * Decreases the toast's remaining life
	 */
	public void tick()
	{
		this.life--;
	}

	public class ToastPosition
	{
		public static final int TOP = 1;
		public static final int BOTTOM = 2;
		public static final int LEFT = 4;
		public static final int MIDDLE = 8;
		public static final int RIGHT = 16;
	}
}
