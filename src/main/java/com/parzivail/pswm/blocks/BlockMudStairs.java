package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlockStairs;
import com.parzivail.util.world.HarvestLevel;

public class BlockMudStairs extends PBlockStairs
{
	public BlockMudStairs()
	{
		super("mudStairs", StarWarsMod.blockDagobahMud, 0);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.useNeighborBrightness = true;
	}
}
