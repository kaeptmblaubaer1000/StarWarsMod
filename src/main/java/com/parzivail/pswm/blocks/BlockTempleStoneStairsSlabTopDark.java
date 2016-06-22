package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlockStairs;
import com.parzivail.util.world.HarvestLevel;

public class BlockTempleStoneStairsSlabTopDark extends PBlockStairs
{
	public BlockTempleStoneStairsSlabTopDark()
	{
		super("templeStoneStairsSlabTopDark", StarWarsMod.blockTempleStone, 4);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.useNeighborBrightness = true;
	}
}