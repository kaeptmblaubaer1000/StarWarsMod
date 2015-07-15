package com.parzi.starwarsmod.blocks;

import net.minecraft.block.BlockFalling;
import net.minecraft.init.Blocks;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.HarvestLevel;

public class BlockTatooineSand extends BlockFalling
{
	private String name = "tatooineSand";

	public BlockTatooineSand()
	{
		setBlockName(StarWarsMod.MODID + "." + name);
		setBlockTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		setStepSound(soundTypeSand);
		setHarvestLevel("shovel", HarvestLevel.WOOD);
		setHardness(0.5F);
	}
}
