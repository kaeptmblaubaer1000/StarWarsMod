package com.parzi.starwarsmod.rendering;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.mobs.MobJawa;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderJawa extends RenderLiving
{
	public static ResourceLocation texture1 = new ResourceLocation(Resources.MODID, "textures/models/jawa.png");
	public static ResourceLocation texture2 = new ResourceLocation(Resources.MODID, "textures/models/jawa2.png");
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/jawa.png");

	public RenderJawa(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if (entity instanceof MobJawa)
		{
			MobJawa commoner = (MobJawa)entity;
			switch (commoner.getDataWatcher().getWatchableObjectInt(25))
			{
				case 0:
					return texture1;
				case 1:
					return texture2;
			}
		}
		return texture;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderJawa.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */