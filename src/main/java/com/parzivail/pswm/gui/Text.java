package com.parzivail.pswm.gui;

import com.parzivail.util.ui.GLPalette;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Colby on 12/2/2016.
 */
public class Text
{
	public class TextOptions
	{
		public static final int NORMAL = 0;
		public static final int CENTER = 1;
		public static final int SHADOW = 2;
		public static final int OUTLINE = 4;
	}

	public FontRenderer font;
	public String text;
	public float x;
	public float y;
	public float scale;
	public int color;
	public int outlineColor = GLPalette.ALMOST_BLACK;
	public int options;

	public float shadowDistance = 1f;
	public float outlineDistance = 1f;

	public Text(FontRenderer font, String text, float x, float y, float scale, int color, int options)
	{
		this.font = font;
		this.text = text;
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.color = color;
		this.options = options;
	}

	public void render()
	{
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_TEXTURE_2D);
		GL11.glScalef(scale, scale, 1);
		GL11.glTranslatef(x / scale, y / scale, 0);

		GL11.glTranslatef(x, y, 0);

		if (hasOption(TextOptions.CENTER))
			GL11.glTranslatef(-font.getStringWidth(text) / 2f, 0, 0);

		if (hasOption(TextOptions.SHADOW))
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(shadowDistance, shadowDistance, 0);
			font.drawString(text, 0, 0, GLPalette.ALMOST_BLACK, false);
			GL11.glPopMatrix();
		}
		else if (hasOption(TextOptions.OUTLINE))
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(-outlineDistance, -outlineDistance, 0);
			font.drawString(text, 0, 0, outlineColor, false);
			GL11.glTranslatef(2 * shadowDistance, 0, 0);
			font.drawString(text, 0, 0, outlineColor, false);
			GL11.glTranslatef(0, 2 * shadowDistance, 0);
			font.drawString(text, 0, 0, outlineColor, false);
			GL11.glTranslatef(-2 * shadowDistance, 0, 0);
			font.drawString(text, 0, 0, outlineColor, false);
			GL11.glPopMatrix();
		}

		font.drawString(text, 0, 0, color, false);

		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}

	private boolean hasOption(int opt)
	{
		return (options & opt) == opt;
	}
}
