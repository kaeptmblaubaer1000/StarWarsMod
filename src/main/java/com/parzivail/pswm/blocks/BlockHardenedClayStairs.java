package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlockStairs;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.init.Blocks;

public class BlockHardenedClayStairs extends PBlockStairs
{
	public BlockHardenedClayStairs()
	{
		super("hardenedClayStairs", Blocks.hardened_clay, 0);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.useNeighborBrightness = true;
	}
}
