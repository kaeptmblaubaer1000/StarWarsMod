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

public class BlockEndorBaseWall extends Block
{
	private String name = "endorBaseWall";
	private int subtypes = 6;

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockEndorBaseWall()
	{
		super(Material.rock);
		setBlockName(StarWarsMod.MODID + "." + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		setHardness(4F);
		setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeMetal);
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
