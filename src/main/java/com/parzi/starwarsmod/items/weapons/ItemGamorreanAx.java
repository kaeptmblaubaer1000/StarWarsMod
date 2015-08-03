package com.parzi.starwarsmod.items.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.TextUtils;

public class ItemGamorreanAx extends ItemSword
{
	public String name = "gamorreanAx";

	public ItemGamorreanAx()
	{
		super(StarWarsMod.gamorreanMat);
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(TextUtils.makeItalic("What they lacked in subtlty, they more "));
		list.add(TextUtils.makeItalic("than made up for in very damaging blows"));
	}
}
