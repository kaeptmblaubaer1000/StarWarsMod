package com.parzi.starwarsmod.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.HarvestLevel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDeathStar extends Block
{
	public String name = "deathStarBlock";
	private String[] names = { "HangarFloor", "LightHangarFloor", "HangarCrate", "CorridorFloor", "CautionFloor", "HangarWallPanel", "CorridorWallPanel", "ShieldGeneratorConsole", "Extra1", "Extra2", "Extra3" };
	private int subtypes = names.length;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockDeathStar()
	{
		super(Material.rock);
		this.setBlockName(Resources.MODID + "." + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.setStepSound(soundTypeMetal);
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
		return this.icons[meta];
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
			this.icons[i] = par1IconRegister.registerIcon(Resources.MODID + ":" + this.name + this.names[i]);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockEndorBaseWall.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */