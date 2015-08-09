package com.parzi.starwarsmod.utils;

public class ElementUtils
{
	public static int floraColor = 0x00AA00;
	public static int faunaColor = 0xD0B783;
	public static int terraColor = 0xAAAAAA;
	public static int aquaColor = 0x5555FF;

	public static int getColorFromElement(String name)
	{
		String low = name.toLowerCase();
		if (low == "flora" || low == "plants") { return floraColor; }
		if (low == "fauna" || low == "animals") { return faunaColor; }
		if (low == "terra" || low == "earth") { return terraColor; }
		if (low == "aqua" || low == "water") { return aquaColor; }
		return 0;
	}
}
