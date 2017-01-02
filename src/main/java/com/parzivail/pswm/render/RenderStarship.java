package com.parzivail.pswm.render;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.ui.GFX;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderStarship extends Render<Pilotable>
{
	private ResourceLocation tex;
	public ModelBase model;

	public RenderStarship(RenderManager manager, ModelBase model, ResourceLocation resourceLocation)
	{
		super(manager);
		this.model = model;
		this.tex = resourceLocation;
		shadowSize = 0.5F;
	}

	public void render(Pilotable pilotable, double d, double d1, double d2, float f, float f1)
	{
		bindEntityTexture(pilotable);
		GL11.glPushMatrix();
		GL11.glTranslated(d, d1, d2);
		float dYaw = MathHelper.wrapDegrees(pilotable.axes.getYaw() - pilotable.prevRotationYaw);
		float dPitch = MathHelper.wrapDegrees(pilotable.axes.getPitch() - pilotable.prevRotationPitch);
		float dRoll = MathHelper.wrapDegrees(pilotable.axes.getRoll() - pilotable.prevRotationRoll);
		GL11.glRotatef(180F - pilotable.prevRotationYaw - dYaw * f1, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(pilotable.prevRotationPitch + dPitch * f1 + 180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-(pilotable.prevRotationRoll + dRoll * f1), 1.0F, 0.0F, 0.0F);
		if (PSWM.mc.player.getRidingEntity() == pilotable)
			GFX.changeCameraRoll(-(pilotable.prevRotationRoll + dRoll * f1));

		if (PSWM.mc.player.getRidingEntity() != pilotable || PSWM.mc.gameSettings.thirdPersonView != 0)
		{
			GL11.glColor4f(1, 1, 1, 1);
			GL11.glScalef(3, 3, 3);
			if (model != null)
			{
				GL11.glRotatef(-90, 0, 1, 0);
				GL11.glTranslatef(0, -0.85f, 0);
				model.render(pilotable, (float)d, (float)d1, (float)d2, f, f1, 0.0625f);
			}
		}

		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Pilotable entity, double d, double d1, double d2, float f, float f1)
	{
		render(entity, d, d1, d2, f, f1);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(Pilotable entity)
	{
		return tex;
	}
}