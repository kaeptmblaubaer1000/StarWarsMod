package com.parzi.starwarsmod.rendering;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;

public class RenderDroidTreadwell extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(StarWarsMod.MODID, "textures/models/treadwell.png");
	
	public RenderDroidTreadwell(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderDroidTreadwell.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */