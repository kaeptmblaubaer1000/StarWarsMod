package com.parzivail.util.ui;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.resources.Locale;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.MissingFormatArgumentException;

public class LangUtils
{
	private static Locale locale;
	private static Method translateMethod;

	static
	{
		LanguageManager manager = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), "mcLanguageManager", "field_135017_as", "as");
		locale = ReflectionHelper.getPrivateValue(LanguageManager.class, manager, "currentLocale", "field_135049_a", "field_135049_a");

		translateMethod = ReflectionHelper.findMethod(Locale.class, locale, new String[] { "translateKeyPrivate", "func_135026_c", "b" }, String.class);
		translateMethod.setAccessible(true);
	}

	/**
	 * Translates a string according to Minecraft I18n
	 *
	 * @param input The string to format
	 * @return The formatted string
	 */
	public static String translate(String input, Object... args)
	{
		String s = "";
		try
		{
			try
			{
				s = (String)translateMethod.invoke(locale, input);
				if (args == null || args.length == 0)
					return s;
				return String.format(s, args);
			}
			catch (IllegalAccessException | InvocationTargetException e)
			{
				e.printStackTrace();
			}
		}
		catch (MissingFormatArgumentException e)
		{
			Lumberjack.log("S: " + s);
			for (Object arg : args)
				Lumberjack.log("Arg: " + arg);
			e.printStackTrace();
		}
		return "ERR";
	}
}
