package com.parzivail.pswm.handler;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.dimension.DimensionInfo;
import com.parzivail.util.camera.Boom;
import com.parzivail.util.common.Lumberjack;
import com.parzivail.util.driven.EntityCamera;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.driven.PilotableLand;
import com.parzivail.util.math.AnimationManager;
import com.parzivail.util.ui.GFX;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by colby on 12/23/2016.
 */
public class EventHandler
{
	@SideOnly(Side.CLIENT)
	public static KeyHandler keyHandler;
	private static final HashMap<EntityPlayerMP, Integer> queuedDestinations = new HashMap<>();

	public static Boom boom = new Boom(PSWM.mc, 100);

	public static void queuePlayerDestination(EntityPlayerMP player, int destination)
	{
		queuedDestinations.put(player, destination);
		Lumberjack.debug("Queued player %s to go to %s next tick.", player, destination);
	}


	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load loadEvent)
	{
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		keyHandler.onKeyInput(event);
	}

	@SubscribeEvent(receiveCanceled = true)
	@SideOnly(Side.CLIENT)
	public void onRenderPlayerPre(RenderPlayerEvent.Pre event)
	{
		if (event.getEntityPlayer().getRidingEntity() instanceof PilotableLand)
		{
			PSWM.mc.setRenderViewEntity(PSWM.mc.player);
			PSWM.mc.getRenderManager().renderViewEntity = PSWM.mc.player;
		}
	}

	@SubscribeEvent(receiveCanceled = true)
	@SideOnly(Side.CLIENT)
	public void onRenderPlayerPost(RenderPlayerEvent.Post event)
	{
		if (PSWM.mc.player.getRidingEntity() instanceof Pilotable)
		{
			if (PSWM.mc.gameSettings.thirdPersonView == 2)
				PSWM.mc.gameSettings.thirdPersonView = 0;

			Pilotable ship = (Pilotable)PSWM.mc.player.getRidingEntity();
			GFX.changeRenderEntity(ship.getCamera() != null && PSWM.mc.gameSettings.thirdPersonView != 0 ? ship.getCamera() : PSWM.mc.player);
		}
		else
		{
			GFX.changeCameraRoll(0);
			if (PSWM.camera != null && PSWM.cameraPosition != null && PSWM.cameraRotation != null)
			{
				EntityCamera.loadAnglesFromStored();
				if (PSWM.camera.isEntityAlive())
					GFX.changeRenderEntity(PSWM.camera);
			}
			else
				GFX.changeRenderEntity(PSWM.mc.player);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onWorldDraw(RenderWorldLastEvent event)
	{
		//		if (!(PSWM.mc.player.getRidingEntity() instanceof Pilotable))
		//		{
		//			GL11.glLineWidth(4);
		//			GL11.glPushMatrix();
		//			GL11.glTranslated(-PSWM.mc.player.posX, -PSWM.mc.player.posY, -PSWM.mc.player.posZ);
		//			GL11.glDisable(GL11.GL_CULL_FACE);
		//			//GL11.glRotatef(-PSWM.mc.player.renderYawOffset, 0, 1, 0);
		//			//GL11.glTranslatef(-0.3f, 1.4f, -0.13f);
		//			GL11.glDisable(GL11.GL_BLEND);
		//			GL11.glEnable(GL11.GL_LIGHTING);
		//			GL11.glLight(GL11.GL_LIGHT7, GL11.GL_AMBIENT, RenderHelper.setColorBuffer(0.3f, 0.3f, 0.3f, 0));
		//			GL11.glLight(GL11.GL_LIGHT7, GL11.GL_DIFFUSE, RenderHelper.setColorBuffer(0.4f, 0.4f, 0.4f, 0));
		//			GL11.glLight(GL11.GL_LIGHT7, GL11.GL_POSITION, RenderHelper.setColorBuffer(0f, -4f, 4f, 0));
		//			GL11.glEnable(GL11.GL_LIGHT7);
		//			GL11.glDisable(GL11.GL_TEXTURE_2D); // fix for dimming bug!
		//			//cloth.drawShaded();
		//			rope.drawShaded();
		//			GL11.glEnable(GL11.GL_TEXTURE_2D); // end of fix
		//			GL11.glDisable(GL11.GL_LIGHTING);
		//			GL11.glDisable(GL11.GL_LIGHT7);
		//			GL11.glEnable(GL11.GL_CULL_FACE);
		//			GL11.glPopMatrix();
		//		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRenderGui(RenderGameOverlayEvent.Pre event)
	{
		ShipGuiHandler.drawGui(PSWM.mc.gameSettings.thirdPersonView == 0, event);

		AnimationManager.render(event);
	}

	@SubscribeEvent(receiveCanceled = true)
	@SideOnly(Side.CLIENT)
	public void onFogDensityQuery(EntityViewRenderEvent.FogDensity event)
	{
		if (PSWM.mc.player.dimension == DimensionInfo.dagobahId)
		{
			event.setDensity(0.1f);
			event.setCanceled(true);
		}
		else if (PSWM.mc.player.dimension == DimensionInfo.ilumId)
		{
			event.setDensity(0.05f);
			event.setCanceled(true);
		}
		else if (PSWM.mc.player.dimension == DimensionInfo.hothId)
		{
			event.setDensity(0.02f);
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onFogColorQuery(EntityViewRenderEvent.FogColors event)
	{
		if (PSWM.mc.player.dimension == DimensionInfo.dagobahId)
		{
			float n = 0.4f;
			event.setRed(n);
			event.setGreen(n + 0.02f);
			event.setBlue(n + 0.05f);
		}
		else if (PSWM.mc.player.dimension == DimensionInfo.ilumId)
		{
			float n = 0.5f;
			event.setRed(n);
			event.setGreen(n);
			event.setBlue(n);
		}
		else if (PSWM.mc.player.dimension == DimensionInfo.hothId)
		{
			float n = 0.9f;
			event.setRed(n);
			event.setGreen(n);
			event.setBlue(n);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onCameraSetup(EntityViewRenderEvent.CameraSetup event)
	{
		event.setRoll(GFX.cameraRoll);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onClientTick(TickEvent.ClientTickEvent event)
	{
		if (PSWM.mc == null || PSWM.mc.player == null)
			return;

		if (event.phase == TickEvent.Phase.START)
			AnimationManager.tick();

		//		cloth.addForce(GRAVITY);
		//		float move = (float)Math.abs((PSWM.mc.player.posX - PSWM.mc.player.prevPosX) * (PSWM.mc.player.posZ - PSWM.mc.player.prevPosZ));
		//		cloth.addWindForce(new Vector3f(0, -25 * (PSWM.mc.player.posY - PSWM.mc.player.prevPosY), -100 * move));
		//		cloth.checkCollision();
		//		cloth.timeStep();

		//		rope.particles[rope.particles.length - 1].setPos(new Vector3f(PSWM.mc.player.posX, PSWM.mc.player.posY + 1, PSWM.mc.player.posZ));
		//		rope.addForce(new Vector3f(0, -1, 0));
		//		rope.checkCollision(PSWM.mc.world);
		//		rope.timeStep();
	}

	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event)
	{
		if (queuedDestinations.size() > 0)
		{
			Iterator<Map.Entry<EntityPlayerMP, Integer>> iterator = queuedDestinations.entrySet().iterator();
			while (iterator.hasNext())
			{
				Map.Entry<EntityPlayerMP, Integer> entry = iterator.next();
				PSWM.proxy.teleport(entry.getKey(), entry.getValue());
				iterator.remove();
			}
		}
		WorldServer world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(DimensionInfo.ilumId);
		if (world != null)
		{
			world.setRainStrength(1);
			world.setThunderStrength(1);
		}
		world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(DimensionInfo.dagobahId);
		if (world != null)
		{
			world.setRainStrength(1);
			world.setThunderStrength(1);
		}
		world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(DimensionInfo.hothId);
		if (world != null)
		{
			world.setRainStrength(1);
		}
	}
}
