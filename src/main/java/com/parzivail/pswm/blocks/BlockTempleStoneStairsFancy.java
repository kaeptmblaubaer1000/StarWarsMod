package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.BlockStairs;

public class BlockTempleStoneStairsFancy extends BlockStairs
{
	public String name = "templeStoneStairsBrickFancy";

	public BlockTempleStoneStairsFancy()
	{
		super(StarWarsMod.blockTempleStone, 2);
		setBlockName(Resources.MODID + "." + name);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.useNeighborBrightness = true;
	}
}