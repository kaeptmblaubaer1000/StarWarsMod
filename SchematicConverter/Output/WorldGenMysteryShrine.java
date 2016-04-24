package your.mod.package;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenMysteryShrine extends WorldGenerator implements IWorldGenerator
{
	protected Block[] getValidSpawnBlocks() {
		return new Block[] {
			Blocks.stone,
			Blocks.grass,
			Blocks.dirt,
			Blocks.sand,
			Blocks.gravel,
			Blocks.ice,
			Blocks.snow,
			Blocks.snow_layer
		};
	}

	public boolean locationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		Block check = world.getBlock(i, j, k);

		while (check != Blocks.air){
			if (distanceToAir > 3){
				return false;
			}

			distanceToAir++;
			check = world.getBlock(i, j + distanceToAir, k);
		}

		j += distanceToAir - 1;

		Block block = world.getBlock(i, j, k);
		Block blockAbove = world.getBlock(i, j+1, k);
		Block blockBelow = world.getBlock(i, j-1, k);
		
		for (Block x : getValidSpawnBlocks()){
			if (blockAbove != Blocks.air){
				return false;
			}
			if (block == x){
				return true;
			}else if (block == Blocks.snow && blockBelow == x){
				return true;
			}
		}
		
		return false;
	}

	public WorldGenMysteryShrine() { }

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) { }

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		Block b1 = world.getBlock(x, y, z);

		if(b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z))
		{
			world.setBlock(x, y, z, block, metadata, 2);
		}
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!locationIsValidSpawn(world, i, j, k) || !locationIsValidSpawn(world, i + 6, j, k) || !locationIsValidSpawn(world, i + 6, j, k + 7) || !locationIsValidSpawn(world, i, j, k + 7))
		{
			return false;
		}

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
		this.setBlock(world, i + 3, j + 1, k + 3, Blocks.chest, 4);
		world.setBlockMetadataWithNotify(i + 3, j + 1, k + 3, 4, 2);
		this.setBlock(world, i + 3, j + 1, k + 4, Blocks.chest, 4);
		world.setBlockMetadataWithNotify(i + 3, j + 1, k + 4, 4, 2);
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

		return true;
	}
}