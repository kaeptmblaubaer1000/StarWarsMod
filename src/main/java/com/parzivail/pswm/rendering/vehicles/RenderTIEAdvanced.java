package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelTIEAdvanced;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTIEAdvanced extends RenderVehicBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/tieAdvanced.png");

	public RenderTIEAdvanced(ModelTIEAdvanced model, float par2)
	{
		super(model, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\vehicles\RenderSpeederBike.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */