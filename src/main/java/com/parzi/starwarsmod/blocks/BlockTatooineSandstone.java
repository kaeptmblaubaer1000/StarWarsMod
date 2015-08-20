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

public class BlockTatooineSandstone extends Block
{
	public static final String[] field_150157_a = new String[] { "default", "chiseled", "smooth" };
	private static final String[] field_150156_b = new String[] { "normal", "carved", "smooth" };

	private String name = "tatooineSandstone";

	private int subtypes = 3;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	@SideOnly(Side.CLIENT)
	private IIcon[] field_150158_M;
	@SideOnly(Side.CLIENT)
	private IIcon field_150159_N;
	@SideOnly(Side.CLIENT)
	private IIcon field_150160_O;

	public BlockTatooineSandstone()
	{
		super(Material.ground);
		setBlockName(StarWarsMod.MODID + "." + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		setHardness(0.5F);
		setHarvestLevel("pickaxe", HarvestLevel.WOOD);
		setStepSound(soundTypeSand);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (side != 1 && (side != 0 || meta != 1 && meta != 2))
		{
			if (side == 0)
			{
				return field_150160_O;
			}
			else
			{
				if (meta < 0 || meta >= field_150158_M.length)
				{
					meta = 0;
				}

				return field_150158_M[meta];
			}
		}
		else
		{
			return field_150159_N;
		}
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
		field_150158_M = new IIcon[field_150156_b.length];

		for (int i = 0; i < field_150158_M.length; ++i)
		{
			field_150158_M[i] = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + name + "_" + field_150156_b[i]);
		}

		field_150159_N = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + name + "_top");
		field_150160_O = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + name + "_bottom");
	}
}
