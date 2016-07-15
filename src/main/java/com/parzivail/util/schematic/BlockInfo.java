package com.parzivail.util.schematic;

/**
 * @author Colby
 */
public class BlockInfo
{
	public short block;
	public byte metadata;

	public BlockInfo(short block, byte metadata)
	{
		this.block = block;
		this.metadata = metadata;
	}
}
