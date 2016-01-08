package com.parzi.starwarsmod.rendering;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.rendering.models.ModelDSTurret;
import com.parzi.starwarsmod.weaponry.WeaponDSTurret;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderDSTurret extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/dsTurret.png");

	public RenderDSTurret(ModelDSTurret par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		WeaponDSTurret turret = (WeaponDSTurret)p_76986_1_;
		turret.setPositionAndRotation(turret.posX, turret.posY, turret.posZ, turret.rotationYaw, turret.pitch);
		super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		GL11.glScalef(4.0F, 4.0F, 4.0F);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderDSTurret.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */