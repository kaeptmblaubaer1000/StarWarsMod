import java.io.File;
import javax.swing.filechooser.FileFilter;

public class SchematicFilter extends FileFilter
{
	public boolean accept(File f)
	{
		if (f.isDirectory()) { return true; }

		String extension = Utils.getExtension(f);
		if (extension != null) { return extension.equals("schematic"); }

		return false;
	}

	public String getDescription()
	{
		return ".schematic files (*.schematic)";
	}
}

/*
 * Location:
 * F:\Forge\schematicconverter\SchematicConverter.jar!\SchematicFilter.class
 * Java compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */