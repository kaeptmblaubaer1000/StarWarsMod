package com.parzivail.pswm.handler;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.dimension.DimensionInfo;
import com.parzivail.util.common.Lumberjack;
import com.parzivail.util.driven.EntityCamera;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.ui.GFX;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
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
	private static final KeyHandler keyHandler = new KeyHandler();
	private static final HashMap<EntityPlayerMP, Integer> queuedDestinations = new HashMap<>();

	public static void queuePlayerDestination(EntityPlayerMP player, int destination)
	{
		queuedDestinations.put(player, destination);
		Lumberjack.debug("Queued player %s to go to %s next tick.", player, destination);
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
		PSWM.mc.setRenderViewEntity(PSWM.mc.player);
		PSWM.mc.getRenderManager().renderViewEntity = PSWM.mc.player;
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
	public void onRenderGui(RenderGameOverlayEvent.Pre event)
	{
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onFogDensityQuery(EntityViewRenderEvent.FogDensity event)
	{
		if (PSWM.mc.player.dimension == DimensionInfo.dagobahId)
		{
			event.setDensity(0.1f);
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void onFogColorQuery(EntityViewRenderEvent.FogColors event)
	{
		if (PSWM.mc.player.dimension == DimensionInfo.dagobahId)
		{
			float n = 0.4f;
			event.setRed(n);
			event.setGreen(n + 0.02f);
			event.setBlue(n + 0.05f);
		}
	}

	@SubscribeEvent
	public void onCameraSetup(EntityViewRenderEvent.CameraSetup event)
	{
		event.setRoll(GFX.cameraRoll);
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
	}
}
