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
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		//GL11.glScalef(3.0F, 3.0F, 3.0F);
		if (entity instanceof StarshipBase)
		{
			StarshipBase vehicle = (StarshipBase)entity;

			GL11.glRotated(vehicle.shipMovementHandler.rotation.zCoord, 0, 0, 1);
			GL11.glRotated(vehicle.shipMovementHandler.rotation.yCoord, 0, 1, 0);
			GL11.glRotated(vehicle.shipMovementHandler.rotation.xCoord, 1, 0, 0);

			GL11.glTranslatef(0, 0.95f, 0);
		}
	}
}
