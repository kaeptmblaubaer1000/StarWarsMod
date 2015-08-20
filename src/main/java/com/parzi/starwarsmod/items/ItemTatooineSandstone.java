package com.parzi.starwarsmod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemTatooineSandstone extends ItemBlock
{
	public ItemTatooineSandstone(Block block)
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