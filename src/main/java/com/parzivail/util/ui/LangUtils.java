package com.parzivail.util.ui;

import net.minecraft.client.resources.I18n;

public class LangUtils
{
	/**
	 * Translates a string according to Minecraft I18n
	 *
	 * @param input The string to format
	 * @return The formatted string
	 */
	public static String translate(String input)
	{
		return I18n.format(input, new Object[0]);
	}
}
