package com.parzivail.util.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class OutlineDropdownItem<T> extends GuiButton
{
	public boolean selected;
	private List<T> tags;

	public OutlineDropdownItem(int id, int x, int y, int w, int h, String text, boolean selected, List<T> tags)
	{
		super(id, x, y, w, h, text);
		this.selected = selected;
		this.tags = tags;
	}

	public boolean isHover()
	{
		return this.field_146123_n;
	}

	public List<T> getTags()
	{
		return tags;
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
					break;
				case 1:
					textColor = GLPalette.WHITE;
					break;
				case 2:
					textColor = GLPalette.SW_YELLOW;
					break;
				default:
					break;
			}
			GL11.glEnable(GL11.GL_TEXTURE_2D);

			GFX.drawText(fontrenderer, this.displayString, this.xPosition + 2, this.yPosition + (this.height - 4) / 2, 0.5f, textColor);
		}
		GL11.glPopMatrix();
	}
}
