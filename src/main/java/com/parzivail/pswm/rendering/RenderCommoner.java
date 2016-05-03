package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.mobs.MobTatooineCommoner;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCommoner extends RenderBiped
{
	public static ResourceLocation weapon = new ResourceLocation(Resources.MODID, "textures/models/weaponsDealer.png");
	public static ResourceLocation merch = new ResourceLocation(Resources.MODID, "textures/models/generalMerchant.png");
	public static ResourceLocation corre = new ResourceLocation(Resources.MODID, "textures/models/corellian.png");
	public static ResourceLocation ship = new ResourceLocation(Resources.MODID, "textures/models/shipDealer.png");
	public static ResourceLocation bar = new ResourceLocation(Resources.MODID, "textures/models/bartender.png");
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