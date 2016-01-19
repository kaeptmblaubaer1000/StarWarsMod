package com.parzivail.pswm.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemTatooineSandstone extends ItemBlock
{
	public ItemTatooineSandstone(Block block)
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
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemTatooineSandstone.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */