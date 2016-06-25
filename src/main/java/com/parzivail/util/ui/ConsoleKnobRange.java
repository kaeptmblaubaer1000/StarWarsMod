package com.parzivail.util.ui;

import com.parzivail.util.math.MathUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ConsoleKnobRange extends GuiButton
{
	private String name;
	public float value;
	public boolean changeFlag;
	public float min;
	public float max;
	public int colorFg = GLPalette.ANALOG_GREEN;

	public ConsoleKnobRange(int id, int x, int y, int width, float value, float min, float max, String text)
	{
		super(id, x, y, width, width, "");
		this.name = text;
		this.min = min;
		this.max = max;
		this.value = MathUtils.map(this.value, min, max, 0, 1);
		this.displayString = String.format("%s: %2$.1f", this.name, this.getValue());
	}

	/**
	 * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over
	 * this button and 2 if it IS hovering over this button.
	 */
	public int getHoverState(boolean p_146114_1_)
	{
		return 0;
	}

	public float getValue()
	{
		return MathUtils.map(this.value, 0, 1, min, max);
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
				this.value = (float)(p_146119_2_ - this.xPosition + (this.width / 2)) / ((float)this.width * 2);

				if (this.value < 0.0F)
				{
					this.value = 0.0F;
				}

				if (this.value > 1.0F)
				{
					this.value = 1.0F;
				}

				if (KeyboardUtils.isShiftDown())
					this.value = MathUtils.map(Math.round(getValue()), min, max, 0, 1);

				this.displayString = String.format("%s: %2$.1f", this.name, this.getValue());
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
			this.changeFlag = true;
			return true;
		}
		else
		{
			return false;
		}
	}

	public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
	{
		GL11.glPushMatrix();
		if (this.visible)
		{
			FontRenderer fontrenderer = p_146112_1_.fontRenderer;
			GLPalette.glColorI(GLPalette.GREY);
			this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
			this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);

			GLPalette.glColorI(colorFg);
			GFX.drawCircle(this.xPosition + (this.width / 2), this.yPosition + (this.width / 2), this.width / 2);

			double mx = MathHelper.cos((float)(((1 - this.value) * -270 + 45) / 180 * Math.PI));
			double my = MathHelper.sin((float)(((1 - this.value) * -270 + 45) / 180 * Math.PI));

			GFX.drawLine(this.xPosition + this.width / 2 + mx * this.width / 3, this.yPosition + this.width / 2 + my * this.width / 3, this.xPosition + this.width / 2 + mx * this.width / 2, this.yPosition + this.width / 2 + my * this.width / 2);

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GFX.drawCenteredText(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + this.height + 2, 0.75f, GLPalette.WHITE);
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