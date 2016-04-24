import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

public class BlockResources
{
	public BufferedImage unknownBlock;
	public BufferedImage ignoredBlock;
	private String unknownBlockPath = "Images/UnknownBlock.png";
	private String ignoredBlockPath = "Images/IgnoredBlock.png";
	private HashMap<Integer, TextureMappingData> textureToIndexMappings;
	private HashMap<String, BufferedImage> textureResources;
	public static final BlockResources instance = new BlockResources();
	public static List<BlockType> blocks;

	public void Init()
	{
		this.unknownBlock = LoadResource(this.unknownBlockPath);
		this.ignoredBlock = LoadResource(this.ignoredBlockPath);
		initTextureMappings();
		blocks = BlockUtils.loadBlocks();
	}

	public void initTextureMappings()
	{
		this.textureToIndexMappings = new HashMap();
		this.textureResources = new HashMap();
		String fileLine = "";
		String textureFile = "";

		int blockID = 0;
		int meta = 0;
		int index = 0;
		String name = "";
		String spawnCode = "";
		boolean currentTextureLoaded = false;

		File texMap = new File("./Config/textureMappings.ini");
		if ((!texMap.exists()) || (!texMap.canRead()))
		{
			Logging.instance.severe("Texture mappings file not found, or is not readable!");
			return;
		}

		FileReader fr = null;
		BufferedReader br = null;
		try
		{
			fr = new FileReader(texMap);
			br = new BufferedReader(fr);
		}
		catch (FileNotFoundException e)
		{
			Logging.instance.exception(e);
			e.printStackTrace();
			return;
		}
		try
		{
			do

			{
				if ((!fileLine.startsWith("#")) && (fileLine != "\r\n") && (fileLine != "") && (fileLine != " "))

				{
					if ((fileLine.startsWith("[")) && (fileLine.endsWith("]")))
					{
						textureFile = fileLine.substring(1, fileLine.length() - 1);
						if (!this.textureResources.containsKey(textureFile))
						{
							BufferedImage resource = LoadResource(textureFile);
							if (resource == null)
							{
								currentTextureLoaded = false;
								Logging.instance.severe("Loading of texture file \"" + textureFile + "\" failed - skipping items in this section!");
							}
							else
							{
								this.textureResources.put(textureFile, resource);
								currentTextureLoaded = true;
							}
						}
						else
						{
							Logging.instance.fine("Texture resource \"" + textureFile + "\" already loaded.");
							currentTextureLoaded = true;
						}
					}
					else if (currentTextureLoaded)

					{

						String[] sections = fileLine.split(",");
						if ((sections.length != 4) && (sections.length != 5))
						{
							Logging.instance.fine("Improper format of sections - skipping line: " + fileLine + " (this may result in unmapped block textures)");
						}
						else
						{
							blockID = Integer.parseInt(sections[0]);
							meta = Integer.parseInt(sections[1]);
							index = Integer.parseInt(sections[2]);
							name = sections[3];
							spawnCode = sections.length == 5 ? sections[4] : null;

							if (!this.textureToIndexMappings.containsKey(Integer.valueOf(blockID)))
							{
								this.textureToIndexMappings.put(Integer.valueOf(blockID), new TextureMappingData(blockID, textureFile, meta, index, name, spawnCode));
							}
							else
							{
								TextureMappingData tmd = (TextureMappingData)this.textureToIndexMappings.get(Integer.valueOf(blockID));
								tmd.AddMetaIndexAndName(meta, index, name);
							}
						}
					}
				}
			}
			while ((fileLine = br.readLine()) != null);

			br.close();
			fr.close();
		}
		catch (Exception e)
		{
			Logging.instance.exception(e);
		}
	}

	private BufferedImage LoadResource(String path)
	{
		File file = new File(path);
		if (!file.exists())
		{
			Logging.instance.severe("Resource not found: " + file.getAbsolutePath());
			return null;
		}
		try
		{
			return ImageIO.read(file);
		}
		catch (IOException e)
		{
			Logging.instance.exception(e);
		}
		return null;
	}

	public TextureIndexData getTextureAndIndex(int blockID, int metadata)

	{
		if (this.textureToIndexMappings.containsKey(Integer.valueOf(blockID)))
		{
			TextureMappingData tmd = (TextureMappingData)this.textureToIndexMappings.get(Integer.valueOf(blockID));
			if (this.textureResources.containsKey(tmd.getTexture())) { return new TextureIndexData((BufferedImage)this.textureResources.get(tmd.getTexture()), tmd.getIndexFromMetadata(metadata), tmd.getName(metadata)); }
			if (BlockUtils.findBlock(blockID, metadata) != BlockUtils.generateUnknown(blockID, metadata)) {
				BlockType ret = BlockUtils.findBlock(blockID, 0);
				return new TextureIndexData(this.unknownBlock, 0, ret.displayName);
			}
			return new TextureIndexData(this.unknownBlock, 0, "Unknown");
		}
		if (BlockUtils.findBlock(blockID, metadata) != BlockUtils.generateUnknown(blockID, metadata)) {
			BlockType ret = BlockUtils.findBlock(blockID, 0);
			return new TextureIndexData(this.unknownBlock, 0, ret.displayName);
		}
		return new TextureIndexData(this.unknownBlock, 0, "Unknown");
	}

	public TextureMappingData getTextureMappingData(int blockID)
	{
		BlockType block = BlockUtils.findBlock(blockID);
		if (block.internalName == "Unknown") Logging.instance.info("Found unknown block: Passed ID: " + blockID);
		return new TextureMappingData(block.id, "", block.metadata, 0, block.displayName, "Blocks." + block.internalName);
	}

	public TextureMappingData[] getAllTextureMappingData()
	{
		TextureMappingData[] arr = new TextureMappingData[this.textureToIndexMappings.size()];

		Iterator<TextureMappingData> it = this.textureToIndexMappings.values().iterator();
		int count = 0;
		while (it.hasNext())
		{
			TextureMappingData tmd = (TextureMappingData)it.next();
			arr[(count++)] = tmd;
		}
		return arr;
	}

}

/*
 * Location:
 * F:\Forge\schematicconverter\SchematicConverter.jar!\BlockResources.class Java
 * compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */