package com.parzivail.util.ui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class FilledColorButton extends OutlineButton
{
	public int color;

	public FilledColorButton(int id, int x, int y, int w, int h, int color)
	{
		super(id, x, y, w, h, "", false);
		this.color = color;
	}

	@Override
	public void drawButton(Minecraft mc, int mX, int mY)
	{
		GL11.glPushMatrix();
		if (this.visible)
		{
			FontRenderer fontrenderer = mc.fontRenderer;
			this.field_146123_n = mX >= this.xPosition && mY >= this.yPosition && mX < this.xPosition + this.width && mY < this.yPosition + this.height;
			int k = this.getHoverState(this.field_146123_n);
			this.mouseDragged(mc, mX, mY);
			
			int textColor = GLPalette.WHITE;

			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glLineWidth(3);
			switch (k)
			{
				case 0:
					textColor = GLPalette.GREY;
					GLPalette.glColorI(GLPalette.DARK_GREY);
					Screen2D.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, true);
					break;
				default:
					GLPalette.glColorI(color);
					Screen2D.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, true);
					break;
			}
			GL11.glEnable(GL11.GL_TEXTURE_2D);

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, textColor);
		}
		GL11.glPopMatrix();
	}
}
