package com.parzivail.pswm.utils;

import com.parzivail.pswm.Resources;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;

/**
 * @author Colby
 */
public class StatTrack
{
	public static void addStat(String stat)
	{
		InputStream in = null;
		try
		{
			in = new URL(Resources.pswmStatLink + "?m=add&s=" + stat).openStream();
			switch (IOUtils.toString(in))
			{
				case "OK":
					break;
				default:
					break;
			}
			IOUtils.closeQuietly(in);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (in != null)
				IOUtils.closeQuietly(in);
		}
	}
}
