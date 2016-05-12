package com.parzivail.util.ui;

import com.parzivail.pswm.StarWarsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.function.Consumer;

public class OutlineModelButtonFancy extends OutlineButton
{
	ModelBase model;
	Consumer preTransform;
	ResourceLocation texture;

	public OutlineModelButtonFancy(int id, String name, int x, int y, ModelBase model, ResourceLocation texture, Consumer<OutlineButton> preTransform)
	{
		super(id, x, y, 30, 30, name, false);
		this.model = model;
		this.preTransform = preTransform;
		this.texture = texture;
	}

	@Override
	public void drawButton(Minecraft mc, int mX, int mY)
	{
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glPushMatrix();
		if (this.visible)
		{
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

			GL11.glTranslatef(this.xPosition + (this.width / 2f), this.yPosition + this.height, 10);

			if (preTransform != null)
				preTransform.accept(this);

			if (this.texture != null)
				StarWarsMod.mc.renderEngine.bindTexture(texture);

			if (this.model != null)
				model.render(null, 0, 0, 0, 0, 0, 0);

			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_TEXTURE_2D);

			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
}
