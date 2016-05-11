package com.parzivail.pswm.rendering;

import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.OutlineButton;
import com.parzivail.util.ui.Screen2D;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;

public class OutlineLightsaberHiltButton extends OutlineButton
{
	IHandlesRender body;
	RenderLightsaber s = new RenderLightsaber();

	public OutlineLightsaberHiltButton(int id, String name, int x, int y, IHandlesRender renderer)
	{
		super(id, x, y, 30, 30, name, false);
		this.body = renderer;
	}

	@Override
	public void drawButton(Minecraft mc, int mX, int mY)
	{
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glPushMatrix();
		if (this.visible)
		{
			FontRenderer fontrenderer = mc.fontRenderer;
			/* hover */
			this.field_146123_n = mX >= this.xPosition && mY >= this.yPosition && mX < this.xPosition + this.width && mY < this.yPosition + this.height;
			int k = this.getHoverState(this.field_146123_n);
			this.mouseDragged(mc, mX, mY);

			switch (k)
			{
				case 0:
					GLPalette.glColorI(GLPalette.DARK_GREY);
					Screen2D.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, false);
					break;
				case 1:
					GLPalette.glColorI(this.selected ? GLPalette.SW_YELLOW : GLPalette.DARK_SW_YELLOW);
					Screen2D.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, false);
					break;
				case 2:
					GLPalette.glColorI(GLPalette.SW_YELLOW);
					Screen2D.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, false);
					break;
				default:
					break;
			}

			GLPalette.glColorI(GLPalette.WHITE);

			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_LIGHTING);
			RenderHelper.enableStandardItemLighting();

			if (body != null)
			{
				GL11.glTranslatef(this.xPosition + (this.width / 2f), this.yPosition + this.height, 10);
				GL11.glRotatef((System.currentTimeMillis() / 15) % 360, 0, 1, 0);
				GL11.glScalef(20, -20, 20);
				RenderLightsaber.applyTransformFix(this.displayString);
				s.renderHiltItem(body, false);
			}

			GL11.glDisable(GL11.GL_LIGHTING);

			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}
}
