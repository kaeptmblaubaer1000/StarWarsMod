package com.parzivail.pswm.rendering.force;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.jedi.JediUtils;
import com.parzivail.util.ui.Lumberjack;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

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
			if (JediUtils.getActive((EntityPlayer)entity).equals("defend") && JediUtils.getIsRunning((EntityPlayer)entity))
			{
				this.renderPlayerShield(event, (EntityPlayer)entity, false);
				Lumberjack.log(entity);
			}

			if (JediUtils.getActive((EntityPlayer)entity).equals("deflect") && JediUtils.getUsingDuration((EntityPlayer)entity))
				this.renderPlayerShield(event, (EntityPlayer)entity, true);
		}
	}

	private void renderPlayerShield(RenderWorldLastEvent event, EntityPlayer player, boolean deflect)
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
