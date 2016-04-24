public class BlockBase
{
	private int x;
	private int y;
	private int z;
	private int typeid;
	private int meta;
	private boolean ignored;

	public BlockBase(int x, int y, int z, int typeid, int meta)
	{
		SetX(x);
		SetY(y);
		SetZ(z);
		SetTypeID(typeid);
		SetMeta(meta);
	}

	public int GetX()
	{
		return this.x;
	}

	public int GetY()
	{
		return this.y;
	}

	public int GetZ()
	{
		return this.z;
	}

	public int GetMeta()
	{
		return this.meta;
	}

	public int GetTypeID()
	{
		return this.typeid;
	}

	public void SetX(int x)
	{
		this.x = x;
	}

	public void SetY(int y)
	{
		this.y = y;
	}

	public void SetZ(int z)
	{
		this.z = z;
	}

	public void SetMeta(int meta)
	{
		this.meta = meta;
	}

	public void SetTypeID(int typeid)
	{
		this.typeid = typeid;
	}

	public void setIgnored(boolean ignore)
	{
		this.ignored = ignore;
	}

	public boolean isIgnored()
	{
		return this.ignored;
	}

	public String getCreateFunctionCall(boolean notify)
	{
		TextureMappingData tmd = BlockResources.instance.getTextureMappingData(GetTypeID());

		if (GetMeta() == 0)
		{
			if (notify) { return "\t\tthis.setBlock(world, i + " + GetX() + ", j + " + GetY() + ", k + " + GetZ() + ", " + ((tmd == null) || (tmd.getSpawnCode() == null) || (tmd.getSpawnCode() == "") ? Integer.valueOf(GetTypeID()) : new StringBuilder(String.valueOf(tmd.getSpawnCode())).toString()) + ", 0);\r\n"; }
			return "\t\tthis.setBlock(world, i + " + GetX() + ", j + " + GetY() + ", k + " + GetZ() + ", " + ((tmd == null) || (tmd.getSpawnCode() == null) || (tmd.getSpawnCode() == "") ? Integer.valueOf(GetTypeID()) : new StringBuilder(String.valueOf(tmd.getSpawnCode())).toString()) + ", 0);\r\n";
		}

		if (notify) { return "\t\tworld.setBlockMetadataWithNotify(i + " + GetX() + ", j + " + GetY() + ", k + " + GetZ() + ", " + GetMeta() + ", 2);\r\n"; }
		return "\t\tthis.setBlock(world, i + " + GetX() + ", j + " + GetY() + ", k + " + GetZ() + ", " + ((tmd == null) || (tmd.getSpawnCode() == null) || (tmd.getSpawnCode() == "") ? new String("Blocks.air") : new StringBuilder(String.valueOf(tmd.getSpawnCode())).toString()) + ", " + GetMeta() + ");\r\n";
	}

	public String getMetaDataFunctionCall()
	{
		if (GetMeta() != 0) { return "\t\tworld.setBlockMetadataWithNotify(i + " + GetX() + ", j + " + GetY() + ", k + " + GetZ() + ", " + GetMeta() + ", 2);\r\n"; }
		return "";
	}
}

/*
 * Location: F:\Forge\schematicconverter\SchematicConverter.jar!\BlockBase.class
 * Java compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */