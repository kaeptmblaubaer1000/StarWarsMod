package com.parzi.starwarsmod.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenMysteryShrine extends WorldGenerator implements IWorldGenerator
{
	protected Block[] getValidSpawnBlocks()
	{
		return new Block[] { Blocks.stone, Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.ice, Blocks.snow, Blocks.snow_layer };
	}

	public boolean locationIsValidSpawn(World world, int i, int j, int k)
	{
		int distanceToAir = 0;
		Block check = world.getBlock(i, j, k);

		while (check != Blocks.air)
		{
			if (distanceToAir > 5) { return false; }

			distanceToAir++;
			check = world.getBlock(i, j + distanceToAir, k);
		}

		j += distanceToAir - 1;

		Block block = world.getBlock(i, j, k);
		Block blockAbove = world.getBlock(i, j + 1, k);
		Block blockBelow = world.getBlock(i, j - 1, k);

		for (Block x : getValidSpawnBlocks())
		{
			if (blockAbove != Blocks.air) { return false; }
			if (block == x)
			{
				return true;
			}
			else if (block == Blocks.snow && blockBelow == x) { return true; }
		}

		return false;
	}

	public WorldGenMysteryShrine()
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

	@Override
	public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
	{
		return generate(0, p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_);
	}

	public boolean generate(int dimId, World world, Random rand, int i, int j, int k)
	{
		// check that each corner is one of the valid spawn blocks
		if (!locationIsValidSpawn(world, i, j, k) || !locationIsValidSpawn(world, i + 6, j, k) || !locationIsValidSpawn(world, i + 6, j, k + 7) || !locationIsValidSpawn(world, i, j, k + 7)) { return false; }

		k = k - 10;
		i = i - 10;

		this.setBlock(world, i + 0, j + 2, k + 4, Blocks.stonebrick, 0);
		this.setBlock(world, i + 1, j + 1, k + 2, Blocks.stonebrick, 0);
		this.setBlock(world, i + 1, j + 1, k + 3, Blocks.stonebrick, 0);
		this.setBlock(world, i + 1, j + 2, k + 0, Blocks.stonebrick, 0);
		this.setBlock(world, i + 2, j + 0, k + 2, Blocks.stonebrick, 0);
		this.setBlock(world, i + 2, j + 0, k + 3, Blocks.stonebrick, 0);
		this.setBlock(world, i + 2, j + 0, k + 4, Blocks.stonebrick, 0);
		this.setBlock(world, i + 2, j + 0, k + 5, Blocks.stonebrick, 0);
		this.setBlock(world, i + 2, j + 1, k + 2, Blocks.cobblestone_wall, 0);
		this.setBlock(world, i + 2, j + 1, k + 4, Blocks.cobblestone_wall, 0);
		this.setBlock(world, i + 2, j + 1, k + 5, Blocks.cobblestone_wall, 0);
		this.setBlock(world, i + 2, j + 1, k + 6, Blocks.stonebrick, 0);
		this.setBlock(world, i + 2, j + 2, k + 7, Blocks.stonebrick, 0);
		this.setBlock(world, i + 3, j + 0, k + 2, Blocks.stonebrick, 0);
		this.setBlock(world, i + 3, j + 0, k + 5, Blocks.stonebrick, 0);
		this.setBlock(world, i + 3, j + 1, k + 1, Blocks.stonebrick, 0);
		this.setBlock(world, i + 3, j + 1, k + 5, Blocks.cobblestone_wall, 0);
		this.setBlock(world, i + 3, j + 1, k + 6, Blocks.stonebrick, 0);
		this.setBlock(world, i + 4, j + 0, k + 2, Blocks.stonebrick, 0);
		this.setBlock(world, i + 4, j + 0, k + 3, Blocks.stonebrick, 0);
		this.setBlock(world, i + 4, j + 0, k + 4, Blocks.stonebrick, 0);
		this.setBlock(world, i + 4, j + 0, k + 5, Blocks.stonebrick, 0);
		this.setBlock(world, i + 4, j + 1, k + 2, Blocks.cobblestone_wall, 0);
		this.setBlock(world, i + 4, j + 1, k + 4, Blocks.cobblestone_wall, 0);
		this.setBlock(world, i + 4, j + 2, k + 7, Blocks.stonebrick, 0);
		this.setBlock(world, i + 5, j + 1, k + 3, Blocks.stonebrick, 0);
		this.setBlock(world, i + 5, j + 1, k + 5, Blocks.stonebrick, 0);
		this.setBlock(world, i + 5, j + 2, k + 0, Blocks.stonebrick, 0);
		this.setBlock(world, i + 5, j + 2, k + 2, Blocks.stone_brick_stairs, 0);
		this.setBlock(world, i + 5, j + 2, k + 3, Blocks.stone_brick_stairs, 0);
		this.setBlock(world, i + 5, j + 2, k + 4, Blocks.stone_brick_stairs, 0);
		this.setBlock(world, i + 5, j + 2, k + 5, Blocks.stone_brick_stairs, 0);
		this.setBlock(world, i + 6, j + 2, k + 4, Blocks.stonebrick, 0);
		this.setBlock(world, i + 6, j + 2, k + 6, Blocks.stonebrick, 0);
		this.setBlock(world, i + 0, j + 2, k + 0, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 0, j + 2, k + 0, 3, 2);
		this.setBlock(world, i + 0, j + 2, k + 1, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 2, k + 1, 1, 2);
		this.setBlock(world, i + 0, j + 2, k + 2, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 0, j + 2, k + 2, 3, 2);
		this.setBlock(world, i + 0, j + 2, k + 3, Blocks.stonebrick, 2);
		world.setBlockMetadataWithNotify(i + 0, j + 2, k + 3, 2, 2);
		this.setBlock(world, i + 0, j + 2, k + 5, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 0, j + 2, k + 5, 3, 2);
		this.setBlock(world, i + 0, j + 2, k + 6, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 2, k + 6, 1, 2);
		this.setBlock(world, i + 0, j + 2, k + 7, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 0, j + 2, k + 7, 3, 2);
		this.setBlock(world, i + 0, j + 3, k + 0, Blocks.torch, 5);
		world.setBlockMetadataWithNotify(i + 0, j + 3, k + 0, 5, 2);
		this.setBlock(world, i + 0, j + 3, k + 7, Blocks.torch, 5);
		world.setBlockMetadataWithNotify(i + 0, j + 3, k + 7, 5, 2);
		this.setBlock(world, i + 1, j + 1, k + 4, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 1, k + 4, 1, 2);
		this.setBlock(world, i + 1, j + 1, k + 5, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 1, k + 5, 1, 2);
		this.setBlock(world, i + 1, j + 2, k + 1, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 1, 3, 2);
		this.setBlock(world, i + 1, j + 2, k + 2, Blocks.stone_brick_stairs, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 2, 1, 2);
		this.setBlock(world, i + 1, j + 2, k + 3, Blocks.stone_brick_stairs, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 3, 1, 2);
		this.setBlock(world, i + 1, j + 2, k + 4, Blocks.stone_brick_stairs, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 4, 1, 2);
		this.setBlock(world, i + 1, j + 2, k + 5, Blocks.stone_brick_stairs, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 5, 1, 2);
		this.setBlock(world, i + 1, j + 2, k + 6, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 6, 3, 2);
		this.setBlock(world, i + 1, j + 2, k + 7, Blocks.stonebrick, 2);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 7, 2, 2);
		this.setBlock(world, i + 2, j + 1, k + 1, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 1, k + 1, 1, 2);
		this.setBlock(world, i + 2, j + 1, k + 3, Blocks.cobblestone_wall, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 1, k + 3, 1, 2);
		this.setBlock(world, i + 2, j + 2, k + 0, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 2, k + 0, 1, 2);
		this.setBlock(world, i + 2, j + 2, k + 1, Blocks.stone_brick_stairs, 3);
		world.setBlockMetadataWithNotify(i + 2, j + 2, k + 1, 3, 2);
		this.setBlock(world, i + 2, j + 2, k + 2, Blocks.torch, 5);
		world.setBlockMetadataWithNotify(i + 2, j + 2, k + 2, 5, 2);
		this.setBlock(world, i + 2, j + 2, k + 5, Blocks.torch, 5);
		world.setBlockMetadataWithNotify(i + 2, j + 2, k + 5, 5, 2);
		this.setBlock(world, i + 2, j + 2, k + 6, Blocks.stone_brick_stairs, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 2, k + 6, 2, 2);
		this.setBlock(world, i + 3, j + 0, k + 3, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 3, 3, 2);
		this.setBlock(world, i + 3, j + 0, k + 4, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 4, 3, 2);
		this.setBlock(world, i + 3, j + 1, k + 2, Blocks.cobblestone_wall, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 1, k + 2, 1, 2);
		this.setBlock(world, i + 3, j + 2, k + 0, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 3, j + 2, k + 0, 3, 2);
		this.setBlock(world, i + 3, j + 2, k + 1, Blocks.stone_brick_stairs, 3);
		world.setBlockMetadataWithNotify(i + 3, j + 2, k + 1, 3, 2);
		this.setBlock(world, i + 3, j + 2, k + 6, Blocks.stone_brick_stairs, 2);
		world.setBlockMetadataWithNotify(i + 3, j + 2, k + 6, 2, 2);
		this.setBlock(world, i + 3, j + 2, k + 7, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 3, j + 2, k + 7, 3, 2);
		this.setBlock(world, i + 4, j + 1, k + 1, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 1, k + 1, 1, 2);
		this.setBlock(world, i + 4, j + 1, k + 3, Blocks.cobblestone_wall, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 1, k + 3, 1, 2);
		this.setBlock(world, i + 4, j + 1, k + 5, Blocks.cobblestone_wall, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 1, k + 5, 1, 2);
		this.setBlock(world, i + 4, j + 1, k + 6, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 1, k + 6, 1, 2);
		this.setBlock(world, i + 4, j + 2, k + 0, Blocks.stonebrick, 2);
		world.setBlockMetadataWithNotify(i + 4, j + 2, k + 0, 2, 2);
		this.setBlock(world, i + 4, j + 2, k + 1, Blocks.stone_brick_stairs, 3);
		world.setBlockMetadataWithNotify(i + 4, j + 2, k + 1, 3, 2);
		this.setBlock(world, i + 4, j + 2, k + 2, Blocks.torch, 5);
		world.setBlockMetadataWithNotify(i + 4, j + 2, k + 2, 5, 2);
		this.setBlock(world, i + 4, j + 2, k + 5, Blocks.torch, 5);
		world.setBlockMetadataWithNotify(i + 4, j + 2, k + 5, 5, 2);
		this.setBlock(world, i + 4, j + 2, k + 6, Blocks.stone_brick_stairs, 2);
		world.setBlockMetadataWithNotify(i + 4, j + 2, k + 6, 2, 2);
		this.setBlock(world, i + 5, j + 1, k + 2, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 1, k + 2, 1, 2);
		this.setBlock(world, i + 5, j + 1, k + 4, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 1, k + 4, 1, 2);
		this.setBlock(world, i + 5, j + 2, k + 1, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 5, j + 2, k + 1, 3, 2);
		this.setBlock(world, i + 5, j + 2, k + 6, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 5, j + 2, k + 6, 3, 2);
		this.setBlock(world, i + 5, j + 2, k + 7, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 2, k + 7, 1, 2);
		this.setBlock(world, i + 6, j + 2, k + 0, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 6, j + 2, k + 0, 3, 2);
		this.setBlock(world, i + 6, j + 2, k + 1, Blocks.stonebrick, 1);
		world.setBlockMetadataWithNotify(i + 6, j + 2, k + 1, 1, 2);
		this.setBlock(world, i + 6, j + 2, k + 2, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 6, j + 2, k + 2, 3, 2);
		this.setBlock(world, i + 6, j + 2, k + 3, Blocks.stonebrick, 2);
		world.setBlockMetadataWithNotify(i + 6, j + 2, k + 3, 2, 2);
		this.setBlock(world, i + 6, j + 2, k + 5, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 6, j + 2, k + 5, 3, 2);
		this.setBlock(world, i + 6, j + 2, k + 7, Blocks.stonebrick, 3);
		world.setBlockMetadataWithNotify(i + 6, j + 2, k + 7, 3, 2);
		this.setBlock(world, i + 6, j + 3, k + 0, Blocks.torch, 5);
		world.setBlockMetadataWithNotify(i + 6, j + 3, k + 0, 5, 2);
		this.setBlock(world, i + 6, j + 3, k + 7, Blocks.torch, 5);
		world.setBlockMetadataWithNotify(i + 6, j + 3, k + 7, 5, 2);

		this.setBlock(world, i + 3, j + 1, k + 3, Blocks.chest, 4);
		world.setBlockMetadataWithNotify(i + 3, j + 1, k + 3, 4, 2);
		this.setBlock(world, i + 3, j + 1, k + 4, Blocks.chest, 4);
		world.setBlockMetadataWithNotify(i + 3, j + 1, k + 4, 4, 2);

		randomFillChest(dimId, rand, (TileEntityChest)world.getTileEntity(i + 3, j + 1, k + 3));
		randomFillChest(dimId, rand, (TileEntityChest)world.getTileEntity(i + 3, j + 1, k + 4));

		return true;
	}

	public void randomFillChest(int dimId, Random rand, TileEntityChest tile)
	{
		if (tile != null)
		{
			for (int i = 0; i < rand.nextInt(8) + 2; i++)
			{
				tile.setInventorySlotContents(rand.nextInt(27), getWeightedItem(dimId, rand));
			}
		}
	}

	public ItemStack getWeightedItem(int dimId, Random rand)
	{
		ItemStack[] items = null;

		if (dimId == StarWarsMod.dimHothId) {
			items = new ItemStack[] { new ItemStack(StarWarsMod.hiltMetelCompound, rand.nextInt(3)), new ItemStack(StarWarsMod.lightsaberCrystal, 1, rand.nextInt(3)), new ItemStack(StarWarsMod.tiePilotBoots), new ItemStack(StarWarsMod.tiePilotLegs), new ItemStack(StarWarsMod.tiePilotChest), new ItemStack(StarWarsMod.tiePilotHelmet), new ItemStack(StarWarsMod.titaniumChromiumIngot), new ItemStack(StarWarsMod.blasterPistol, 1, rand.nextInt(StarWarsMod.blasterPistol.subtypes)), new ItemStack(StarWarsMod.blasterRifle, 1, rand.nextInt(StarWarsMod.blasterRifle.subtypes)) };
		}
		else if (dimId == StarWarsMod.dimEndorId) {
			items = new ItemStack[] { new ItemStack(StarWarsMod.hiltMetelCompound, rand.nextInt(3)), new ItemStack(StarWarsMod.lightsaberCrystal, 1, rand.nextInt(3)), new ItemStack(StarWarsMod.endorBoots), new ItemStack(StarWarsMod.endorLegs), new ItemStack(StarWarsMod.endorChest), new ItemStack(StarWarsMod.endorHelmet), new ItemStack(StarWarsMod.titaniumChromiumIngot), new ItemStack(StarWarsMod.blasterPistol, 1, rand.nextInt(StarWarsMod.blasterPistol.subtypes)), new ItemStack(StarWarsMod.blasterRifle, 1, rand.nextInt(StarWarsMod.blasterRifle.subtypes)) };
		}
		else {
			items = new ItemStack[] { new ItemStack(StarWarsMod.hiltMetelCompound, rand.nextInt(3)), new ItemStack(StarWarsMod.lightsaberCrystal, 1, rand.nextInt(3)), new ItemStack(StarWarsMod.stormtrooperBoots), new ItemStack(StarWarsMod.stormtrooperLegs), new ItemStack(StarWarsMod.stormtrooperChest), new ItemStack(StarWarsMod.stormtrooperHelmet), new ItemStack(StarWarsMod.titaniumChromiumIngot), new ItemStack(StarWarsMod.blasterPistol, 1, rand.nextInt(StarWarsMod.blasterPistol.subtypes)), new ItemStack(StarWarsMod.blasterRifle, 1, rand.nextInt(StarWarsMod.blasterRifle.subtypes)) };
		}
		float[] weights = { 0.05F, 0.001F, 0.005F, 0.005F, 0.005F, 0.005F, 0.05F, 0.002F, 0.002F };

		double totalWeight = 0.0d;
		for (int i = 0; i < items.length; i++)
		{
			totalWeight += weights[i];
		}
		// Now choose a random item
		int randomIndex = -1;
		double random = rand.nextDouble() * totalWeight;
		for (int i = 0; i < items.length; i++)
		{
			random -= weights[i];
			if (random <= 0.0d)
			{
				randomIndex = i;
				break;
			}
		}
		return items[randomIndex];
	}
}