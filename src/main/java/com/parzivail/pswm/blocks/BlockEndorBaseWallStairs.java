package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.world.HarvestLevel;

import net.minecraft.block.BlockStairs;

public class BlockEndorBaseWallStairs extends BlockStairs
{
	public String name = "endorBaseWallStairs";

	public BlockEndorBaseWallStairs()
	{
		super(StarWarsMod.blockEndorBaseWall, 0);
		setBlockName(Resources.MODID + "." + name);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.useNeighborBrightness = true;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockEndorBaseWallStairs.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */