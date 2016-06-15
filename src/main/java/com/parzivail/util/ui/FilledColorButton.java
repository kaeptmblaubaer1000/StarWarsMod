package com.parzivail.util.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.opengl.GL11;

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
					GLPalette.glColorI((0xFFFFFF - color) | 0xFF000000 + 0x555555);
					GFX.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, true);
					GLPalette.glColorI(color);
					GFX.drawRectangle(this.xPosition + 1, this.yPosition + 1, this.width - 2, this.height - 2, true);
					GLPalette.glColorI((0xFFFFFF - color) | 0xFF000000 + 0x555555);
					GFX.drawLine(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height);
					break;
				default:
					GLPalette.glColorI(color);
					GFX.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, true);
					break;
			}
			GL11.glEnable(GL11.GL_TEXTURE_2D);

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, textColor);
		}
		GL11.glPopMatrix();
	}
}
