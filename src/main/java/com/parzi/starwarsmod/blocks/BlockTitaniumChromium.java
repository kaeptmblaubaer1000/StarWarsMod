package com.parzi.starwarsmod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.parzi.starwarsmod.StarWarsMod;

public class BlockTitaniumChromium extends Block
{
	private String name = "titaniumChromiumBlock";

	public BlockTitaniumChromium()
	{
		super(Material.rock);
		setBlockName(StarWarsMod.MODID + "." + name);
		setBlockTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		setHardness(4F);
		setHarvestLevel("pickaxe", 3);
		setStepSound(soundTypeStone);
	}
}
