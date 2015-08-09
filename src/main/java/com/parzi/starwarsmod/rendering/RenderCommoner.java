package com.parzi.starwarsmod.rendering;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobTatooineCommoner;

public class RenderCommoner extends RenderBiped
{
	public RenderCommoner(ModelBiped par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if (entity instanceof MobTatooineCommoner)
		{
			MobTatooineCommoner commoner = (MobTatooineCommoner)entity;

			switch (commoner.getDataWatcher().getWatchableObjectInt(25))
			{
				case 0:
					return new ResourceLocation(StarWarsMod.MODID, "textures/models/weaponsDealer.png");
				case 1:
					return new ResourceLocation(StarWarsMod.MODID, "textures/models/generalMerchant.png");
				case 2:
					return new ResourceLocation(StarWarsMod.MODID, "textures/models/corellian.png");
			}
		}
		// fallback
		return new ResourceLocation("textures/entity/steve.png");
	}
}
