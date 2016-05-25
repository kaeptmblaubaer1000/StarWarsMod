package {{PACKAGE}};

{{IMPORTS}}

{{CLASS_COMMENT}}
public class {{CLASS}}
{
	public {{CLASS}}() { }

	public void b(World world, int x, int y, int z, Block block, int metadata)
	{
		WorldUtils.setBlock(world, x, y, z, block, metadata, 1 | 2);
	}
    
    public void m(World world, int x, int y, int z, int metadata)
	{
		world.setBlockMetadataWithNotify(x, y, z, metadata, 1 | 2);
	}

{{GEN_METHODS}}
}