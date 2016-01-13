package com.parzi.util.ui;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.parzi.util.ui.GuiToast.ToastPosition;

public class Lumberjack
{
	public static final Logger logger = LogManager.getLogger("StarWarsMod");

	public static void debug(String message)
	{
		log(Level.DEBUG, message);
	}

	public static void info(String message)
	{
		log(Level.INFO, message);
	}

	public static void log(Level level, String message)
	{
		logger.log(level, message);
	}

	public static void log(Object message)
	{
		info(String.valueOf(message));
	}

	public static void warn(String message)
	{
		log(Level.WARN, message);
	}
}