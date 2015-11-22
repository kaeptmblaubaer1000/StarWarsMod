package com.parzi.starwarsmod.items.crafting;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLightsaberCrystal extends Item
{
	public String name = "lightsaberCrystal";
	public String[] colors = { "red", "green", "blue" };
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemLightsaberCrystal()
	{
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setHasSubtypes(true);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public IIcon getIconFromDamage(int par1)
	{
		return this.icons[par1];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int x = 0; x < this.colors.length; x++)
			par3List.add(new ItemStack(this, 1, x));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.icons = new IIcon[this.colors.length];
		for (int i = 0; i < this.icons.length; i++)
			this.icons[i] = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + this.name + "_" + this.colors[i]);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\items\crafting\ItemLightsaberCrystal.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */