package com.parzivail.pswm.utils;

import java.util.Base64;

public class BannedPlayerUtils
{
	public static class BanEntry
	{
		public String name;
		public String reason;

		public BanEntry(String name, String reason)
		{
			this.name = new String(Base64.getDecoder().decode(name));
			this.reason = new String(Base64.getDecoder().decode(reason));
		}
	}

	public static BanEntry[] bans = { new BanEntry("THVrZXN0ZXIy", "THVrZXN0ZXIyOiBXZSBrbm93IGEgbG90IGFib3V0IFN0YXIgV2Fycy4gVW5mb3J0dW5hdGVseSBmb3IgeW91LCB3ZSBrbm93IGp1c3QgYXMgbXVjaCBhYm91dCBKYXZhLCBtb2RkaW5nLCBhbmQgc2VjdXJpdHkuIENoZWVycyE=") };

	public static String getBanReason(String player)
	{
		for (BanEntry e : bans)
			if (e.name.equalsIgnoreCase(player))
				return e.reason;
		return null;
	}

	public static boolean isPlayerBanned(String player)
	{
		for (BanEntry e : bans)
			if (e.name.equalsIgnoreCase(player))
				return true;
		return false;
	}
}
