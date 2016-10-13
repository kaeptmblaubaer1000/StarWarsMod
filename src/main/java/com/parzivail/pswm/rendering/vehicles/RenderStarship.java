package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.util.driven.Pilotable;
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

	public void render(Pilotable pilotable, double d, double d1, double d2, float f, float f1)
	{
		bindEntityTexture(pilotable);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d, (float)d1, (float)d2);
		float dYaw = MathHelper.wrapAngleTo180_float(pilotable.axes.getYaw() - pilotable.prevRotationYaw);
		float dPitch = MathHelper.wrapAngleTo180_float(pilotable.axes.getPitch() - pilotable.prevRotationPitch);
		float dRoll = MathHelper.wrapAngleTo180_float(pilotable.axes.getRoll() - pilotable.prevRotationRoll);
		GL11.glRotatef(180F - pilotable.prevRotationYaw - dYaw * f1, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(pilotable.prevRotationPitch + dPitch * f1 + 180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-(pilotable.prevRotationRoll + dRoll * f1), 1.0F, 0.0F, 0.0F);

		GL11.glColor4f(1, 1, 1, 1);
		GL11.glScalef(3, 3, 3);
		if (model != null)
		{
			GL11.glRotatef(-90, 0, 1, 0);
			GL11.glTranslatef(0, -0.85f, 0);
			model.render(pilotable, (float)d, (float)d1, (float)d2, f, f1, 0.0625f);
		}

		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		render((Pilotable)entity, d, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return null;
	}
}