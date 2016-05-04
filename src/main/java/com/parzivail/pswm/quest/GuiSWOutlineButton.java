package com.parzivail.pswm.quest;

import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.TextUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

public class GuiSWOutlineButton extends GuiButton
{
	public GuiSWOutlineButton(int id, int x, int y, int w, int h, String text)
	{
		super(id, x, y, w, h, text);
	}

	/**
	 * Draws this button to the screen.
	 */
	public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
	{
		if (this.visible)
		{
			FontRenderer fontrenderer = p_146112_1_.fontRenderer;
			p_146112_1_.getTextureManager().bindTexture(buttonTextures);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
			int k = this.getHoverState(this.field_146123_n);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GLPalette.glColorI(0xFFFFD400);
			GL11.glPushMatrix();
			GL11.glLineWidth(2);
			GL11.glBegin(GL11.GL_LINE_LOOP);
			GL11.glVertex3f(xPosition, yPosition, 1);
			GL11.glVertex3f(xPosition + width, yPosition, 1);
			GL11.glVertex3f(xPosition + width, yPosition + height, 1);
			GL11.glVertex3f(xPosition, yPosition + height, 1);
			GL11.glEnd();
			GL11.glPopMatrix();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
			int l = 14737632;

			if (packedFGColour != 0)
			{
				l = packedFGColour;
			}
			else if (!this.enabled)
			{
				l = 10526880;
			}
			else if (this.field_146123_n)
			{
				l = 16777120;
			}

			int yy = 0;
			String[] words = TextUtils.splitIntoLine(this.displayString, 35);
			for (String line : words)
				this.drawCenteredString(fontrenderer, line, this.xPosition + this.width / 2, this.yPosition + (yy += fontrenderer.FONT_HEIGHT) - 7, l);
		}
	}
}
