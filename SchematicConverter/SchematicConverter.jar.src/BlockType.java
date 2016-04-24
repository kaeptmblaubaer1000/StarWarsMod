public class BlockType
{
	public int id;
	public int metadata = 0;
	public String displayName;
	public String internalName;

	public BlockType(int id, int metadata, String dn, String in)
	{
		this.id = id;
		this.metadata = metadata;
		this.displayName = dn;
		this.internalName = in;
	}
}
