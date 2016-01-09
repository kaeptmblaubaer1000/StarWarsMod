package com.parzi.starwarsmod.rendering.force;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderJediDefense
{
	public static final ResourceLocation textureDefend = new ResourceLocation(Resources.MODID, "textures/force/defend.png");
	public static final ResourceLocation textureShieldSith = new ResourceLocation(Resources.MODID, "textures/force/shield_sith.png");
	public static final ResourceLocation textureShield = new ResourceLocation(Resources.MODID, "textures/force/shield.png");
	public static final ResourceLocation sphere = new ResourceLocation(Resources.MODID, "models/sphere.obj");

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
		{
			DataWatcher dw = ((EntityPlayer)entity).getDataWatcher();
			if (dw.getWatchableObjectString(StarWarsMod.activeDatawatcherId).equals("defend") && dw.getWatchableObjectInt(StarWarsMod.runningDatawatcherId) == 1)
				this.renderPlayerShield(event, (EntityPlayer)entity, false);

			if (dw.getWatchableObjectString(StarWarsMod.activeDatawatcherId).equals("deflect") && dw.getWatchableObjectInt(StarWarsMod.durationDatawatcherId) == 1)
				this.renderPlayerShield(event, (EntityPlayer)entity, true);
		}
	}

	private void renderPlayerShield(RenderWorldLastEvent event, EntityPlayer player, boolean deflect)
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
			Vec3 playerPosition = player.getPosition(event.partialTicks);
			Vec3 clientPosition = Minecraft.getMinecraft().thePlayer.getPosition(event.partialTicks);
			Minecraft.getMinecraft().renderEngine.bindTexture(deflect ? textureShield : textureDefend);
			if (!this.isClient(player))
			{
				GL11.glTranslated(0, player.height - 0.5, 0);
				GL11.glEnable(GL11.GL_CULL_FACE);
			}
			else if (Minecraft.getMinecraft().gameSettings.thirdPersonView > 0)
				GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glTranslated(playerPosition.xCoord - clientPosition.xCoord, playerPosition.yCoord - clientPosition.yCoord, playerPosition.zCoord - clientPosition.zCoord);
			GL11.glTranslated(0, -0.5, 0);
			GL11.glScalef(2.5f, 2.5f, 2.5f);
			GL11.glColor4f(1f, 1f, 1f, 1f);
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
