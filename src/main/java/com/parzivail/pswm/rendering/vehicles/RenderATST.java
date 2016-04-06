package com.parzivail.pswm.rendering.vehicles;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelATST;
import com.parzivail.pswm.vehicles.VehicATST;
import com.parzivail.util.MathUtils;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderATST extends RenderVehicBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/atst.png");

	public RenderATST(ModelATST modelATST, float par2)
	{
		super(modelATST, par2);
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
		GL11.glScalef(1.5f, 1.5f, 1.5f);
		GL11.glTranslatef(0, 0.01f, 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	@Override
	public ModelBase setRotations(ModelBase modelBase, EntityLivingBase entity, float partialTicks)
	{
		if (modelBase instanceof ModelATST && entity instanceof VehicATST)
		{
			VehicATST atst = (VehicATST)entity;
			ModelATST model = (ModelATST)modelBase;

			if (atst.riddenByEntity instanceof EntityLivingBase)
			{
				EntityLivingBase elb = (EntityLivingBase)atst.riddenByEntity;
				if (atst.getDistanceSq(atst.prevPosX, atst.prevPosY, atst.prevPosZ) > 0f)
				{
					model.MainLegLParent1.rotateAngleX = -0.08726646259971647F + MathHelper.sin((float)(atst.ticksExisted * (elb.moveForward >= 0 ? 1 : -1) / 3.75f)) / 5f;
					model.LegLChild1.rotateAngleX = -0.4886921905584123F + -MathHelper.sin((float)(atst.ticksExisted * (elb.moveForward >= 0 ? 1 : -1) / 3.75f) + 1) / 5f;

					model.MainLegRParent.rotateAngleX = -0.08726646259971647F + MathHelper.sin((float)(atst.ticksExisted * (elb.moveForward >= 0 ? 1 : -1) / 3.75f) + 3) / 5f;
					model.LegRChild1.rotateAngleX = -0.4886921905584123F + -MathHelper.sin((float)(atst.ticksExisted * (elb.moveForward >= 0 ? 1 : -1) / 3.75f) + 4) / 5f;

					model.BodyParentMain.rotationPointY = 3.0f + MathHelper.sin((float)(atst.ticksExisted / 1.9f) + 4) / 5f;
				}

				model.HeadParentMain.rotateAngleY = (float)Math.toRadians(MathUtils.lerp(atst.rotationHead - atst.rotationYaw, atst.rotationHead - atst.rotationYaw, partialTicks));
				model.HeadParentMain.rotateAngleX = (float)Math.toRadians(MathHelper.clamp_float(atst.riddenByEntity.rotationPitch, -20, 20));
			}

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