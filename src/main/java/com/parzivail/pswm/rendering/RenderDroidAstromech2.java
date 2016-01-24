package com.parzivail.pswm.rendering;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.mobs.MobDroidAstromechImperial2;

public class RenderDroidAstromech2 extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/astromech2.png");
	public static ResourceLocation textureImperial = new ResourceLocation(Resources.MODID, "textures/models/astromechImperial2.png");

	public RenderDroidAstromech2(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if (entity instanceof MobDroidAstromechImperial2)
			return textureImperial;
		return texture;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderDroidAstromech2.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */