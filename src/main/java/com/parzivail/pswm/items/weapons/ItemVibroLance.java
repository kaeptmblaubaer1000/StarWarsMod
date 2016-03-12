package com.parzivail.pswm.items.weapons;

import java.util.List;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.ui.TextUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemVibroLance extends ItemSword
{
	public String name = "vibroLance";

	public ItemVibroLance()
	{
		super(StarWarsMod.materialGaffi);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(TextUtils.makeItalic("Kinda like a lance, but there's"));
		list.add(TextUtils.makeItalic("something about it we don't quite"));
		list.add(TextUtils.makeItalic("understand..."));
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\weapons\ItemGamorreanAx.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */