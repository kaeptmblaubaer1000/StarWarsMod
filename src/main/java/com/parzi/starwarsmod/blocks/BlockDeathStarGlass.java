package com.parzi.starwarsmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.HarvestLevel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDeathStarGlass extends BlockConnected
{
	private String name = "deathStarGlass";

	public BlockDeathStarGlass()
	{
		super("glass", Material.glass);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setBlockName(Resources.MODID + "." + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.setStepSound(soundTypeGlass);
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}