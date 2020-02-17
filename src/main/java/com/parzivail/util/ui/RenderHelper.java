package com.parzivail.util.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class RenderHelper
{
	private Minecraft mc;

	/**
	 * Initiates a new RenderHelper class
	 *
	 * @param mc The minecraft to wrap
	 */
	public RenderHelper(Minecraft mc)
	{
		this.mc = mc;
	}

	public static void disableLightmap()
	{
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}

	public static void enableLightmap()
	{
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}

	public static void renderEntity(Entity el)
	{
		renderEntity(el, 1);
	}

	public static void renderEntity(Entity el, float partialTicks)
	{
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
		Render render = getEntityClassRenderObject(el.getClass());
		render.doRender(el, 0.0D, 0.0D, 0.0D, 0.0F, partialTicks);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}

	@SuppressWarnings("unchecked")
	private static Render getEntityClassRenderObject(Class<? extends Entity> par1Class)
	{
		Render render = (Render)RenderManager.instance.entityRenderMap.get(par1Class);
		if (render == null && par1Class != Entity.class)
		{
			render = getEntityClassRenderObject((Class<? extends Entity>)par1Class.getSuperclass());
		}

		return render;
	}

	/**
	 * Gets the camera mode
	 *
	 * @return Returns true if the camera is in 1st person mode
	 */
	public boolean isFirstPerson()
	{
		return this.mc.gameSettings.thirdPersonView == 0;
	}

	/**
	 * Sets the camera mode
	 */
	public void setCameraMode(int mode)
	{
		this.mc.gameSettings.thirdPersonView = mode;
	}
}