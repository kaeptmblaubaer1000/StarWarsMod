package com.parzi.starwarsmod.blocks;

import net.minecraft.block.material.Material;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.util.block.BlockLitMultiTexture;
import com.parzi.util.world.HarvestLevel;

public class BlockDeathStarLight extends BlockLitMultiTexture
{
	public BlockDeathStarLight()
	{
		super("deathStarLight", new String[] { "HangarFloorSmall", "HangarFloor", "PureWhite", "HangarWallVertical", "Extra1", "Extra2" }, 1, Material.rock);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.setStepSound(soundTypeMetal);
	}
}