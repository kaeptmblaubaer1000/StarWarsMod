package com.parzi.starwarsmod.blocks;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.util.block.BlockConnected;
import com.parzi.util.world.HarvestLevel;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockDeathStarGlass extends BlockConnected
{
	private String name = "deathStarGlass";

	public BlockDeathStarGlass()
	{
		super("glass", Material.glass);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setBlockName(Resources.MODID + "." + this.name);
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.setStepSound(soundTypeGlass);
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

    //@Override
    //public int getRenderBlockPass()
    //{
    //    return 1;
    //}
}