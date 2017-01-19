package com.parzivail.pswm.render.misc;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.Resources;
import com.parzivail.pswm.entity.EntityBlasterBoltBase;
import com.parzivail.pswm.models.misc.ModelBlasterBolt;
import com.parzivail.util.ui.ShaderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

/**
 * Created by colby on 1/19/2017.
 */
public class RenderBlasterBolt extends Render<EntityBlasterBoltBase>
{
	public static final ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/bolt.png");

	ModelBlasterBolt model;
	int color;

	float scale;

	public RenderBlasterBolt(RenderManager man, int color)
	{
		this(man, color, 1.0f);
	}

	public RenderBlasterBolt(RenderManager man, int color, float scale)
	{
		super(man);
		this.model = new ModelBlasterBolt();
		this.color = color;
		this.scale = scale;
	}

	@Override
	public void doRender(EntityBlasterBoltBase entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
		GL11.glPushAttrib(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glRotatef(entity.rotationPitch, -MathHelper.cos((float)Math.toRadians(entity.rotationYaw)), 0, MathHelper.sin((float)Math.toRadians(entity.rotationYaw)));
		GL11.glRotatef(entity.rotationYaw, 0, 1, 0);
		this.bindEntityTexture(entity);
		// GLPalette.glColorI(this.color);
		GL11.glScalef(this.scale, this.scale, this.scale);
		GL11.glTranslated(PSWM.rngGeneral.nextGaussian() / 45, PSWM.rngGeneral.nextGaussian() / 45, PSWM.rngGeneral.nextGaussian() / 45);

		ShaderHelper.setTransparentColor(this.color);
		ShaderHelper.useShader(ShaderHelper.glowSolid);
		this.model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		ShaderHelper.releaseShader();

		GL11.glPopAttrib();
		GL11.glPopAttrib();

		GL11.glPopMatrix();
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(EntityBlasterBoltBase entity)
	{
		return texture;
	}
}
