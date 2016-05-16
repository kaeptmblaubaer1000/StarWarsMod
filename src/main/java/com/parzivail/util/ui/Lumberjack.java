package com.parzivail.util.ui;

import com.parzivail.pswm.Resources;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lumberjack
{
	public static final Logger logger = LogManager.getLogger("PSWM");

	/**
	 * Prints a message to log only in Debug mode
	 *
	 * @param message The message to print
	 */
	public static void debug(Object message)
	{
		if (Resources.IS_DEV_ENVIRONVENT)
			log(message);
	}

	/**
	 * Prints a message to log only
	 *
	 * @param message The message to print
	 */
	public static void info(String message)
	{
		log(Level.INFO, message);
	}

	private static void log(Level level, String message)
	{
		logger.log(level, message);
	}

	/**
	 * Prints a message to log only
	 *
	 * @param message The message to print
	 */
	public static void log(Object message)
	{
		info(String.valueOf(message));
	}

	/**
	 * Prints a message to log only
	 *
	 * @param message The message to print
	 */
	public static void warn(String message)
	{
		log(Level.WARN, message);
	}
}