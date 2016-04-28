package com.parzivail.pswm.world.gen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;


public class WorldGenTest
{
	public WorldGenTest() { }

	public void b(World world, int x, int y, int z, Block block, int metadata)
	{
		world.setBlock(x, y, z, block, metadata, 1 | 2);
	}
    
    public void m(World world, int x, int y, int z, int metadata)
	{
		world.setBlockMetadataWithNotify(x, y, z, metadata, 1 | 2);
	}

	public boolean generate(World world, int i, int j, int k)
	{
		this.b(world, i + 0, j + 0, k + 0, Blocks.grass, 0);
		this.b(world, i + 0, j + 0, k + 1, Blocks.grass, 0);
		this.b(world, i + 0, j + 0, k + 2, Blocks.grass, 0);
		this.b(world, i + 0, j + 1, k + 0, Blocks.air, 0);
		this.b(world, i + 0, j + 1, k + 1, Blocks.air, 0);
		this.b(world, i + 0, j + 1, k + 2, Blocks.air, 0);
		this.b(world, i + 1, j + 0, k + 0, Blocks.grass, 0);
		this.b(world, i + 1, j + 0, k + 1, Blocks.grass, 0);
		this.b(world, i + 1, j + 0, k + 2, Blocks.grass, 0);
		this.b(world, i + 1, j + 1, k + 0, Blocks.air, 0);
		this.b(world, i + 1, j + 1, k + 1, Blocks.chest, 0);
		this.m(world, i + 1, j + 1, k + 1, 2);
		this.b(world, i + 1, j + 1, k + 2, Blocks.air, 0);
		this.b(world, i + 2, j + 0, k + 0, Blocks.grass, 0);
		this.b(world, i + 2, j + 0, k + 1, Blocks.grass, 0);
		this.b(world, i + 2, j + 0, k + 2, Blocks.grass, 0);
		this.b(world, i + 2, j + 1, k + 0, Blocks.air, 0);
		this.b(world, i + 2, j + 1, k + 1, Blocks.chest, 0);
		this.m(world, i + 2, j + 1, k + 1, 2);
		this.b(world, i + 2, j + 1, k + 2, Blocks.air, 0);
		this.b(world, i + 3, j + 0, k + 0, Blocks.grass, 0);
		this.b(world, i + 3, j + 0, k + 1, Blocks.grass, 0);
		this.b(world, i + 3, j + 0, k + 2, Blocks.grass, 0);
		this.b(world, i + 3, j + 1, k + 0, Blocks.air, 0);
		this.b(world, i + 3, j + 1, k + 1, Blocks.air, 0);
		this.b(world, i + 3, j + 1, k + 2, Blocks.air, 0);

		TileEntityChest chest1 = (TileEntityChest)world.getTileEntity(i + 2, j + 1, k + 1);

		return true;
	}

}
