package com.parzivail.pswm.tabs;

import com.parzivail.pswm.StarWarsMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class StarWarsTabBlocks extends CreativeTabs
{
	public StarWarsTabBlocks()
	{
		super("tabStarWarsBlocks");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(StarWarsMod.blockMV);
	}
}
