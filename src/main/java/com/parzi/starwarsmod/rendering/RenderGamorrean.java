package com.parzi.starwarsmod.rendering;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.mobs.ModelGamorrean;
import com.parzi.starwarsmod.rendering.models.mobs.ModelWampa;

public class RenderGamorrean extends RenderLiving
{
	public RenderGamorrean(ModelGamorrean par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(StarWarsMod.MODID, "textures/models/gamorrean.png");
	}
}
