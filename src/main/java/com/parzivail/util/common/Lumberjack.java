package com.parzivail.util.common;

import com.parzivail.pswm.Resources;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by colby on 12/18/2016.
 */
public class Lumberjack
{
	public static final Logger logger = LogManager.getLogger("PSWM");

	/**
	 * Prints a message to log only in Debug mode
	 *
	 * @param message The message to print
	 */
	public static void debug(Object message, Object... params)
	{
		if (Resources.IS_DEV_ENVIRONMENT)
			log(message, params);
	}

	/**
	 * Prints a message to log
	 *
	 * @param message The message to print
	 */
	public static void info(Object message)
	{
		log(Level.INFO, String.valueOf(message));
	}

	private static void log(Level level, String message)
	{
		logger.log(level, message);
	}

	/**
	 * Prints a message to log
	 *
	 * @param message The message to print
	 */
	public static void log(Object message)
	{
		info(String.valueOf(message));
	}

	/**
	 * Prints a message to log
	 *
	 * @param message The message to print
	 */
	public static void log(Object message, Object... params)
	{
		info(String.format(String.valueOf(message), params));
	}

	/**
	 * Prints a message to log only
	 *
	 * @param message The message to print
	 */
	public static void warn(Object message)
	{
		log(Level.WARN, String.valueOf(message));
	}

	/**
	 * Prints a message to log only
	 *
	 * @param message The message to print
	 */
	public static void err(Object message)
	{
		log(Level.ERROR, String.valueOf(message));
	}

	/**
	 * Prints a message to log only
	 *
	 * @param message The message to print
	 */
	public static void trace(Object message)
	{
		log(Level.TRACE, String.valueOf(message));
	}
}