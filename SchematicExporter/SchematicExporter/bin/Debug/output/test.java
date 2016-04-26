package com.parzivail.test;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;
import com.parzivail.pswm.StarWarsMod;

public class Test extends WorldGenerator implements IWorldGenerator
{
	public Test() { }

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) { }

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		world.setBlock(x, y, z, block, metadata, 2);
	}

	public boolean generate(World world, Random rand, int i, int j, int k)
	{
		this.setBlock(world, i + 0, j + 0, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 0, k + 1, StarWarsMod.blockTempleStoneSlabLit, 0);
		world.setBlockMetadataWithNotify(i + 0, j + 0, k + 1, 1, 2);
		this.setBlock(world, i + 0, j + 0, k + 2, StarWarsMod.blockTempleStoneSlab, 0);
		world.setBlockMetadataWithNotify(i + 0, j + 0, k + 2, 1, 2);
		this.setBlock(world, i + 0, j + 0, k + 3, StarWarsMod.blockHeliciteOre, 0);
		this.setBlock(world, i + 0, j + 0, k + 4, StarWarsMod.blockHoloTable, 0);
		world.setBlockMetadataWithNotify(i + 0, j + 0, k + 4, 1, 2);
		this.setBlock(world, i + 0, j + 0, k + 5, StarWarsMod.blockDeathStarLight, 0);
		world.setBlockMetadataWithNotify(i + 0, j + 0, k + 5, 1, 2);
		this.setBlock(world, i + 0, j + 0, k + 6, StarWarsMod.blockDeathStarBlock, 0);
		world.setBlockMetadataWithNotify(i + 0, j + 0, k + 6, 2, 2);
		this.setBlock(world, i + 0, j + 0, k + 7, StarWarsMod.blockTatooineSandstone, 0);
		world.setBlockMetadataWithNotify(i + 0, j + 0, k + 7, 2, 2);
		this.setBlock(world, i + 0, j + 0, k + 8, StarWarsMod.blockEndorBaseWall, 0);
		world.setBlockMetadataWithNotify(i + 0, j + 0, k + 8, 4, 2);
		this.setBlock(world, i + 1, j + 0, k + 0, Blocks.birch_fence_gate, 0);
		world.setBlockMetadataWithNotify(i + 1, j + 0, k + 0, 2, 2);
		this.setBlock(world, i + 1, j + 0, k + 1, StarWarsMod.blockTempleStoneSlabLit, 0);
		this.setBlock(world, i + 1, j + 0, k + 2, StarWarsMod.blockTempleStoneSlab, 0);
		this.setBlock(world, i + 1, j + 0, k + 3, StarWarsMod.blockCortosisOre, 0);
		this.setBlock(world, i + 1, j + 0, k + 4, StarWarsMod.blockHoloTable, 0);
		this.setBlock(world, i + 1, j + 0, k + 5, StarWarsMod.blockDeathStarLight, 0);
		this.setBlock(world, i + 1, j + 0, k + 6, StarWarsMod.blockDeathStarBlock, 0);
		world.setBlockMetadataWithNotify(i + 1, j + 0, k + 6, 1, 2);
		this.setBlock(world, i + 1, j + 0, k + 7, StarWarsMod.blockTatooineSandstone, 0);
		world.setBlockMetadataWithNotify(i + 1, j + 0, k + 7, 1, 2);
		this.setBlock(world, i + 1, j + 0, k + 8, StarWarsMod.blockEndorBaseWall, 0);
		world.setBlockMetadataWithNotify(i + 1, j + 0, k + 8, 3, 2);
		this.setBlock(world, i + 2, j + 0, k + 0, StarWarsMod.blockTempleStoneStairsSlabTop, 0);
		world.setBlockMetadataWithNotify(i + 2, j + 0, k + 0, 2, 2);
		this.setBlock(world, i + 2, j + 0, k + 1, StarWarsMod.blockTempleStoneLit, 0);
		world.setBlockMetadataWithNotify(i + 2, j + 0, k + 1, 4, 2);
		this.setBlock(world, i + 2, j + 0, k + 2, StarWarsMod.blockTempleStone, 0);
		world.setBlockMetadataWithNotify(i + 2, j + 0, k + 2, 4, 2);
		this.setBlock(world, i + 2, j + 0, k + 3, StarWarsMod.blockIoniteOre, 0);
		this.setBlock(world, i + 2, j + 0, k + 4, StarWarsMod.blockFieldEmitter, 0);
		this.setBlock(world, i + 2, j + 0, k + 5, StarWarsMod.blockDeathStarBlock, 0);
		world.setBlockMetadataWithNotify(i + 2, j + 0, k + 5, 9, 2);
		this.setBlock(world, i + 2, j + 0, k + 6, StarWarsMod.blockDeathStarBlock, 0);
		this.setBlock(world, i + 2, j + 0, k + 7, StarWarsMod.blockTatooineSandstone, 0);
		this.setBlock(world, i + 2, j + 0, k + 8, StarWarsMod.blockEndorBaseWall, 0);
		world.setBlockMetadataWithNotify(i + 2, j + 0, k + 8, 2, 2);
		this.setBlock(world, i + 3, j + 0, k + 0, StarWarsMod.blockTempleStoneStairs, 0);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 0, 2, 2);
		this.setBlock(world, i + 3, j + 0, k + 1, StarWarsMod.blockTempleStoneLit, 0);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 1, 3, 2);
		this.setBlock(world, i + 3, j + 0, k + 2, StarWarsMod.blockTempleStone, 0);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 2, 3, 2);
		this.setBlock(world, i + 3, j + 0, k + 3, StarWarsMod.blockKeleriumOre, 0);
		this.setBlock(world, i + 3, j + 0, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 0, k + 5, StarWarsMod.blockDeathStarBlock, 0);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 5, 8, 2);
		this.setBlock(world, i + 3, j + 0, k + 6, StarWarsMod.blockBasket, 0);
		this.setBlock(world, i + 3, j + 0, k + 7, StarWarsMod.blockSpaceLamp, 0);
		this.setBlock(world, i + 3, j + 0, k + 8, StarWarsMod.blockEndorBaseWall, 0);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 8, 1, 2);
		this.setBlock(world, i + 4, j + 0, k + 0, StarWarsMod.blockTempleStoneStairsSlabTopDark, 0);
		world.setBlockMetadataWithNotify(i + 4, j + 0, k + 0, 2, 2);
		this.setBlock(world, i + 4, j + 0, k + 1, StarWarsMod.blockTempleStoneLit, 0);
		world.setBlockMetadataWithNotify(i + 4, j + 0, k + 1, 2, 2);
		this.setBlock(world, i + 4, j + 0, k + 2, StarWarsMod.blockTempleStone, 0);
		world.setBlockMetadataWithNotify(i + 4, j + 0, k + 2, 2, 2);
		this.setBlock(world, i + 4, j + 0, k + 3, StarWarsMod.blockExoniumOre, 0);
		this.setBlock(world, i + 4, j + 0, k + 4, StarWarsMod.blockDeathStarGlass, 0);
		this.setBlock(world, i + 4, j + 0, k + 5, StarWarsMod.blockDeathStarBlock, 0);
		world.setBlockMetadataWithNotify(i + 4, j + 0, k + 5, 7, 2);
		this.setBlock(world, i + 4, j + 0, k + 6, StarWarsMod.blockHangingBucket, 0);
		this.setBlock(world, i + 4, j + 0, k + 7, StarWarsMod.blockTable, 0);
		this.setBlock(world, i + 4, j + 0, k + 8, StarWarsMod.blockEndorBaseWall, 0);
		this.setBlock(world, i + 5, j + 0, k + 0, StarWarsMod.blockTempleStoneStairsBrick, 0);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 0, 2, 2);
		this.setBlock(world, i + 5, j + 0, k + 1, StarWarsMod.blockTempleStoneLit, 0);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 1, 1, 2);
		this.setBlock(world, i + 5, j + 0, k + 2, StarWarsMod.blockTempleStone, 0);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 2, 1, 2);
		this.setBlock(world, i + 5, j + 0, k + 3, StarWarsMod.blockTitaniumOre, 0);
		this.setBlock(world, i + 5, j + 0, k + 4, StarWarsMod.blockDeathStarLight, 0);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 4, 5, 2);
		this.setBlock(world, i + 5, j + 0, k + 5, StarWarsMod.blockDeathStarBlock, 0);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 5, 6, 2);
		this.setBlock(world, i + 5, j + 0, k + 6, StarWarsMod.blockHangingCauldron, 0);
		this.setBlock(world, i + 5, j + 0, k + 7, StarWarsMod.blockTatooineSand, 0);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 7, 1, 2);
		this.setBlock(world, i + 5, j + 0, k + 8, StarWarsMod.blockTitaniumChromiumBlock, 0);
		this.setBlock(world, i + 6, j + 0, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 0, k + 1, StarWarsMod.blockTempleStoneLit, 0);
		this.setBlock(world, i + 6, j + 0, k + 2, StarWarsMod.blockTempleStone, 0);
		this.setBlock(world, i + 6, j + 0, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 0, k + 4, StarWarsMod.blockDeathStarLight, 0);
		world.setBlockMetadataWithNotify(i + 6, j + 0, k + 4, 4, 2);
		this.setBlock(world, i + 6, j + 0, k + 5, StarWarsMod.blockDeathStarBlock, 0);
		world.setBlockMetadataWithNotify(i + 6, j + 0, k + 5, 5, 2);
		this.setBlock(world, i + 6, j + 0, k + 6, StarWarsMod.blockMudStairs, 0);
		world.setBlockMetadataWithNotify(i + 6, j + 0, k + 6, 2, 2);
		this.setBlock(world, i + 6, j + 0, k + 7, StarWarsMod.blockTatooineSand, 0);
		this.setBlock(world, i + 6, j + 0, k + 8, StarWarsMod.blockTitaniumOre, 0);
		this.setBlock(world, i + 7, j + 0, k + 0, StarWarsMod.blockEndorBaseWallStairs, 0);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 0, 3, 2);
		this.setBlock(world, i + 7, j + 0, k + 1, StarWarsMod.blockTempleStoneSlab, 0);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 1, 3, 2);
		this.setBlock(world, i + 7, j + 0, k + 2, StarWarsMod.blockDolomiteOre, 0);
		this.setBlock(world, i + 7, j + 0, k + 3, StarWarsMod.blockHoloTable, 0);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 3, 3, 2);
		this.setBlock(world, i + 7, j + 0, k + 4, StarWarsMod.blockDeathStarLight, 0);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 4, 3, 2);
		this.setBlock(world, i + 7, j + 0, k + 5, StarWarsMod.blockDeathStarBlock, 0);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 5, 4, 2);
		this.setBlock(world, i + 7, j + 0, k + 6, StarWarsMod.blockTable2, 0);
		this.setBlock(world, i + 7, j + 0, k + 7, StarWarsMod.blockEndorBaseWallStairs, 0);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 7, 2, 2);
		this.setBlock(world, i + 7, j + 0, k + 8, StarWarsMod.blockChromiumOre, 0);
		this.setBlock(world, i + 8, j + 0, k + 0, StarWarsMod.blockTempleStoneSlabLit, 0);
		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 0, 2, 2);
		this.setBlock(world, i + 8, j + 0, k + 1, StarWarsMod.blockTempleStoneSlab, 0);
		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 1, 2, 2);
		this.setBlock(world, i + 8, j + 0, k + 2, StarWarsMod.blockRubindumOre, 0);
		this.setBlock(world, i + 8, j + 0, k + 3, StarWarsMod.blockHoloTable, 0);
		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 3, 2, 2);
		this.setBlock(world, i + 8, j + 0, k + 4, StarWarsMod.blockDeathStarLight, 0);
		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 4, 2, 2);
		this.setBlock(world, i + 8, j + 0, k + 5, StarWarsMod.blockDeathStarBlock, 0);
		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 5, 3, 2);
		this.setBlock(world, i + 8, j + 0, k + 6, StarWarsMod.blockDagobahMud, 0);
		this.setBlock(world, i + 8, j + 0, k + 7, StarWarsMod.blockEndorBaseWall, 0);
		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 7, 5, 2);
		this.setBlock(world, i + 8, j + 0, k + 8, StarWarsMod.blockMV, 0);
		return true;
	}

}
