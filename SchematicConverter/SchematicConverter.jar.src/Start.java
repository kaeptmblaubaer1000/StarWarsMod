import java.io.IOException;
import java.io.InputStream;

public class Start
{
	public static void main(String[] args) throws IOException
	{
		UI ui = new UI(640, 620);
		ui.Show();
	}

	public static String readInput(int maxLen)
	{
		byte[] buffer = new byte[maxLen];
		try
		{
			System.in.skip(System.in.available());
			System.in.read(buffer);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return "";
		}
		return new String(buffer);
	}
}

/*
 * Location: F:\Forge\schematicconverter\SchematicConverter.jar!\Start.class
 * Java compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */