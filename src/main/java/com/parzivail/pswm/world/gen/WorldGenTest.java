package com.parzivail.pswm.world.gen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTest extends WorldGenerator implements IWorldGenerator
{
	public WorldGenTest()
	{
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
	}

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		world.setBlock(x, y, z, block, metadata, 2);
	}

	public boolean generate(World world, Random rand, int i, int j, int k)
	{
		this.setBlock(world, i + 0, j + 0, k + 0, Blocks.grass, 0);
		this.setBlock(world, i + 0, j + 0, k + 1, Blocks.grass, 0);
		this.setBlock(world, i + 0, j + 0, k + 2, Blocks.grass, 0);
		this.setBlock(world, i + 0, j + 0, k + 3, Blocks.grass, 0);
		this.setBlock(world, i + 0, j + 0, k + 4, Blocks.grass, 0);
		this.setBlock(world, i + 0, j + 0, k + 5, Blocks.grass, 0);
		this.setBlock(world, i + 0, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 0, k + 0, Blocks.grass, 0);
		this.setBlock(world, i + 1, j + 0, k + 1, Blocks.grass, 0);
		this.setBlock(world, i + 1, j + 0, k + 2, Blocks.grass, 0);
		this.setBlock(world, i + 1, j + 0, k + 3, Blocks.grass, 0);
		this.setBlock(world, i + 1, j + 0, k + 4, Blocks.grass, 0);
		this.setBlock(world, i + 1, j + 0, k + 5, Blocks.grass, 0);
		this.setBlock(world, i + 1, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 0, k + 0, Blocks.grass, 0);
		this.setBlock(world, i + 2, j + 0, k + 1, Blocks.grass, 0);
		this.setBlock(world, i + 2, j + 0, k + 2, Blocks.grass, 0);
		this.setBlock(world, i + 2, j + 0, k + 3, Blocks.grass, 0);
		this.setBlock(world, i + 2, j + 0, k + 4, Blocks.grass, 0);
		this.setBlock(world, i + 2, j + 0, k + 5, Blocks.grass, 0);
		this.setBlock(world, i + 2, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 1, k + 2, Blocks.chest, 0);
		world.setBlockMetadataWithNotify(i + 2, j + 1, k + 2, 4, 2);
		this.setBlock(world, i + 2, j + 1, k + 3, Blocks.chest, 0);
		world.setBlockMetadataWithNotify(i + 2, j + 1, k + 3, 4, 2);
		this.setBlock(world, i + 2, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 0, k + 0, Blocks.grass, 0);
		this.setBlock(world, i + 3, j + 0, k + 1, Blocks.grass, 0);
		this.setBlock(world, i + 3, j + 0, k + 2, Blocks.grass, 0);
		this.setBlock(world, i + 3, j + 0, k + 3, Blocks.grass, 0);
		this.setBlock(world, i + 3, j + 0, k + 4, Blocks.grass, 0);
		this.setBlock(world, i + 3, j + 0, k + 5, Blocks.grass, 0);
		this.setBlock(world, i + 3, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 0, k + 0, Blocks.grass, 0);
		this.setBlock(world, i + 4, j + 0, k + 1, Blocks.grass, 0);
		this.setBlock(world, i + 4, j + 0, k + 2, Blocks.grass, 0);
		this.setBlock(world, i + 4, j + 0, k + 3, Blocks.grass, 0);
		this.setBlock(world, i + 4, j + 0, k + 4, Blocks.grass, 0);
		this.setBlock(world, i + 4, j + 0, k + 5, Blocks.grass, 0);
		this.setBlock(world, i + 4, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 0, k + 0, Blocks.grass, 0);
		this.setBlock(world, i + 5, j + 0, k + 1, Blocks.grass, 0);
		this.setBlock(world, i + 5, j + 0, k + 2, Blocks.grass, 0);
		this.setBlock(world, i + 5, j + 0, k + 3, Blocks.grass, 0);
		this.setBlock(world, i + 5, j + 0, k + 4, Blocks.grass, 0);
		this.setBlock(world, i + 5, j + 0, k + 5, Blocks.grass, 0);
		this.setBlock(world, i + 5, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 1, k + 5, Blocks.air, 0);

		return true;
	}

}