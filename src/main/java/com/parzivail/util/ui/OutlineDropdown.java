package com.parzivail.util.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class OutlineDropdown<T> extends GuiButton
{
	public boolean selected;
	public boolean expanded;
	public int expandedHeight;
	private List<OutlineDropdownItem<T>> children;
	private int indentLevel;

	public OutlineDropdown(int id, int x, int y, int w, int h, int indentLevel, String text, boolean selected)
	{
		super(id, x, y, w, h, text);
		this.selected = selected;
		children = new ArrayList<>();
		this.indentLevel = indentLevel;
	}

	public void addChild(OutlineDropdownItem<T> button)
	{
		children.add(button);
		calculateHeight();
		button.xPosition = xPosition + indentLevel;
		button.yPosition = yPosition + expandedHeight - button.height;
		button.visible = button.enabled = false;
	}

	public int getHeight()
	{
		return expanded ? expandedHeight : height;
	}

	private void calculateHeight()
	{
		expandedHeight = height;
		for (GuiButton b : children)
			expandedHeight += b instanceof OutlineDropdown && ((OutlineDropdown)b).expanded ? ((OutlineDropdown)b).expandedHeight : b.height;
	}

	public boolean isHover()
	{
		return this.field_146123_n;
	}

	public void expand()
	{
		expanded = true;
		for (GuiButton b : children)
			b.enabled = b.visible = true;
	}

	public void close()
	{
		expanded = false;
		for (GuiButton b : children)
			b.visible = b.enabled = false;
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
			GL11.glLineWidth(2);

			switch (k)
			{
				case 0:
					textColor = GLPalette.GREY;
					GLPalette.glColorI(GLPalette.DARK_GREY, 0x80);
					break;
				case 1:
					textColor = this.selected ? GLPalette.BLACK : GLPalette.WHITE;
					GLPalette.glColorI(this.selected ? GLPalette.SW_YELLOW : GLPalette.DARK_SW_YELLOW, 0x80);
					break;
				case 2:
					textColor = GLPalette.BLACK;
					GLPalette.glColorI(GLPalette.SW_YELLOW);
					break;
				default:
					break;
			}

			GFX.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, true);

			GLPalette.glColorI(textColor);
			GL11.glPushMatrix();
			GL11.glTranslatef(this.xPosition + this.width - this.width / 10, this.yPosition + this.height / 2f, 0);
			GL11.glRotatef(this.expanded ? 180 : 0, 0, 0, 1);
			GFX.drawLine(2, -2, 0, 0);
			GFX.drawLine(2, 0, 0, 2);

			GFX.drawLine(-2, -2, 0, 0);
			GFX.drawLine(-2, 0, 0, 2);
			GL11.glPopMatrix();

			GL11.glEnable(GL11.GL_TEXTURE_2D);

			GFX.drawText(fontrenderer, this.displayString, this.xPosition + 2, this.yPosition + (this.height - 4) / 2, 0.5f, textColor);

			for (GuiButton b : children)
				b.drawButton(mc, mX, mY);
		}
		GL11.glPopMatrix();
	}

	public void updateChildren()
	{
		int y = this.yPosition + this.height;
		for (GuiButton b : children)
		{
			b.yPosition = y;
			y += b.height;
		}
	}

	public List<OutlineDropdownItem<T>> getChildren()
	{
		return children;
	}
}
