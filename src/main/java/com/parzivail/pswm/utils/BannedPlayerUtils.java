package com.parzivail.pswm.utils;

public class BannedPlayerUtils
{
	public static class BanEntry
	{
		public String name;
		public String reason;
		
		public BanEntry(String name, String reason)
		{
			this.name = name;
			this.reason = reason;
		}
	}
	
	public static BanEntry[] bans = {new BanEntry("Lukester2", "Lukester2 is banned from using the mod.")};
	
	public static boolean isPlayerBanned(String player)
	{
		for (BanEntry e : bans)
			if (e.name.equalsIgnoreCase(player))
				return true;
		return false;
	}
	
	public static String getBanReason(String player)
	{
		for (BanEntry e : bans)
			if (e.name.equalsIgnoreCase(player))
				return e.reason;
		return null;
	}
}
