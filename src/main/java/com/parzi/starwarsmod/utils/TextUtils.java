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

	public static String translateAurebesh(String english)
	{
		if (english.equalsIgnoreCase("T-65B X-Wing Starfighter"))
			return "LOOK OUT, REBEL SCUM!";
		if (english.equalsIgnoreCase("TIE/LN Starfighter"))
			return "LOOK AT MEEEEE VADER";
		if (english.equalsIgnoreCase("TIE/IN Interceptor"))
			return "I GOT POINTY WINGSSSSS";
		if (english.equalsIgnoreCase("RZ-1 A-Wing Interceptor"))
			return "THESE PILOTS ARE FISH!";
		if (english.equalsIgnoreCase("Wampa"))
			return "SWAMPYSWAMP";
		if (english.equalsIgnoreCase("Sandtrooper"))
			return "LOOK SIR, DROIDS!";
		if (english.equalsIgnoreCase("Protocol Droid"))
			return "JUST A BRITISH DUDE";
		if (english.equalsIgnoreCase("Astromech Droid"))
			return "Artoo Detoo, Whaddup?";
		if (english.equalsIgnoreCase("Jawa"))
			return "Utinni!";
		if (english.equalsIgnoreCase("Ewok"))
			return "Yub Yub!";
		if (english.equalsIgnoreCase("Tusken Raider"))
			return "ERGHHHHHHH";
		if (english.equalsIgnoreCase("Bantha"))
			return "Lil' Baby Banthy Banth";
		return english;
	}

	public static String translateAurebeshLong(String english)
	{
		//         "Lil' Baby Banthy BanthLil' Baby Banthy BanthLil' Baby"
		if (english.equalsIgnoreCase("T-65B X-Wing Starfighter"))
			return "BETTER THAN TIE FIGHTERS, ACTUALLY";
		if (english.equalsIgnoreCase("TIE/LN Starfighter"))
			return "AY BREH WHAT IT DO, I SEE YOU ROLLIN IN THAT LN";
		if (english.equalsIgnoreCase("TIE/IN Interceptor"))
			return "YOU AREN'T BETTER THAN US YOU POINTY WING IDIOT";
		if (english.equalsIgnoreCase("RZ-1 A-Wing Interceptor"))
			return "ALL YOU PILOTS LOOK LIKE DRIED ANCHOVIES";
		if (english.equalsIgnoreCase("Wampa"))
			return "THE ILLUSIVE SWAMPA";
		if (english.equalsIgnoreCase("Sandtrooper"))
			return "LOOK AT THESE IDIOTS WITH DIRTY ARMOR";
		if (english.equalsIgnoreCase("Protocol Droid"))
			return "IT'S NOT A LIFE FORM SO DON'T SHOOT IT";
		if (english.equalsIgnoreCase("Astromech Droid"))
			return "MY MOM HAS ONE JUST LIKE THAT, OH WAIT";
		if (english.equalsIgnoreCase("Jawa"))
			return "THEIR LITTLE GLOW EYES ARE SUS AS HECK";
		if (english.equalsIgnoreCase("Ewok"))
			return "WATCH OUT THEY'LL EAT US IF THEY CATCH US";
		if (english.equalsIgnoreCase("Tusken Raider"))
			return "LOOK AT THESE IDIOTS WITH THE MASKS";
		if (english.equalsIgnoreCase("Bantha"))
			return "Lil' Baby Banthy Banth";
		return english;
	}
}