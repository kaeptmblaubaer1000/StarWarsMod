package com.parzi.starwarsmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.HarvestLevel;

public class BlockSpaceLamp extends Block
{
	private String name = "spaceLamp";

	public BlockSpaceLamp()
	{
		super(Material.rock);
		setBlockName(StarWarsMod.MODID + "." + name);
		setBlockTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		setHardness(4F);
		setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeStone);
		setLightLevel(1.0F);
	}
}
