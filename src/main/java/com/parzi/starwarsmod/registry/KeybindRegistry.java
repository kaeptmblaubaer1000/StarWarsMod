package com.parzi.starwarsmod.registry;

import org.lwjgl.input.Keyboard;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeybindRegistry
{
	public static void registerAll()
	{
		StarWarsMod.keyShootVehicle = registerKeybind("shootVehicle", Keyboard.KEY_F);
	}

	public static KeyBinding registerKeybind(String keyName, int keyCode)
	{
		KeyBinding b = new KeyBinding("key." + StarWarsMod.MODID + "." + keyName, keyCode, "key." + StarWarsMod.MODID);
		ClientRegistry.registerKeyBinding(b);
		return b;
	}
}
