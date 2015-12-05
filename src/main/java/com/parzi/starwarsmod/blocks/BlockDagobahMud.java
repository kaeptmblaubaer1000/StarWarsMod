package com.parzi.starwarsmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.parzi.starwarsmod.StarWarsMod;

public class BlockDagobahMud extends Block
{
	public String name = "dagobahMud";

	public BlockDagobahMud()
	{
		super(Material.ground);
		this.setBlockName(StarWarsMod.MODID + "." + this.name);
		this.setBlockTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setHardness(4.0F);
		this.setStepSound(soundTypeSand);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockChromiumOre.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */