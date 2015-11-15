package com.parzi.starwarsmod.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.TextUtils;

public class ItemGaffiStick extends ItemSword
{
	public String name = "gaffiStick";

	public ItemGaffiStick()
	{
		super(StarWarsMod.materialGaffi);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(TextUtils.makeItalic("Whoever has two hands can hold a gaderffi."));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		entityPlayer.playSound(StarWarsMod.MODID + ":" + "item.gaffi.rightclick", 1.0F, 1.0F);
		return itemStack;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemGaffiStick.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */