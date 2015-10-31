package com.parzi.starwarsmod.utils;

public class TextUtils
{
	public static String addEffect(String p1, String effect)
	{
		return effect + p1 + Text.RESE;
	}

	public static String makeBold(String p1)
	{
		return Text.BOLD + p1 + Text.RESE;
	}

	public static String makeItalic(String p1)
	{
		return Text.ITAL + p1 + Text.RESE;
	}

	public static String makeObfuscated(String p1)
	{
		return Text.OBFU + p1 + Text.RESE;
	}

	public static String makeStrikethrough(String p1)
	{
		return Text.STRI + p1 + Text.RESE;
	}

	public static String makeUnderline(String p1)
	{
		return Text.UNDE + p1 + Text.RESE;
	}
}