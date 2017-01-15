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
		if (KeybindRegistry.keyShipToggleSFoils.isPressed())
		{
			if (PSWM.mc.player != null && PSWM.mc.player.getRidingEntity() instanceof Pilotable)
			{
				Pilotable ship = (Pilotable)PSWM.mc.player.getRidingEntity();
				if (ship != null && ship.isControlling(PSWM.mc.player))
				{
					ship.acceptInput(ShipInput.SFoil);
				}
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
				if ($(KeybindRegistry.keyShipRollLeft))
					ship.acceptInput(ShipInput.RollLeft);

				if ($(KeybindRegistry.keyShipRollRight))
					ship.acceptInput(ShipInput.RollRight);

				if ($(KeybindRegistry.keyShipPitchDown))
					ship.acceptInput(ShipInput.PitchDown);

				if ($(KeybindRegistry.keyShipPitchUp))
					ship.acceptInput(ShipInput.PitchUp);

				if ($(KeybindRegistry.keyShipThrottleUp))
					ship.acceptInput(ShipInput.ThrottleUp);

				if ($(KeybindRegistry.keyShipThrottleDown))
					ship.acceptInput(ShipInput.ThrottleDown);

				if ($(KeybindRegistry.keyShipBankLeft))
					ship.acceptInput(ShipInput.BankLeft);

				if ($(KeybindRegistry.keyShipBankRight))
					ship.acceptInput(ShipInput.BankRight);
			}
		}
	}

	private static boolean $(KeyBinding key)
	{
		return Keyboard.isKeyDown(key.getKeyCode());
	}
}
