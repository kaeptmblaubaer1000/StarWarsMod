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
		new Thread(() ->
		{
			InputStream in = null;
			try
			{
				in = new URL(Resources.pswmStatLink + "?m=add&s=" + stat).openStream();
				String result = IOUtils.toString(in);
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
		}).start();
	}
}
