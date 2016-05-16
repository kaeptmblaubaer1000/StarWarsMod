package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemHolotableBlock extends ItemBlock
{
	public ItemHolotableBlock(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return "tile." + Resources.MODID + ".holoTable." + stack.getItemDamage();
	}
}
