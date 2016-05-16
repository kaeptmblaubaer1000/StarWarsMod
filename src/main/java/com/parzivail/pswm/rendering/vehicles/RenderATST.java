package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelATST;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderATST extends RenderVehicBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/atst.png");

	public RenderATST()
	{
		super(new ModelATST(), 0.5f);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		super.preRenderCallback(entity, f);
		GL11.glScalef(1.5f, 1.5f, 1.5f);
		GL11.glTranslatef(0, 0.01f, 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
