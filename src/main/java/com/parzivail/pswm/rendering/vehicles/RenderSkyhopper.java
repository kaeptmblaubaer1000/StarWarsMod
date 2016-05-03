package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelSkyhopper;
import com.parzivail.pswm.vehicles.VehicSkyhopper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderSkyhopper extends RenderVehicBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/skyhopper.png");

	public RenderSkyhopper(ModelSkyhopper model, float par2)
	{
		super(model, par2);
	}

	@Override
	public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		super.preRenderCallback(entity, f);
		GL11.glScalef(0.6f, 0.6f, 0.6f);
		GL11.glTranslatef(0, 0.85f, 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	@Override
	public ModelBase setRotations(ModelBase modelBase, EntityLivingBase entity, float partialTicks)
	{
		if (modelBase instanceof ModelSkyhopper && entity instanceof VehicSkyhopper)
		{
			VehicSkyhopper skyhopper = (VehicSkyhopper)entity;
			ModelSkyhopper model = (ModelSkyhopper)modelBase;

			model.WingLParent.rotateAngleZ = -1.0122909661567112F - (1.5f * skyhopper.getWing());
			model.WingRParent.rotateAngleZ = 1.0122909661567112F + (1.5f * skyhopper.getWing());

			return model;
		}
		return modelBase;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\vehicles\RenderSpeederBike.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */