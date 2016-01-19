package com.parzivail.util.ui;

import org.lwjgl.input.Keyboard;

public class KeyboardUtils
{
	public static boolean isControlDown()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
	}

	public static boolean isShiftDown()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
	}
}