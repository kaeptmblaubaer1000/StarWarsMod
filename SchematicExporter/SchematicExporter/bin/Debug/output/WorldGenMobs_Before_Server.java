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
import com.parzivail.pswm.mobs.trooper.MobScouttrooper;
import com.parzivail.pswm.mobs.MobDroidAstromech2;
import com.parzivail.pswm.vehicles.VehicSpeederBike;
import com.parzivail.pswm.mobs.trooper.MobSandtrooper;


public class Mobs_Before_Server extends WorldGenerator implements IWorldGenerator
{
	public Mobs_Before_Server() { }

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) { }

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		world.setBlock(x, y, z, block, metadata, 2);
	}

	public boolean generate(World world, Random rand, int i, int j, int k)
	{
		this.setBlock(world, i + 0, j + 0, k + 0, Blocks.stone, 0);
		this.setBlock(world, i + 0, j + 0, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 0, j + 0, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 0, j + 0, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 0, j + 0, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 0, j + 0, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 0, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 0, k + 0, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 0, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 0, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 0, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 0, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 0, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 0, k + 0, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 0, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 0, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 0, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 0, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 0, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 0, k + 0, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 0, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 0, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 0, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 0, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 0, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 0, k + 0, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 0, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 0, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 0, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 0, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 0, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 1, k + 4, Blocks.air, 0);
		if (!world.isRemote)
		{
			MobScouttrooper entity0 = new MobScouttrooper(world);
			entity0.setPosition(i + 0.5D + 0, j + 1, k + 0.5D + 0);
			world.spawnEntityInWorld(entity0);
		}

		if (!world.isRemote)
		{
			MobDroidAstromech2 entity1 = new MobDroidAstromech2(world);
			entity1.setPosition(i + 0.5D + 4, j + 1, k + 0.5D + 0);
			world.spawnEntityInWorld(entity1);
		}

		if (!world.isRemote)
		{
			VehicSpeederBike entity2 = new VehicSpeederBike(world);
			entity2.setPosition(i + 0.5D + 4, j + 1, k + 0.5D + 5);
			world.spawnEntityInWorld(entity2);
		}

		if (!world.isRemote)
		{
			MobSandtrooper entity3 = new MobSandtrooper(world);
			entity3.setPosition(i + 0.5D + 0, j + 1, k + 0.5D + 5);
			world.spawnEntityInWorld(entity3);
		}

		return true;
	}

}
