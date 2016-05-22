package com.parzivail.pswm.rendering;

import com.parzivail.pswm.entities.EntityThrownSaber;
import com.parzivail.pswm.jedi.powers.PowerSaberThrow;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderThrownSaber extends Render
{
	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void func_76986_a(T entity, double d, double d1, double d2, float f,
	 * float f1). But JAD is pre 1.5 so doesn't do that.
	 */
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

			if (PowerSaberThrow.currentThrow != null)
				RenderLightsaber.instance.renderItem(IItemRenderer.ItemRenderType.ENTITY, PowerSaberThrow.currentThrow);
			GL11.glPopMatrix();
		}
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return null;
	}
}