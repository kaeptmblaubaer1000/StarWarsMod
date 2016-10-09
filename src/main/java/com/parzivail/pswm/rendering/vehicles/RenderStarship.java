package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.util.driven.Starship;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderStarship extends Render
{
	public ModelBase model;

	public RenderStarship()
	{
		shadowSize = 0.5F;
	}

	public void render(Starship starship, double d, double d1, double d2, float f, float f1)
	{
		bindEntityTexture(starship);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d, (float)d1, (float)d2);
		float dYaw = MathHelper.wrapAngleTo180_float(starship.axes.getYaw() - starship.prevRotationYaw);
		float dPitch = MathHelper.wrapAngleTo180_float(starship.axes.getPitch() - starship.prevRotationPitch);
		float dRoll = MathHelper.wrapAngleTo180_float(starship.axes.getRoll() - starship.prevRotationRoll);
		GL11.glRotatef(180F - starship.prevRotationYaw - dYaw * f1, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(starship.prevRotationPitch + dPitch * f1 + 180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-(starship.prevRotationRoll + dRoll * f1), 1.0F, 0.0F, 0.0F);

		GL11.glColor4f(1, 1, 1, 1);
		GL11.glScalef(3, 3, 3);
		if (model != null)
		{
			GL11.glRotatef(-90, 0, 1, 0);
			GL11.glTranslatef(starship.getRenderOffset().x / 16f, starship.getRenderOffset().y / 16f, starship.getRenderOffset().z / 16f);
			model.render(starship, (float)d, (float)d1, (float)d2, f, f1, 0.0625f);
		}

		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		render((Starship)entity, d, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return null;
	}
}