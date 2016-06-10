package com.parzivail.pswm.rendering;

import com.parzivail.pswm.entities.EntityThrownSaber;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderThrownSaber extends Render
{
	@Override
	public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float pt)
	{
		if (entity instanceof EntityThrownSaber)
		{
			EntityThrownSaber saber = (EntityThrownSaber)entity;

			GL11.glPushMatrix();
			GL11.glTranslated(x, y, z);

			GL11.glRotatef(90, 1, 0, 0);
			GL11.glRotatef(90, 0, 1, 0);
			GL11.glRotatef((entity.ticksExisted + pt) * 40, 1, 0, 0);

			GL11.glTranslatef(0, -2, 0);

			if (saber.getSaberStack() != null)
				RenderLightsaber.instance.renderItem(IItemRenderer.ItemRenderType.ENTITY, saber.getSaberStack());

			GL11.glPopMatrix();
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return null;
	}
}