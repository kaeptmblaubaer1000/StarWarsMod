package com.parzi.starwarsmod.blocks;

import net.minecraft.block.BlockStairs;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.HarvestLevel;

public class BlockEndorBaseWallStairs extends BlockStairs
{
	private String name = "endorBaseWallStairs";

	public BlockEndorBaseWallStairs()
	{
		super(StarWarsMod.blockEndorBaseWall, 0);
		setBlockName(StarWarsMod.MODID + "." + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}
}
