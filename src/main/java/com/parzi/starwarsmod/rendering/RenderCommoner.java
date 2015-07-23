package com.parzi.starwarsmod.rendering;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobTusken;

public class RenderCommoner extends RenderBiped
{
	public RenderCommoner(ModelBiped par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(StarWarsMod.MODID, "textures/models/villager.png");
	}
}
