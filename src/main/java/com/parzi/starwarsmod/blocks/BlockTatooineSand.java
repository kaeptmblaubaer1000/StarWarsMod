package com.parzi.starwarsmod.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.HarvestLevel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTatooineSand extends Block
{
	private String name = "tatooineSand";
	private int subtypes = 2;

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockTatooineSand()
	{
		super(Material.sand);
		setBlockName(StarWarsMod.MODID + "." + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		setHardness(0.5F);
		setHarvestLevel("shovel", HarvestLevel.WOOD);
		setStepSound(soundTypeSand);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return icons[meta];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List metaTypes)
	{
		for (int i = 0; i < subtypes; i++)
		{
			metaTypes.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[subtypes];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + name + i);
		}
	}
}
