package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlockStairs;
import com.parzivail.util.world.HarvestLevel;

public class BlockTempleStoneStairsFancy extends PBlockStairs
{
	public BlockTempleStoneStairsFancy()
	{
		super("templeStoneStairsBrickFancy", StarWarsMod.blockTempleStone, 2);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.useNeighborBrightness = true;
	}
}