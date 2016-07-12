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
	public static String translate(String input, Object... args)
	{
		//Lumberjack.log("input: " + input);
		//Lumberjack.log("args: " + args.length);
		//Lumberjack.log("trans: " + I18n.format(input).replaceAll("\\{\\d+\\}", "%s"));
		return I18n.format(input, args).replace("Format error: ", "");
	}
}
