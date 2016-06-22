package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlockStairs;
import com.parzivail.util.world.HarvestLevel;

public class BlockDeathStarLightStairs extends PBlockStairs
{
	public BlockDeathStarLightStairs()
	{
		super("deathStarLightStairs", StarWarsMod.blockDeathStarBlock, 4);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.useNeighborBrightness = true;
	}
}