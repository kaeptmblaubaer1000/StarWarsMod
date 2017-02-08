package com.parzivail.util.schematic;

/**
 * Created by Colby on 2/8/2017.
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
