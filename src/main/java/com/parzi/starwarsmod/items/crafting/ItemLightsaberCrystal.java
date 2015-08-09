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
	private String name = "lightsaberCrystal";

	public String[] colors = { "red", "green", "blue" };

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemLightsaberCrystal()
	{
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setHasSubtypes(true);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	// @Override
	// public String getUnlocalizedName(ItemStack par1ItemStack)
	// {
	// int metadata = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0,
	// 15);
	// return name + "." + colors[metadata];
	// }

	@Override
	public IIcon getIconFromDamage(int par1)
	{
		return icons[par1];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int x = 0; x < colors.length; x++)
		{
			par3List.add(new ItemStack(this, 1, x));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[colors.length];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + name + "_" + colors[i]);
		}
	}
}
