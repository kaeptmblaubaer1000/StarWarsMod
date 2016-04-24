import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Logging
{
	private static final String logFile = "SchematicToJava";
	private static final String logFileExtension = ".log";
	private static String curLogFile = "";

	public static final Logging instance = new Logging();
	public static final int SEVERE = 0;
	public static final int INFO = 1;
	public static final int FINE = 2;
	public static final int FINER = 3;
	public static final int FINEST = 4;
	private static int maxLogLevel = 4;

	private Logging()
	{
		try
		{
			CreateLogFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error initializing log file - ensure you have write access to the current directory.");
		}
	}

	public void SetLogLevel(int logLevel)
	{
		if (logLevel > 2) logLevel = 2;
		if (logLevel < 0) logLevel = 0;
		maxLogLevel = logLevel;
	}

	public boolean log(String message, int severity)
	{
		if (severity > maxLogLevel) { return false; }
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		message = formatter.format(new Date()) + " [" + severityToString(severity) + "]: " + message + "\r\n";

		System.out.print(message);

		File file = new File(curLogFile);
		if ((!file.exists()) || (!file.canWrite())) return false;
		try
		{
			FileOutputStream fos = new FileOutputStream(file, true);
			byte[] buffer = message.getBytes();
			fos.write(buffer);
			fos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean info(String message)
	{
		return log(message, 1);
	}

	public boolean fine(String message)
	{
		return log(message, 2);
	}

	public boolean finer(String message)
	{
		return log(message, 3);
	}

	public boolean finest(String message)
	{
		return log(message, 4);
	}

	public boolean severe(String message)
	{
		return log(message, 0);
	}

	public boolean exception(Exception e)
	{
		boolean success = true;
		StackTraceElement[] arrayOfStackTraceElement;
		int j = (arrayOfStackTraceElement = e.getStackTrace()).length;
		for (int i = 0; i < j; i++)
		{
			StackTraceElement ste = arrayOfStackTraceElement[i];
			success &= severe(ste.toString());
		}
		return success;
	}

	private String severityToString(int severity)
	{
		switch (severity)
		{
			case 2:
				return "FINE";
			case 3:
				return "FINER";
			case 4:
				return "FINEST";
			case 0:
				return "SEVERE";
		}
		return "INFO";
	}

	private boolean CreateLogFile() throws IOException
	{
		File dirPath = new File("./Logs/");
		dirPath.mkdirs();
		File file = new File("./Logs/SchematicToJava.log");
		int count = 0;
		while (file.exists())
		{
			file = new File("./Logs/SchematicToJava_" + count++ + ".log");
		}
		curLogFile = file.getAbsolutePath();
		return file.createNewFile();
	}
}

/*
 * Location: F:\Forge\schematicconverter\SchematicConverter.jar!\Logging.class
 * Java compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */