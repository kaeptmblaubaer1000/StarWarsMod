package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ModelBlasterBolt;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.gltk.AttribMask;
import com.parzivail.util.ui.gltk.EnableCap;
import com.parzivail.util.ui.gltk.GL;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderBlasterBolt extends Render
{
	public static final ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/bolt.png");

	ModelBlasterBolt model;
	int color;

	float scale;

	public RenderBlasterBolt(int color)
	{
		this(color, 1.0f);
	}

	public RenderBlasterBolt(int color, float scale)
	{
		this.model = new ModelBlasterBolt();
		this.color = color;
		this.scale = scale;
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void func_76986_a(T entity, double d, double d1, double d2, float f,
	 * float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	@Override
	public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		GL11.glPushMatrix();
//		GL11.glDisable(GL11.GL_CULL_FACE);
//		GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
//		GL11.glEnable(GL11.GL_ALPHA_TEST);

		GL.Translate((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);

//		GL11.glRotatef(entity.rotationPitch, -MathHelper.cos((float)Math.toRadians(entity.rotationYaw)), 0, MathHelper.sin((float)Math.toRadians(entity.rotationYaw)));
//		GL11.glRotatef(entity.rotationYaw, 0, 1, 0);

		GL.PushAttrib(AttribMask.EnableBit);
		GL.PushAttrib(AttribMask.LineBit);
		GL.Disable(EnableCap.Lighting);
		GL.Disable(EnableCap.Texture2D);
		GL.Disable(EnableCap.Blend);
		Minecraft.getMinecraft().entityRenderer.disableLightmap(0);

		double dx = entity.motionX;
		double dz = entity.motionZ;
		double dy = entity.motionY;

		double d3 = MathHelper.sqrt_double(dx * dx + dz * dz);
		float yaw = (float)(Math.atan2(dz, dx) * 180.0D / Math.PI) - 90.0F;
		float pitch = (float)(-(Math.atan2(dy, d3) * 180.0D / Math.PI));

//		GL.Rotate(entity.rotationPitch, -MathHelper.cos((float)Math.toRadians(entity.rotationYaw)), 0, MathHelper.sin((float)Math.toRadians(entity.rotationYaw)));
//		GL.Rotate(90 - entity.rotationYaw, 0, 1, 0);
		GL.Rotate(90 - yaw, 0, 1, 0);
		GL.Rotate(pitch + 90, 0, 0, 1);

//		this.bindEntityTexture(entity);
		// GLPalette.glColorI(this.color);
//		GL11.glScalef(this.scale, this.scale, this.scale);
//		GL11.glTranslated(StarWarsMod.rngGeneral.nextGaussian() / 45, StarWarsMod.rngGeneral.nextGaussian() / 45, StarWarsMod.rngGeneral.nextGaussian() / 45);


//		ShaderHelper.setLightsaberColor(this.color);
//		ShaderHelper.useShader(ShaderHelper.glowSolid);
//		this.model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
//		ShaderHelper.releaseShader();

		GL.Scale(0.5);
		RenderLightsaber.renderBlade(0.5f, 0, 0xFF0000, GLPalette.WHITE, false);

//		GL11.glDisable(GL11.GL_ALPHA_TEST);
//		GL11.glEnable(GL11.GL_CULL_FACE);

//		GL11.glPopMatrix();
		GL.PopAttrib();
		GL.PopAttrib();
		GL.PopMatrix();
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return null;
	}
}