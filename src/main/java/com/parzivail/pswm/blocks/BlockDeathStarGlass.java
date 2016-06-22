package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.BlockConnected;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.material.Material;

public class BlockDeathStarGlass extends BlockConnected
{
	public BlockDeathStarGlass()
	{
		super("deathStarGlass", "glass", Material.glass);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeGlass);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}
}