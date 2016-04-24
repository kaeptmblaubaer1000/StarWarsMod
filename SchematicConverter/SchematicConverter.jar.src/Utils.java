import java.io.File;

public class Utils
{
	public static final String jpeg = "jpeg";
	public static final String jpg = "jpg";
	public static final String gif = "gif";
	public static final String tiff = "tiff";
	public static final String tif = "tif";
	public static final String png = "png";
	public static final String schematic = "schematic";

	public static String getExtension(File f)
	{
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if ((i > 0) && (i < s.length() - 1))
		{
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}
}

/*
 * Location: F:\Forge\schematicconverter\SchematicConverter.jar!\Utils.class
 * Java compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */