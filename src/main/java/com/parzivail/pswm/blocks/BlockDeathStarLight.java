package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.BlockLitMultiTexture;
import com.parzivail.util.world.HarvestLevel;

import net.minecraft.block.material.Material;

public class BlockDeathStarLight extends BlockLitMultiTexture
{
	public BlockDeathStarLight()
	{
		super("deathStarLight", new String[] { "HangarFloorSmall", "HangarFloor", "PureWhite", "HangarWallVertical", "Extra1", "Extra2" }, 1, Material.rock);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeMetal);
	}
}