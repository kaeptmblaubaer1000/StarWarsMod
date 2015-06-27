package com.parzi.starwarsmod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.parzi.starwarsmod.StarWarsMod;

public class BlockChromiumOre extends Block
{
	private String name = "chromiumOre";

	public BlockChromiumOre()
	{
		super(Material.rock);
		setBlockName(StarWarsMod.MODID + "." + name);
		setBlockTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		setHardness(4F);
		setHarvestLevel("pickaxe", 3);
		setStepSound(soundTypeStone);
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return StarWarsMod.chromiumDust;
	}
}
