package com.parzivail.pswm.tabs;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Arrays;

public class StarWarsTab extends CreativeTabs
{
	public StarWarsTab()
	{
		super("tabStarWars");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return StarWarsItems.lightsaberNew[Arrays.asList(ItemLightsaber.hilts).indexOf("luke2")];
	}
}
