package com.parzivail.util.ui;

import org.lwjgl.input.Keyboard;

public class KeyboardUtils
{
	/**
	 * Gets whether or not a Control key is down
	 *
	 * @return
	 */
	public static boolean isControlDown()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
	}

	/**
	 * Gets whether or not a Shift key is down
	 *
	 * @return
	 */
	public static boolean isShiftDown()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
	}
}