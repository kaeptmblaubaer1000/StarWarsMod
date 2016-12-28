package com.parzivail.pswm.handler;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.dimension.DimensionInfo;
import com.parzivail.pswm.network.MessageTeleportPlayer;
import com.parzivail.pswm.registry.KeybindRegistry;
import net.minecraftforge.fml.common.gameevent.InputEvent;

/**
 * Created by colby on 12/23/2016.
 */
public class KeyHandler
{
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		if (KeybindRegistry.keyDebug.isPressed())
		{
			if (PSWM.mc.player.dimension == 0)
			{
				NetworkHandler.INSTANCE.sendToServer(new MessageTeleportPlayer(PSWM.proxy.getPlayer(), DimensionInfo.hothId));
			}
			else if (PSWM.mc.player.dimension != 0)
			{
				NetworkHandler.INSTANCE.sendToServer(new MessageTeleportPlayer(PSWM.proxy.getPlayer(), 0));
			}
		}
	}
}
