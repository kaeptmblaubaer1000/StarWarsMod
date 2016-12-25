package com.parzivail.pswm.handler;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.entity.player.EntityPlayerMP;
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
