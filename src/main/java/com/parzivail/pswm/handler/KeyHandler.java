package com.parzivail.pswm.handler;

import com.google.gson.Gson;
import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.registry.KeybindRegistry;
import com.parzivail.util.common.Lumberjack;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.driven.ShipInput;
import com.parzivail.util.lwjgl.Vector3f;
import com.parzivail.util.math.Animation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Keyboard;

/**
 * Created by colby on 12/23/2016.
 */
public class KeyHandler
{
	public static Controller joystick;
	public static Vector3f joystickValue;
	public static Vector3f prevJoystickValue;
	public static int currentJoystick = -1; // TODO: make this a config option
	public static float joystickThrottle;
	public static boolean joystickEnabled = false;

	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		if (KeybindRegistry.keyDebug1 != null && KeybindRegistry.keyDebug1.isPressed())
		{
			if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			{
				EventHandler.boom.getSnapshots().clear();
				PSWM.mc.player.sendMessage(new TextComponentString("Reset snapshots."));
			}
			else
			{
				EventHandler.boom.snapshotCamera(PSWM.mc.player);
				PSWM.mc.player.sendMessage(new TextComponentString("Added new snapshot. Total: " + EventHandler.boom.getSnapshots().size()));
			}
		}
		if (KeybindRegistry.keyDebug2 != null && KeybindRegistry.keyDebug2.isPressed())
		{
			if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			{
				Gson gson = new Gson();
				Lumberjack.debug(gson.toJson(EventHandler.boom.getSerializedSnapshots()));
			}
			else
			{
				EventHandler.boom.setLength(40 * EventHandler.boom.getSnapshots().size());

				if (EventHandler.boom.getTick() == 0)
				{
					PSWM.mc.player.sendMessage(new TextComponentString("Starting camera..."));
					EventHandler.boom.start();
				}
				else
				{
					PSWM.mc.player.sendMessage(new TextComponentString("Stopping camera..."));
					EventHandler.boom.stop();
				}
				EventHandler.boom.setOnAnimationEnd(Animation::reset);
			}
		}
		if (KeybindRegistry.keyShipToggleSFoils.isPressed() && PSWM.mc.player != null && PSWM.mc.player.getRidingEntity() instanceof Pilotable)
		{
			Pilotable ship = (Pilotable)PSWM.mc.player.getRidingEntity();
			if (ship != null && ship.isControlling(PSWM.mc.player))
				ship.acceptInput(ShipInput.SFoil);
		}
		if (KeybindRegistry.keyShipFire.isPressed())
		{
			Pilotable ship = (Pilotable)PSWM.mc.player.getRidingEntity();
			if (ship != null && ship.isControlling(PSWM.mc.player))
				ship.acceptInput(ShipInput.BlasterFire);
		}
		if (KeybindRegistry.keyToggleJoystick.isPressed())
		{
			joystickEnabled = !joystickEnabled;
			PSWM.mc.player.sendMessage(new TextComponentString(String.format("Joystick %s", joystickEnabled ? "enabled" : "disabled")));
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

				if ($(KeybindRegistry.keyShipResetPitchRoll))
					ship.acceptInput(ShipInput.ResetPitchRoll);

				if (joystickEnabled)
					ship.acceptJoystickInput();
			}
		}
	}

	private static boolean $(KeyBinding key)
	{
		return Keyboard.isKeyDown(key.getKeyCode());
	}

	public static void tickJoystick()
	{
		joystickValue = new Vector3f(joystick.getXAxisValue(), joystick.getYAxisValue(), -joystick.getRZAxisValue());
		if (joystick.getAxisCount() >= 4)
			joystickThrottle = joystick.getAxisValue(3);
	}
}
