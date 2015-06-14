package com.parzi.starwarsmod.utils;

public class ElementUtils {
	public static int floraColor = 0x00AA00;
	public static int faunaColor = 0xD0B783;
	public static int terraColor = 0xAAAAAA;
	public static int aquaColor = 0x5555FF;

	public static int getColorFromElement(String name) {
		switch (name.toLowerCase()) {
		case "flora":
		case "plants":
			return floraColor;
		case "fauna":
		case "animals":
			return faunaColor;
		case "terra":
		case "earth":
			return terraColor;
		case "aqua":
		case "water":
			return aquaColor;
		}
		return 0;
	}
}
