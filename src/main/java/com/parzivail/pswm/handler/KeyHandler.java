package com.parzivail.pswm.handler;

import com.parzivail.pswm.registry.KeybindRegistry;
import net.minecraftforge.fml.common.gameevent.InputEvent;

/**
 * Created by colby on 12/23/2016.
 */
public class KeyHandler
{
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		if (KeybindRegistry.keyDebug != null && KeybindRegistry.keyDebug.isPressed())
		{
		}
	}
}
