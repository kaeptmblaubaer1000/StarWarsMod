package com.parzi.starwarsmod.registry;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.client.registry.ClientRegistry;

public class KeybindRegistry
{
	public static void registerAll()
	{
		StarWarsMod.keyShootVehicle = registerKeybind("shootVehicle", Keyboard.KEY_F);
		StarWarsMod.keySFoil = registerKeybind("toggleSFoil", Keyboard.KEY_C);
		StarWarsMod.keyRobeGui = registerKeybind("robeGui", Keyboard.KEY_V);
		if (StarWarsMod.IS_DEV_ENVIRONVENT)
			StarWarsMod.keyDebug = registerKeybind("debug", Keyboard.KEY_N);
	}

	public static KeyBinding registerKeybind(String keyName, int keyCode)
	{
		KeyBinding b = new KeyBinding("key." + StarWarsMod.MODID + "." + keyName, keyCode, "key." + StarWarsMod.MODID);
		ClientRegistry.registerKeyBinding(b);
		return b;
	}
}
