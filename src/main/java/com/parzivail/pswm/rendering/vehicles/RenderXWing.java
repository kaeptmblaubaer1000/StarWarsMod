package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelXWingNew;
import com.parzivail.util.vehicle.StarshipBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderXWing extends RenderVehicBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/xwingNew.png");

	public RenderXWing()
	{
		super(new ModelXWingNew(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f1)
	{
		//GL11.glScalef(3.0F, 3.0F, 3.0F);
		if (entity instanceof StarshipBase)
		{
			StarshipBase vehicle = (StarshipBase)entity;

			float dYaw = (vehicle.axes.getYaw() - vehicle.prevRotationYaw);
			float dPitch = (vehicle.axes.getPitch() - vehicle.prevRotationPitch);
			float dRoll = (vehicle.axes.getRoll() - vehicle.prevRotationRoll);
			GL11.glRotatef(180F - vehicle.prevRotationYaw - dYaw * f1, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(vehicle.prevRotationPitch + dPitch * f1, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(vehicle.prevRotationRoll + dRoll * f1, 1.0F, 0.0F, 0.0F);

			GL11.glTranslatef(0, 0.95f, 0);
		}
	}
}
