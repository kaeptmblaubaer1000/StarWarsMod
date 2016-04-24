import java.util.HashMap;

public class TextureMappingData
{
	private int BlockID;
	private String texture;
	private HashMap<Integer, Integer> metaIndex;
	private HashMap<Integer, String> metaNames;
	private String spawnCode;

	public String getTexture()
	{
		return this.texture;
	}

	public String getName(int meta)
	{
		if (this.metaNames.containsKey(Integer.valueOf(meta))) { return (String)this.metaNames.get(Integer.valueOf(meta)); }
		return getName();
	}

	public String getName()
	{
		if (this.metaNames.size() > 0) { return (String)this.metaNames.values().iterator().next(); }
		return "Unknown";
	}

	public String getSpawnCode()
	{
		return this.spawnCode;
	}

	public int getBlockID()
	{
		return this.BlockID;
	}

	public TextureMappingData(int BlockID, String texture, String spawnCode)
	{
		this.BlockID = BlockID;
		this.texture = texture;
		this.spawnCode = spawnCode;
		this.metaIndex = new HashMap();
		this.metaNames = new HashMap();
	}

	public TextureMappingData(int BlockID, String texture, int meta, int index, String name, String spawnCode)
	{
		this(BlockID, texture, spawnCode);
		this.metaIndex.put(Integer.valueOf(meta), Integer.valueOf(index));
		this.metaNames.put(Integer.valueOf(meta), name);
	}

	public int getIndexFromMetadata(int metadata)
	{
		if (this.metaIndex.containsKey(Integer.valueOf(metadata))) return ((Integer)this.metaIndex.get(Integer.valueOf(metadata))).intValue();
		if (this.metaIndex.containsKey(Integer.valueOf(0))) { return ((Integer)this.metaIndex.get(Integer.valueOf(0))).intValue(); }
		return -1;
	}

	public TextureMappingData AddMetaIndex(int metadata, int index)
	{
		if (!this.metaIndex.containsKey(Integer.valueOf(metadata)))
		{
			this.metaIndex.put(Integer.valueOf(metadata), Integer.valueOf(index));
		}
		return this;
	}

	public TextureMappingData AddMetaName(int metadata, String name)
	{
		if (!this.metaNames.containsKey(Integer.valueOf(metadata)))
		{
			this.metaNames.put(Integer.valueOf(metadata), name);
		}
		return this;
	}

	public TextureMappingData AddMetaIndexAndName(int metadata, int index, String name)
	{
		AddMetaIndex(metadata, index);
		AddMetaName(metadata, name);
		return this;
	}
}

/*
 * Location:
 * F:\Forge\schematicconverter\SchematicConverter.jar!\TextureMappingData.class
 * Java compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */