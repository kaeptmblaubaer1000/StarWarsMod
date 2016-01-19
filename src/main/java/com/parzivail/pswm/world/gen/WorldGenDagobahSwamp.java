package com.parzivail.pswm.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenDagobahSwamp extends WorldGenAbstractTree
{
	public WorldGenDagobahSwamp()
    {
        super(false);
    }

    public boolean generate(World world, Random random, int x, int y, int z, int height, int variation)
    {
        int l;

        for (l = random.nextInt(variation) + height; world.getBlock(x, y - 1, z).getMaterial() == Material.water; --y)
        {
            ;
        }

        boolean flag = true;

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
                    b0 = 3;
                }

                for (j1 = x - b0; j1 <= x + b0 && flag; ++j1)
                {
                    for (k1 = z - b0; k1 <= z + b0 && flag; ++k1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            Block block = world.getBlock(j1, i1, k1);

                            if (!(block.isAir(world, j1, i1, k1) || block.isLeaves(world, j1, i1, k1)))
                            {
                                if (block != Blocks.water && block != Blocks.flowing_water)
                                {
                                    flag = false;
                                }
                                else if (i1 > y)
                                {
                                    flag = false;
                                }
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block1 = world.getBlock(x, y - 1, z);

                boolean isSoil = block1.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockSapling)Blocks.sapling);
                if (isSoil && y < 256 - l - 1)
                {
                    block1.onPlantGrow(world, x, y - 1, z, x, y, z);
                    int l1;
                    int k2;
                    int l2;

                    for (k2 = y - 3 + l; k2 <= y + l; ++k2)
                    {
                        j1 = k2 - (y + l);
                        k1 = 2 - j1 / 2;

                        for (l2 = x - k1; l2 <= x + k1; ++l2)
                        {
                            l1 = l2 - x;

                            for (int i2 = z - k1; i2 <= z + k1; ++i2)
                            {
                                int j2 = i2 - z;

                                if ((Math.abs(l1) != k1 || Math.abs(j2) != k1 || random.nextInt(2) != 0 && j1 != 0) && world.getBlock(l2, k2, i2).canBeReplacedByLeaves(world, l2, k2, i2))
                                {
                                    this.func_150515_a(world, l2, k2, i2, Blocks.leaves);
                                }
                            }
                        }
                    }

                    for (k2 = 0; k2 < l; ++k2)
                    {
                        Block block2 = world.getBlock(x, y + k2, z);

                        if (block2.isAir(world, x, y + k2, z) || block2.isLeaves(world, x, y + k2, z) || block2 == Blocks.flowing_water || block2 == Blocks.water)
                        {
                            this.func_150515_a(world, x, y + k2, z, Blocks.log);
                        }
                    }

                    for (k2 = y - 3 + l; k2 <= y + l; ++k2)
                    {
                        j1 = k2 - (y + l);
                        k1 = 2 - j1 / 2;

                        for (l2 = x - k1; l2 <= x + k1; ++l2)
                        {
                            for (l1 = z - k1; l1 <= z + k1; ++l1)
                            {
                                if (world.getBlock(l2, k2, l1).isLeaves(world, l2, k2, l1))
                                {
                                    if (random.nextInt(4) == 0 && world.getBlock(l2 - 1, k2, l1).isAir(world, l2 - 1, k2, l1))
                                    {
                                        this.generateVines(world, l2 - 1, k2, l1, 8);
                                    }

                                    if (random.nextInt(4) == 0 && world.getBlock(l2 + 1, k2, l1).isAir(world, l2 + 1, k2, l1))
                                    {
                                        this.generateVines(world, l2 + 1, k2, l1, 2);
                                    }

                                    if (random.nextInt(4) == 0 && world.getBlock(l2, k2, l1 - 1).isAir(world, l2, k2, l1 - 1))
                                    {
                                        this.generateVines(world, l2, k2, l1 - 1, 1);
                                    }

                                    if (random.nextInt(4) == 0 && world.getBlock(l2, k2, l1 + 1).isAir(world, l2, k2, l1 + 1))
                                    {
                                        this.generateVines(world, l2, k2, l1 + 1, 4);
                                    }
                                }
                            }
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

    /**
     * Generates vines at the given position until it hits a block.
     */
    private void generateVines(World p_76536_1_, int p_76536_2_, int p_76536_3_, int p_76536_4_, int p_76536_5_)
    {
        this.setBlockAndNotifyAdequately(p_76536_1_, p_76536_2_, p_76536_3_, p_76536_4_, Blocks.vine, p_76536_5_);
        int i1 = 4;

        while (true)
        {
            --p_76536_3_;

            if (!(p_76536_1_.getBlock(p_76536_2_, p_76536_3_, p_76536_4_).isAir(p_76536_1_, p_76536_2_, p_76536_3_, p_76536_4_)) || i1 <= 0)
            {
                return;
            }

            this.setBlockAndNotifyAdequately(p_76536_1_, p_76536_2_, p_76536_3_, p_76536_4_, Blocks.vine, p_76536_5_);
            --i1;
        }
    }

	@Override
	public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
	{
		return this.generate(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_3_, 5, 4);
	}
}
