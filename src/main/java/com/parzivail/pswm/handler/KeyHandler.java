package com.parzivail.pswm.handler;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.registry.KeybindRegistry;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.driven.PilotableSFoils;
import com.parzivail.util.driven.ShipInput;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

/**
 * Created by colby on 12/23/2016.
 */
public class KeyHandler
{
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		if (KeybindRegistry.keyDebug != null && KeybindRegistry.keyDebug.isPressed())
		{
			if (PSWM.mc.player.getRidingEntity() instanceof PilotableSFoils)
			{
				PilotableSFoils pilotableSFoils = (PilotableSFoils)PSWM.mc.player.getRidingEntity();
				pilotableSFoils.getDataManager().set(PilotableSFoils.S_FOILS_OPEN, !pilotableSFoils.getDataManager().get(PilotableSFoils.S_FOILS_OPEN));
			}
		}
	}

	public static void handleVehicleMovement()
	{
		if (PSWM.mc.player != null && PSWM.mc.player.getRidingEntity() instanceof Pilotable)
		{
			Pilotable ship = (Pilotable)PSWM.mc.player.getRidingEntity();
			if (ship != null && ship.isControlling(PSWM.mc.player))
			{
				if ($(PSWM.mc.gameSettings.keyBindLeft))
					ship.acceptInput(ShipInput.Left);

				if ($(PSWM.mc.gameSettings.keyBindRight))
					ship.acceptInput(ShipInput.Right);

				if ($(PSWM.mc.gameSettings.keyBindForward))
					ship.acceptInput(ShipInput.Up);

				if ($(PSWM.mc.gameSettings.keyBindBack))
					ship.acceptInput(ShipInput.Down);

				if ($(PSWM.mc.gameSettings.keyBindJump))
					ship.acceptInput(ShipInput.ThrottleUp);

				if ($(PSWM.mc.gameSettings.keyBindSprint))
					ship.acceptInput(ShipInput.ThrottleDown);
			}
		}
	}

	private static boolean $(KeyBinding key)
	{
		return Keyboard.isKeyDown(key.getKeyCode());
	}
}
