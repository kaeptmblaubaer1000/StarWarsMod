package com.parzi.starwarsmod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemEndorBaseWall extends ItemBlock
{
	public ItemEndorBaseWall(Block block)
	{
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}
}