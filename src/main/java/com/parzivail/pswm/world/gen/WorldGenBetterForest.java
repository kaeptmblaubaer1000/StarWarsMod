package com.parzivail.pswm.world.gen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class WorldGenBetterForest extends WorldGenAbstractTree
{
	private static final String __OBFID = "CL_00000401";

	public WorldGenBetterForest()
	{
		super(true);
	}

	public boolean generate(World world, Random random, int x, int y, int z, int height, int variation, int metadata)
	{
		int l = height + random.nextInt(variation);

		boolean canGrow = true;

		if (y >= 1 && y + l + 1 <= 256)
		{
			int j1;
			int k1;

			for (int i1 = y; i1 <= y + 1 + l; ++i1)
			{
				byte b0 = 1;

				if (i1 == y)
				{
					b0 = 0;
				}

				if (i1 >= y + 1 + l - 2)
				{
					b0 = 2;
				}

				for (j1 = x - b0; j1 <= x + b0 && canGrow; ++j1)
				{
					for (k1 = z - b0; k1 <= z + b0 && canGrow; ++k1)
					{
						if (i1 >= 0 && i1 < 256)
						{
							Block block = world.getBlock(j1, i1, k1);

							if (!this.isReplaceable(world, j1, i1, k1))
							{
								canGrow = false;
							}
						}
						else
						{
							canGrow = false;
						}
					}
				}
			}

			if (!canGrow)
			{
				return false;
			}
			else
			{
				Block block2 = world.getBlock(x, y - 1, z);

				boolean isSoil = block2.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockSapling)Blocks.sapling);
				if (isSoil && y < 256 - l - 1)
				{
					block2.onPlantGrow(world, x, y - 1, z, x, y, z);
					int k2;

					for (k2 = y - 3 + l; k2 <= y + l; ++k2)
					{
						j1 = k2 - (y + l);
						k1 = 1 - j1 / 2;

						for (int l2 = x - k1; l2 <= x + k1; ++l2)
						{
							int l1 = l2 - x;

							for (int i2 = z - k1; i2 <= z + k1; ++i2)
							{
								int j2 = i2 - z;

								if (Math.abs(l1) != k1 || Math.abs(j2) != k1 || random.nextInt(2) != 0 && j1 != 0)
								{
									Block block1 = world.getBlock(l2, k2, i2);

									if (block1.isAir(world, l2, k2, i2) || block1.isLeaves(world, l2, k2, i2))
									{
										this.setBlockAndNotifyAdequately(world, l2, k2, i2, Blocks.leaves, metadata);
									}
								}
							}
						}
					}

					for (k2 = 0; k2 < l; ++k2)
					{
						Block block3 = world.getBlock(x, y + k2, z);

						if (block3.isAir(world, x, y + k2, z) || block3.isLeaves(world, x, y + k2, z))
						{
							this.setBlockAndNotifyAdequately(world, x, y + k2, z, Blocks.log, metadata);
						}
					}

					return true;
				}
				else
				{
					return false;
				}
			}
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		return this.generate(world, random, x, y, z, 5, 0, 0);
	}
}