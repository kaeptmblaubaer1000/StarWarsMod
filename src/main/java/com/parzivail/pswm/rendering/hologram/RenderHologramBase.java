package com.parzivail.pswm.rendering.hologram;

import com.parzivail.util.ui.GLPalette;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderHologramBase extends RenderLiving
{
	ModelBase model;
	boolean doesSpin = false;

	public RenderHologramBase(ModelBase model, float par2, boolean doesSpin)
	{
		super(model, par2);
		this.model = model;
		this.doesSpin = doesSpin;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return null;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		this.mainModel = this.setRotations(this.model, entity, f);

		GLPalette.glColorI(GLPalette.AQUA_BLUE);

		if (this.doesSpin)
			GL11.glRotatef(System.currentTimeMillis() / 100 % 359, 0, 1, 0);
	}

	public ModelBase setRotations(ModelBase modelBase, EntityLivingBase entity, float partialTicks)
	{
		return modelBase;
	}
}
