package com.parzivail.pswm.registry;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import com.parzivail.pswm.Resources;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class KeybindRegistry
{
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyShootVehicle;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keySFoil;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyDebug;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyRobeGui;
	@SideOnly(Side.CLIENT)
	public static KeyBinding keyRobePower;

	public static void registerAll()
	{
		KeybindRegistry.keyShootVehicle = registerKeybind("shootVehicle", Keyboard.KEY_F);
		KeybindRegistry.keySFoil = registerKeybind("toggleSFoil", Keyboard.KEY_C);
		KeybindRegistry.keyRobeGui = registerKeybind("robeGui", Keyboard.KEY_V);
		KeybindRegistry.keyRobePower = registerKeybind("robePower", Keyboard.KEY_B);
		if (Resources.IS_DEV_ENVIRONVENT)
			KeybindRegistry.keyDebug = registerKeybind("debug", Keyboard.KEY_N);
	}

	public static KeyBinding registerKeybind(String keyName, int keyCode)
	{
		KeyBinding b = new KeyBinding("key." + Resources.MODID + "." + keyName, keyCode, "key." + Resources.MODID);
		ClientRegistry.registerKeyBinding(b);
		return b;
	}
}
