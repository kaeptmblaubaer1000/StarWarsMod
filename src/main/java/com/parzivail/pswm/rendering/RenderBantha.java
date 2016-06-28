package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.mobs.ModelBanthaNew;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderBantha extends RenderCow
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/banthaNew.png");

	public RenderBantha(ModelBanthaNew par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
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
		else
			GL11.glScalef(1.8F, 1.8F, 1.8F);
	}
}
