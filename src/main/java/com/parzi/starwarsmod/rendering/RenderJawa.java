package com.parzi.starwarsmod.rendering;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobJawa;

public class RenderJawa extends RenderLiving
{
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
					return new ResourceLocation(StarWarsMod.MODID, "textures/models/jawa.png");
				case 1:
					return new ResourceLocation(StarWarsMod.MODID, "textures/models/jawa2.png");
			}
		}
		return new ResourceLocation(StarWarsMod.MODID, "textures/models/jawa.png");
	}
}
