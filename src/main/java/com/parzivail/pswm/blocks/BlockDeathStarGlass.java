package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.BlockConnected;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.material.Material;

public class BlockDeathStarGlass extends BlockConnected
{
	private String name = "deathStarGlass";

	public BlockDeathStarGlass()
	{
		super("glass", Material.glass);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setBlockName(Resources.MODID + "." + name);
		setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeGlass);
	}
}