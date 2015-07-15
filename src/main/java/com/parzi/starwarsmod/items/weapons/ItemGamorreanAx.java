package com.parzi.starwarsmod.items.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

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
}
