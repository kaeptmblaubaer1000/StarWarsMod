package com.parzivail.pswm.render.mob;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.mobs.ModelTaunNew;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTauntaun extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/tauntaun.png");

	public RenderTauntaun(RenderManager man)
	{
		super(man, new ModelTaunNew(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		if (entity.isChild())
			GL11.glScalef(0.8F, 0.8F, 0.8F);
		GL11.glRotatef(90, 0, 1, 0);
	}
}