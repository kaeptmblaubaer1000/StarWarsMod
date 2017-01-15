package com.parzivail.pswm.registry;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.Resources;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

/**
 * Created by colby on 12/23/2016.
 */
public class KeybindRegistry
{
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyDebug;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyShipThrottleUp;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyShipThrottleDown;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyShipPitchDown;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyShipPitchUp;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyShipRollLeft;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyShipRollRight;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyShipBankLeft;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyShipBankRight;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyShipToggleSFoils;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyShipResetPitchRoll;

	public static void register()
	{
		if (Resources.IS_DEV_ENVIRONMENT)
		{
			KeybindRegistry.keyDebug = registerKeybind("debug", Keyboard.KEY_N);
		}

		KeybindRegistry.keyShipThrottleUp = registerKeybind("shipThrottleUp", Keyboard.KEY_R);
		KeybindRegistry.keyShipThrottleDown = registerKeybind("shipThrottleDown", Keyboard.KEY_F);
		KeybindRegistry.keyShipPitchDown = registerKeybind("shipPitchDown", Keyboard.KEY_S);
		KeybindRegistry.keyShipPitchUp = registerKeybind("shipPitchUp", Keyboard.KEY_W);
		KeybindRegistry.keyShipRollLeft = registerKeybind("shipRollLeft", Keyboard.KEY_A);
		KeybindRegistry.keyShipRollRight = registerKeybind("shipRollRight", Keyboard.KEY_D);
		KeybindRegistry.keyShipBankLeft = registerKeybind("shipBankLeft", Keyboard.KEY_Z);
		KeybindRegistry.keyShipBankRight = registerKeybind("shipBankRight", Keyboard.KEY_C);
		KeybindRegistry.keyShipToggleSFoils = registerKeybind("shipToggleSFoils", Keyboard.KEY_X);
		KeybindRegistry.keyShipResetPitchRoll = registerKeybind("shipResetPitchRoll", Keyboard.KEY_V);

		Lumberjack.log(PSWM.getNextRegisterMessage("KEYS"));
	}

	private static KeyBinding registerKeybind(String keyName, int keyCode)
	{
		KeyBinding b = new KeyBinding("key." + Resources.MODID + "." + keyName, keyCode, "key." + Resources.MODID);
		ClientRegistry.registerKeyBinding(b);
		return b;
	}
}
