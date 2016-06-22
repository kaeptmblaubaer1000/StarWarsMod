package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlockStairs;
import com.parzivail.util.world.HarvestLevel;

public class BlockTempleStoneStairsSlabTop extends PBlockStairs
{
	public BlockTempleStoneStairsSlabTop()
	{
		super("templeStoneStairsSlabTop", StarWarsMod.blockTempleStone, 3);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.useNeighborBrightness = true;
	}
}