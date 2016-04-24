import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jnbt.ByteArrayTag;
import org.jnbt.CompoundTag;
import org.jnbt.NBTInputStream;
import org.jnbt.ShortTag;
import org.jnbt.StringTag;
import org.jnbt.Tag;

public class NBTRead
{
	private NBTInputStream inputStream;
	Map<String, Tag> tags;
	public short width;
	public short length;
	public short height;

	private void Init(String filePath)
	{
		this.tags = new HashMap();
		File file = new File(filePath);
		if (!file.exists())
		{
			this.inputStream = null;
			return;
		}
		try
		{
			FileInputStream is = new FileInputStream(file);
			this.inputStream = new NBTInputStream(is);
		}
		catch (IOException ioex)
		{
			ioex.printStackTrace();
		}
	}

	private void CleanUp()
	{
		if (this.inputStream != null)
		{
			try
			{
				this.inputStream.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	private <T> T getChildTag(Map<String, Tag> schematic, String name, Class<T> outputClass)
	{
		if (schematic.containsKey(name)) { return (T)schematic.get(name); }
		try
		{
			return (T)outputClass.newInstance();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public BlockBase[] ReadSchematic(String schematicFile) throws IOException
	{
		Init(schematicFile);

		CompoundTag schematicTag = (CompoundTag)this.inputStream.readTag();
		if (!schematicTag.getName().equals("Schematic")) { throw new IllegalArgumentException("Tag \"Schematic\" does not exist or is not first"); }

		Map<String, Tag> schematic = schematicTag.getValue();
		if (!schematic.containsKey("Blocks")) { throw new IllegalArgumentException("Schematic file is missing a \"Blocks\" tag"); }

		this.width = ((ShortTag)getChildTag(schematic, "Width", ShortTag.class)).getValue().shortValue();
		this.length = ((ShortTag)getChildTag(schematic, "Length", ShortTag.class)).getValue().shortValue();
		this.height = ((ShortTag)getChildTag(schematic, "Height", ShortTag.class)).getValue().shortValue();

		String materials = ((StringTag)getChildTag(schematic, "Materials", StringTag.class)).getValue();
		if (!materials.equals("Alpha")) { throw new IllegalArgumentException("Schematic file is not an Alpha schematic"); }

		byte[] blocks = ((ByteArrayTag)getChildTag(schematic, "Blocks", ByteArrayTag.class)).getValue();
		byte[] blockData = ((ByteArrayTag)getChildTag(schematic, "Data", ByteArrayTag.class)).getValue();

		BlockBase[] blockList = new BlockBase[this.width * this.length * this.height];
		int blockIndex = 0;
		for (int x = 0; x < this.width; x++)
		{
			for (int y = 0; y < this.height; y++)
			{
				for (int z = 0; z < this.length; z++)
				{
					int index = y * this.width * this.length + z * this.width + x;
					BlockBase bb = new BlockBase(x, y, z, blocks[index], blockData[index]);
					blockList[(blockIndex++)] = bb;
				}
			}
		}

		CleanUp();

		return blockList;
	}
}

/*
 * Location: F:\Forge\schematicconverter\SchematicConverter.jar!\NBTRead.class
 * Java compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */