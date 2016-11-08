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
	private String prefix;
	private int hoverIndent;

	public OutlineDropdownItem(int id, int x, int y, int w, int h, String text, boolean selected, List<T> tags, String prefix, int hoverIndent)
	{
		super(id, x, y, w, h, text);
		this.selected = selected;
		this.tags = tags;
		this.prefix = prefix;
		this.hoverIndent = hoverIndent;
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

			int indent = 0;

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
					indent = hoverIndent;
					textColor = GLPalette.SW_YELLOW;
					break;
				default:
					break;
			}
			GL11.glEnable(GL11.GL_TEXTURE_2D);

			String finalText = TextUtils.maxLength(fontrenderer, String.format("%s%s", prefix, this.displayString), this.width - 4 - indent, 0.5f);

			GFX.drawText(fontrenderer, finalText, this.xPosition + 2 + indent, this.yPosition + (this.height - 4) / 2, 0.5f, textColor);
		}
		GL11.glPopMatrix();
	}
}
