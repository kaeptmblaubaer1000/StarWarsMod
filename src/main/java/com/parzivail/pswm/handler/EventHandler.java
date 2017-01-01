package com.parzivail.pswm.handler;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.common.Lumberjack;
import com.parzivail.util.driven.EntityCamera;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.ui.GFX;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
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

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRenderGui(RenderGameOverlayEvent.Pre event)
	{
		if (PSWM.camera != null && PSWM.cameraPosition != null && PSWM.cameraRotation != null)
		{
			EntityCamera.loadAnglesFromStored();
			if (PSWM.camera.isEntityAlive())
				PSWM.mc.setRenderViewEntity(PSWM.camera);
		}

		if (PSWM.mc.player.getRidingEntity() instanceof Pilotable)
		{
			Pilotable ship = (Pilotable)PSWM.mc.player.getRidingEntity();
			PSWM.mc.setRenderViewEntity(ship.getCamera() != null ? ship.getCamera() : PSWM.mc.player);

			if (PSWM.mc.gameSettings.thirdPersonView == 2)
				PSWM.mc.gameSettings.thirdPersonView = 0;
		}
		else
		{
			GFX.changeCameraRoll(0);
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
