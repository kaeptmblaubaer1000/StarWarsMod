package com.parzivail.util.block;

import com.parzivail.pswm.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class PBlockStairs extends BlockStairs
{
	public String name;

	public PBlockStairs(String name, Block block, int meta)
	{
		super(block, meta);
		this.name = name;
		this.setBlockName(Resources.MODID + "." + this.name);
	}
}