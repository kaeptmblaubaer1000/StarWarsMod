package com.parzivail.test;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;
import com.parzivail.pswm.utils.LootGenUtils;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.mobs.EntityCow;


public class ChestTest extends WorldGenerator implements IWorldGenerator
{
	public ChestTest() { }

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) { }

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		world.setBlock(x, y, z, block, metadata, 2);
	}

	public boolean generate(World world, Random rand, int i, int j, int k)
	{
		this.setBlock(world, i + 0, j + 0, k + 0, Blocks.grass, 0);
		this.setBlock(world, i + 0, j + 0, k + 1, Blocks.grass, 0);
		this.setBlock(world, i + 0, j + 0, k + 2, Blocks.grass, 0);
		this.setBlock(world, i + 0, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 0, k + 0, Blocks.grass, 0);
		this.setBlock(world, i + 1, j + 0, k + 1, Blocks.grass, 0);
		this.setBlock(world, i + 1, j + 0, k + 2, Blocks.grass, 0);
		this.setBlock(world, i + 1, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 0, k + 0, Blocks.grass, 0);
		this.setBlock(world, i + 2, j + 0, k + 1, Blocks.grass, 0);
		this.setBlock(world, i + 2, j + 0, k + 2, Blocks.grass, 0);
		this.setBlock(world, i + 2, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 1, k + 1, Blocks.chest, 0);
		world.setBlockMetadataWithNotify(i + 2, j + 1, k + 1, 2, 2);
		this.setBlock(world, i + 2, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 0, k + 0, Blocks.grass, 0);
		this.setBlock(world, i + 3, j + 0, k + 1, Blocks.grass, 0);
		this.setBlock(world, i + 3, j + 0, k + 2, Blocks.grass, 0);
		this.setBlock(world, i + 3, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 2, Blocks.air, 0);
		if (!world.isRemote)
		{
			EntityCow entity0 = new EntityCow(world);
			entity0.setPosition(x + 0.5D + 1, y + 1, z + 0.5D + 1);
			world.spawnEntityInWorld(entity0);
		}

		TileEntityChest chest1 = (TileEntityChest)world.getTileEntity(i + 2, j + 1, k + 1);

		return true;
	}

}
