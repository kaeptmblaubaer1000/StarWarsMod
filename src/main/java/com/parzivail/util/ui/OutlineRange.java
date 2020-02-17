package com.parzivail.util.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.opengl.GL11;

public class OutlineRange extends OutlineButton
{
	public float value;
	public boolean changeFlag;
	public float multiplier;
	public int colorFg = GLPalette.SW_YELLOW;
	public int colorBg = GLPalette.DARK_SW_YELLOW;
	private String name;
	private String formatter;

	public OutlineRange(int id, int x, int y, int width, float multiplier, String text, String formatter)
	{
		super(id, x, y, width, 10, "", false);
		this.name = text;
		this.multiplier = multiplier;
		this.formatter = formatter;
		this.displayString = String.format(this.formatter, this.name, this.getValue());
		this.value = 0;
	}

	/**
	 * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over
	 * this button and 2 if it IS hovering over this button.
	 */
	public int getHoverState(boolean p_146114_1_)
	{
		return this.enabled ? 1 : 0;
	}

	/**
	 * Gets the modified value between 0-[multiplier]
	 */
	public float getValue()
	{
		return this.value * this.multiplier;
	}

	/**
	 * Sets the value to the given parameter / [multiplier]
	 *
	 * @param n A precentage between 0-[multiplier]
	 */
	public void setValue(float n)
	{
		this.value = n / this.multiplier;
		this.displayString = String.format(this.formatter, this.name, this.getValue());
	}

	/**
	 * Fired when the mouse button is dragged. Equivalent of
	 * MouseListener.mouseDragged(MouseEvent e).
	 */
	protected void mouseDragged(Minecraft p_146119_1_, int p_146119_2_, int p_146119_3_)
	{
		if (this.visible)
		{
			if (this.changeFlag)
			{
				this.value = (float)(p_146119_2_ - (this.xPosition)) / (float)(this.width - 2);

				if (this.value < 0.0F)
				{
					this.value = 0.0F;
				}

				if (this.value > 1.0F)
				{
					this.value = 1.0F;
				}

				if (KeyboardUtils.isShiftDown())
					this.value = Math.round(this.value * this.multiplier) / this.multiplier;

				this.displayString = String.format(this.formatter, this.name, this.getValue());
			}
		}
	}

	/**
	 * Returns true if the mouse has been pressed on this control. Equivalent of
	 * MouseListener.mousePressed(MouseEvent e).
	 */
	public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_)
	{
		if (super.mousePressed(p_146116_1_, p_146116_2_, p_146116_3_))
		{
			this.value = (float)(p_146116_2_ - (this.xPosition)) / (float)(this.width - 2);

			if (this.value < 0.0F)
			{
				this.value = 0.0F;
			}

			if (this.value > 1.0F)
			{
				this.value = 1.0F;
			}

			if (KeyboardUtils.isShiftDown())
				this.value = Math.round(this.value * this.multiplier) / this.multiplier;

			this.displayString = String.format(this.formatter, this.name, this.getValue());
			this.changeFlag = true;
			return true;
		}
		else
		{
			return false;
		}
	}

	public void drawButton(Minecraft p_146112_1_, int mX, int mY)
	{
		GL11.glPushMatrix();
		if (this.visible)
		{
			this.field_146123_n = mX >= this.xPosition && mY >= this.yPosition && mX < this.xPosition + this.width && mY < this.yPosition + this.height;
			int k = this.getHoverState(this.field_146123_n);

			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glLineWidth(3);
			FontRenderer fontrenderer = p_146112_1_.fontRenderer;
			switch (k)
			{
				case 0:
					GLPalette.glColorI(GLPalette.GREY);
					break;
				default:
					GLPalette.glColorI(this.colorBg);
					break;
			}
			GFX.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, false);
			this.mouseDragged(p_146112_1_, mX, mY);

			switch (k)
			{
				case 0:
					GLPalette.glColorI(GLPalette.GREY);
					break;
				default:
					GLPalette.glColorI(this.colorFg);
					break;
			}
			GFX.drawRectangle(this.xPosition + (int)(this.value * (float)(this.width - 4)), this.yPosition, 4, 10, true);

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GFX.drawCenteredText(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 5.5f) / 2, 0.75f, GLPalette.WHITE);
		}
		GL11.glPopMatrix();
	}

	public void func_146113_a(SoundHandler p_146113_1_)
	{
	}

	/**
	 * Fired when the mouse button is released. Equivalent of
	 * MouseListener.mouseReleased(MouseEvent e).
	 */
	public void mouseReleased(int p_146118_1_, int p_146118_2_)
	{
		if (this.changeFlag)
		{
			// do change stuff
		}

		this.changeFlag = false;
	}
}