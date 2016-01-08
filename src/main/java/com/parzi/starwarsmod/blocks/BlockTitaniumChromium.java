package com.parzi.starwarsmod.blocks;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.util.world.HarvestLevel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTitaniumChromium extends Block
{
	public String name = "titaniumChromiumBlock";

	public BlockTitaniumChromium()
	{
		super(Material.rock);
		this.setBlockName(Resources.MODID + "." + this.name);
		this.setBlockTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.setStepSound(soundTypeStone);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockTitaniumChromium.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */