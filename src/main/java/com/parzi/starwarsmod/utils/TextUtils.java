package com.parzi.starwarsmod.utils;

public class TextUtils
{

	public static String addEffect(String p1, String effect)
	{
		return effect + p1 + TextEffects.RESE;
	}

	public static String makeBold(String p1)
	{
		return TextEffects.BOLD + p1 + TextEffects.RESE;
	}

	public static String makeItalic(String p1)
	{
		return TextEffects.ITAL + p1 + TextEffects.RESE;
	}

	public static String makeObfuscated(String p1)
	{
		return TextEffects.OBFU + p1 + TextEffects.RESE;
	}

	public static String makeStrikethrough(String p1)
	{
		return TextEffects.STRI + p1 + TextEffects.RESE;
	}

	public static String makeUnderline(String p1)
	{
		return TextEffects.UNDE + p1 + TextEffects.RESE;
	}
}
