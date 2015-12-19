package com.parzi.starwarsmod.rendering;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobTatooineCommoner;

public class RenderCommoner extends RenderBiped
{
	public static ResourceLocation weapon = new ResourceLocation(StarWarsMod.MODID, "textures/models/weaponsDealer.png");
	public static ResourceLocation merch = new ResourceLocation(StarWarsMod.MODID, "textures/models/generalMerchant.png");
	public static ResourceLocation corre = new ResourceLocation(StarWarsMod.MODID, "textures/models/corellian.png");
	public static ResourceLocation ship = new ResourceLocation(StarWarsMod.MODID, "textures/models/shipDealer.png");
	public static ResourceLocation bar = new ResourceLocation(StarWarsMod.MODID, "textures/models/bartender.png");
	public static ResourceLocation texture = new ResourceLocation("textures/entity/steve.png");

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
					return weapon;
				case 1:
					return merch;
				case 2:
					return corre;
				case 3:
					return bar;
				case 4:
					return ship;
			}
		}
		return texture;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderCommoner.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */