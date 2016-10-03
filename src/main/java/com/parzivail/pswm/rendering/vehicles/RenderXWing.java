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

			//GL11.glRotated(vehicle.shipMovementHandler.getRoll(), 0.0F, 0.0F, 1.0F);
			//GL11.glRotated(MathHelper.cos((float)vehicle.shipMovementHandler.getRollRad()) * vehicle.shipMovementHandler.getPitch(), 1.0F, 0.0F, 0.0F);
			//GL11.glRotated(MathHelper.sin((float)vehicle.shipMovementHandler.getRollRad()) * vehicle.shipMovementHandler.getPitch(), 0.0F, 1.0F, 0.0F);

			GL11.glTranslatef(0, 0.95f, 0);
		}
	}
}
