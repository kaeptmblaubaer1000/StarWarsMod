package com.parzivail.pswm.tabs;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.weapons.ItemLightsaber;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Arrays;

public class SequelStarWarsTab extends CreativeTabs
{
	public SequelStarWarsTab()
	{
		super("tabStarWarsSequel");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return StarWarsMod.lightsaberNew[Arrays.asList(ItemLightsaber.hilts).indexOf("crossguard")];
	}
}
