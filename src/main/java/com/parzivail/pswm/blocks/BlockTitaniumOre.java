package com.parzivail.pswm.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.world.HarvestLevel;

public class BlockTitaniumOre extends Block
{
	public String name = "titaniumOre";

	public BlockTitaniumOre()
	{
		super(Material.rock);
		this.setBlockName(Resources.MODID + "." + this.name);
		this.setBlockTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.setStepSound(soundTypeStone);
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return StarWarsMod.titaniumDust;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockTitaniumOre.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */