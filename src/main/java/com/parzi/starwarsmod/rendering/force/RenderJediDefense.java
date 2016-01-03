package com.parzi.starwarsmod.rendering.force;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.GlPalette;

public class RenderJediDefense
{
	public static final ResourceLocation texture = new ResourceLocation(StarWarsMod.MODID, "textures/force/shield.png");
	public static final ResourceLocation sphere = new ResourceLocation(StarWarsMod.MODID, "models/sphere.obj");

	IModelCustom model;

	public RenderJediDefense()
	{
		this.model = AdvancedModelLoader.loadModel(sphere);
	}

	private boolean isClient(EntityPlayer player)
	{
		return player == Minecraft.getMinecraft().thePlayer;
	}

	public void onWorldRender(RenderWorldLastEvent event)
	{
		for (Object entity : Minecraft.getMinecraft().theWorld.playerEntities)
			this.renderPlayerShield(event, (EntityPlayer)entity);
	}

	private void renderPlayerShield(RenderWorldLastEvent event, EntityPlayer player)
	{
		boolean isVisible = true;

		if (isVisible)
		{
			Minecraft.getMinecraft().theWorld.getWorldTime();

			GL11.glPushMatrix();
			GL11.glDepthMask(false);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			Vec3 playerPosition = player.getPosition(event.partialTicks);
			Vec3 clientPosition = Minecraft.getMinecraft().thePlayer.getPosition(event.partialTicks);
			GlPalette.glColorI(GlPalette.MEDIUM_BLUE);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			if (!this.isClient(player))
			{
				GL11.glTranslated(0, player.height - 0.5, 0);
				GL11.glEnable(GL11.GL_CULL_FACE);
			}
			else if (Minecraft.getMinecraft().gameSettings.thirdPersonView > 0)
				GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glTranslated(playerPosition.xCoord - clientPosition.xCoord, playerPosition.yCoord - clientPosition.yCoord, playerPosition.zCoord - clientPosition.zCoord);
			GL11.glTranslated(0, -0.5, 0);
			GL11.glScaled(3, 3, 3);
			GL11.glRotated(player.ticksExisted % 360, -1, 0, 0);
			GL11.glRotated(player.ticksExisted % 360, 0, 0, 1);
			this.model.renderAll();

			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glDepthMask(true);
			GL11.glPopMatrix();
		}
	}
}
