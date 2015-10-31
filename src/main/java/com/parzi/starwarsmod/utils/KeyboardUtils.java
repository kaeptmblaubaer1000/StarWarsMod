package com.parzi.starwarsmod.utils;

import org.lwjgl.input.Keyboard;

public class KeyboardUtils
{
	public static boolean isControlDown()
	{
		return Keyboard.isKeyDown(157) || Keyboard.isKeyDown(29);
	}

	public static boolean isShiftDown()
	{
		return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
	}
}