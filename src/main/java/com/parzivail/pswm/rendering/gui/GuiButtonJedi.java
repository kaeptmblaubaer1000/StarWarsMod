package com.parzivail.pswm.rendering.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.rendering.helper.PGui;

public class GuiButtonJedi extends GuiButton
{
	public GuiButtonJedi(int id, int x, int y)
	{
		super(id, x, y, 16, 16, "");
	}

	/**
	 * Draws this button to the screen.
	 */
	public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
	{
		if (this.visible)
		{
			p_146112_1_.getTextureManager().bindTexture(PGui.swIcons);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			boolean flag = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
			int k = 26;

			if (flag)
			{
				k += 17f;
			}

			this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, k, this.width, this.height);
		}
	}
}