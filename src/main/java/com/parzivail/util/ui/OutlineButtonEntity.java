package com.parzivail.util.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import java.util.function.Consumer;

public class OutlineButtonEntity extends OutlineButton
{
	public boolean selected;
	public Entity entity;
	public Consumer<OutlineButton> preRender;
	public Consumer<OutlineButton> postRender;
	private boolean isSetup;

	public OutlineButtonEntity(int id, int x, int y, int width, int height)
	{
		super(id, x, y, width, height, "", false);
		this.isSetup = false;
	}

	public void setup(Entity entity, Consumer<OutlineButton> preRender, Consumer<OutlineButton> postRender)
	{
		this.entity = entity;
		this.preRender = preRender;
		this.postRender = postRender;
		this.isSetup = true;
	}

	@Override
	public void drawButton(Minecraft mc, int mX, int mY)
	{
		GL11.glPushMatrix();
		if (this.visible)
		{
			this.field_146123_n = mX >= this.xPosition && mY >= this.yPosition && mX < this.xPosition + this.width && mY < this.yPosition + this.height;
			this.mouseDragged(mc, mX, mY);

			int k = this.getHoverState(this.field_146123_n);
			this.mouseDragged(mc, mX, mY);

			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glLineWidth(3);
			switch (k)
			{
				case 0:
					GLPalette.glColorI(GLPalette.DARK_GREY);
					GFX.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, false);
					break;
				case 1:
					GLPalette.glColorI(this.selected ? GLPalette.SW_YELLOW : GLPalette.DARK_SW_YELLOW);
					GFX.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, false);
					break;
				case 2:
					GLPalette.glColorI(GLPalette.SW_YELLOW);
					GFX.drawRectangle(this.xPosition, this.yPosition, this.width, this.height, false);
					break;
				default:
					break;
			}
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_LIGHTING);
			net.minecraft.client.renderer.RenderHelper.enableStandardItemLighting();

			GLPalette.glColorI(GLPalette.WHITE);

			if (this.isSetup)
			{
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glTranslatef(this.xPosition, this.yPosition, 0);
				GL11.glPushMatrix();
				this.preRender.accept(this);
				RenderHelper.renderEntity(entity);
				this.postRender.accept(this);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
			}
			GL11.glDisable(GL11.GL_LIGHTING);
		}
		GL11.glPopMatrix();
	}
}
