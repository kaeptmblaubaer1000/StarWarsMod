package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelXWingNew;
import com.parzivail.util.driven.EntityPlane;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderXWing extends Render
{
	private ModelBase model;
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/xwingNew.png");

	public RenderXWing()
	{
		shadowSize = 0.5F;
		model = new ModelXWingNew();
	}

	public void render(EntityPlane entityPlane, double d, double d1, double d2, float f, float f1)
	{
		bindEntityTexture(entityPlane);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d, (float)d1, (float)d2);
		float dYaw = MathHelper.wrapAngleTo180_float(entityPlane.axes.getYaw() - entityPlane.prevRotationYaw);
		float dPitch = MathHelper.wrapAngleTo180_float(entityPlane.axes.getPitch() - entityPlane.prevRotationPitch);
		float dRoll = MathHelper.wrapAngleTo180_float(entityPlane.axes.getRoll() - entityPlane.prevRotationRoll);
		GL11.glRotatef(180F - entityPlane.prevRotationYaw - dYaw * f1, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(entityPlane.prevRotationPitch + dPitch * f1 + 180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(entityPlane.prevRotationRoll + dRoll * f1, 1.0F, 0.0F, 0.0F);

		GL11.glColor4f(1, 1, 1, 1);
		GL11.glScalef(3, 3, 3);
		if (model != null)
		{
			model.render(entityPlane, (float)d, (float)d1, (float)d2, f, f1, 0.0625f);
		}

		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		render((EntityPlane)entity, d, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}