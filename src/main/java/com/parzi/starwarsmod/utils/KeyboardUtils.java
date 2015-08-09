package com.parzi.starwarsmod.utils;

import org.lwjgl.input.Keyboard;

public class KeyboardUtils
{
	public static boolean isControlDown()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_RCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_LCONTROL);
	}

	public static boolean isShiftDown()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
	}
}
