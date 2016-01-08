package com.parzi.starwarsmod.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.util.world.HarvestLevel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTatooineSand extends Block
{
	public String name = "tatooineSand";
	private int subtypes = 2;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockTatooineSand()
	{
		super(Material.sand);
		this.setBlockName(Resources.MODID + "." + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setHardness(0.5F);
		this.setHarvestLevel("shovel", HarvestLevel.WOOD);
		this.setStepSound(soundTypeSand);
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (meta < 2)
			return this.icons[meta];
		return this.icons[0];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List metaTypes)
	{
		for (int i = 0; i < this.subtypes; i++)
			metaTypes.add(new ItemStack(item, 1, i));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.icons = new IIcon[this.subtypes];
		for (int i = 0; i < this.icons.length; i++)
			this.icons[i] = par1IconRegister.registerIcon(Resources.MODID + ":" + this.name + i);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockTatooineSand.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */