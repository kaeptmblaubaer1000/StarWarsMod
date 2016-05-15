package com.parzivail.util.ui;

import com.parzivail.pswm.StarWarsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.function.Consumer;

public class OutlineButtonModel extends OutlineButton
{
	public boolean selected;
	public ModelBase model;
	public Consumer<OutlineButton> preRender;
	public Consumer<OutlineButton> postRender;
	public ResourceLocation texture;
	private boolean isSetup;

	public OutlineButtonModel(int id, int x, int y, int width, int height)
	{
		super(id, x, y, width, height, "", false);
		this.isSetup = false;
	}

	public void setup(ModelBase model, ResourceLocation texture, Consumer<OutlineButton> preRender, Consumer<OutlineButton> postRender)
	{
		this.model = model;
		this.texture = texture;
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

			GLPalette.glColorI(GLPalette.WHITE);

			if (this.isSetup)
			{
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				StarWarsMod.mc.renderEngine.bindTexture(texture);
				GL11.glTranslatef(this.xPosition, this.yPosition, 0);
				GL11.glPushMatrix();
				this.preRender.accept(this);
				this.model.render(null, 0, 0, 0, 0, 0, 0.625f);
				this.postRender.accept(this);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
			}
		}
		GL11.glPopMatrix();
	}
}
