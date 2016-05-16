package com.parzivail.pswm.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemTempleStoneBlock extends ItemBlock
{
	public ItemTempleStoneBlock(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}
}
