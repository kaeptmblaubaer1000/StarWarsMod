package com.parzivail.test;

import com.parzivail.util.world.WorldUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;


public class WorldGenWorldGenTest
{
	public WorldGenWorldGenTest() { }

	public void b(World world, int x, int y, int z, Block block, int metadata)
	{
		WorldUtils.setBlock(world, x, y, z, block, metadata, 1 | 2);
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
		this.b(world, i + 0, j + 0, k + 3, Blocks.grass, 0);
		this.b(world, i + 0, j + 0, k + 4, Blocks.grass, 0);
		this.b(world, i + 0, j + 0, k + 5, Blocks.grass, 0);
		this.b(world, i + 0, j + 1, k + 0, Blocks.air, 0);
		this.b(world, i + 0, j + 1, k + 1, Blocks.air, 0);
		this.b(world, i + 0, j + 1, k + 2, Blocks.air, 0);
		this.b(world, i + 0, j + 1, k + 3, Blocks.air, 0);
		this.b(world, i + 0, j + 1, k + 4, Blocks.air, 0);
		this.b(world, i + 0, j + 1, k + 5, Blocks.air, 0);
		this.b(world, i + 1, j + 0, k + 0, Blocks.grass, 0);
		this.b(world, i + 1, j + 0, k + 1, Blocks.grass, 0);
		this.b(world, i + 1, j + 0, k + 2, Blocks.grass, 0);
		this.b(world, i + 1, j + 0, k + 3, Blocks.grass, 0);
		this.b(world, i + 1, j + 0, k + 4, Blocks.grass, 0);
		this.b(world, i + 1, j + 0, k + 5, Blocks.grass, 0);
		this.b(world, i + 1, j + 1, k + 0, Blocks.air, 0);
		this.b(world, i + 1, j + 1, k + 1, Blocks.air, 0);
		this.b(world, i + 1, j + 1, k + 2, Blocks.air, 0);
		this.b(world, i + 1, j + 1, k + 3, Blocks.air, 0);
		this.b(world, i + 1, j + 1, k + 4, Blocks.air, 0);
		this.b(world, i + 1, j + 1, k + 5, Blocks.air, 0);
		this.b(world, i + 2, j + 0, k + 0, Blocks.grass, 0);
		this.b(world, i + 2, j + 0, k + 1, Blocks.grass, 0);
		this.b(world, i + 2, j + 0, k + 2, Blocks.grass, 0);
		this.b(world, i + 2, j + 0, k + 3, Blocks.grass, 0);
		this.b(world, i + 2, j + 0, k + 4, Blocks.grass, 0);
		this.b(world, i + 2, j + 0, k + 5, Blocks.grass, 0);
		this.b(world, i + 2, j + 1, k + 0, Blocks.air, 0);
		this.b(world, i + 2, j + 1, k + 1, Blocks.air, 0);
		this.b(world, i + 2, j + 1, k + 2, Blocks.chest, 0);
		this.m(world, i + 2, j + 1, k + 2, 4);
		this.b(world, i + 2, j + 1, k + 3, Blocks.chest, 0);
		this.m(world, i + 2, j + 1, k + 3, 4);
		this.b(world, i + 2, j + 1, k + 4, Blocks.air, 0);
		this.b(world, i + 2, j + 1, k + 5, Blocks.air, 0);
		this.b(world, i + 3, j + 0, k + 0, Blocks.grass, 0);
		this.b(world, i + 3, j + 0, k + 1, Blocks.grass, 0);
		this.b(world, i + 3, j + 0, k + 2, Blocks.grass, 0);
		this.b(world, i + 3, j + 0, k + 3, Blocks.grass, 0);
		this.b(world, i + 3, j + 0, k + 4, Blocks.grass, 0);
		this.b(world, i + 3, j + 0, k + 5, Blocks.grass, 0);
		this.b(world, i + 3, j + 1, k + 0, Blocks.air, 0);
		this.b(world, i + 3, j + 1, k + 1, Blocks.air, 0);
		this.b(world, i + 3, j + 1, k + 2, Blocks.air, 0);
		this.b(world, i + 3, j + 1, k + 3, Blocks.air, 0);
		this.b(world, i + 3, j + 1, k + 4, Blocks.air, 0);
		this.b(world, i + 3, j + 1, k + 5, Blocks.air, 0);
		this.b(world, i + 4, j + 0, k + 0, Blocks.grass, 0);
		this.b(world, i + 4, j + 0, k + 1, Blocks.grass, 0);
		this.b(world, i + 4, j + 0, k + 2, Blocks.grass, 0);
		this.b(world, i + 4, j + 0, k + 3, Blocks.grass, 0);
		this.b(world, i + 4, j + 0, k + 4, Blocks.grass, 0);
		this.b(world, i + 4, j + 0, k + 5, Blocks.grass, 0);
		this.b(world, i + 4, j + 1, k + 0, Blocks.air, 0);
		this.b(world, i + 4, j + 1, k + 1, Blocks.air, 0);
		this.b(world, i + 4, j + 1, k + 2, Blocks.air, 0);
		this.b(world, i + 4, j + 1, k + 3, Blocks.air, 0);
		this.b(world, i + 4, j + 1, k + 4, Blocks.air, 0);
		this.b(world, i + 4, j + 1, k + 5, Blocks.air, 0);
		this.b(world, i + 5, j + 0, k + 0, Blocks.grass, 0);
		this.b(world, i + 5, j + 0, k + 1, Blocks.grass, 0);
		this.b(world, i + 5, j + 0, k + 2, Blocks.grass, 0);
		this.b(world, i + 5, j + 0, k + 3, Blocks.grass, 0);
		this.b(world, i + 5, j + 0, k + 4, Blocks.grass, 0);
		this.b(world, i + 5, j + 0, k + 5, Blocks.grass, 0);
		this.b(world, i + 5, j + 1, k + 0, Blocks.air, 0);
		this.b(world, i + 5, j + 1, k + 1, Blocks.air, 0);
		this.b(world, i + 5, j + 1, k + 2, Blocks.air, 0);
		this.b(world, i + 5, j + 1, k + 3, Blocks.air, 0);
		this.b(world, i + 5, j + 1, k + 4, Blocks.air, 0);
		this.b(world, i + 5, j + 1, k + 5, Blocks.air, 0);
		TileEntityChest chest0 = (TileEntityChest)world.getTileEntity(i + 2, j + 1, k + 2);
		chest0.setInventorySlotContents(0, new ItemStack(Blocks.stone, 1, 0));
		chest0.setInventorySlotContents(4, new ItemStack(Items.wheat_seeds, 5, 0));
		chest0.setInventorySlotContents(8, new ItemStack(Blocks.stone, 1, 0));
		chest0.setInventorySlotContents(11, new ItemStack(Items.wheat_seeds, 5, 0));
		chest0.setInventorySlotContents(12, new ItemStack(Items.wheat_seeds, 5, 0));
		chest0.setInventorySlotContents(13, new ItemStack(Items.wheat_seeds, 5, 0));
		chest0.setInventorySlotContents(14, new ItemStack(Items.wheat_seeds, 5, 0));
		chest0.setInventorySlotContents(15, new ItemStack(Items.wheat_seeds, 5, 0));
		chest0.setInventorySlotContents(18, new ItemStack(Items.wheat_seeds, 5, 0));
		chest0.setInventorySlotContents(19, new ItemStack(Items.wheat_seeds, 5, 0));
		chest0.setInventorySlotContents(20, new ItemStack(Items.wheat_seeds, 5, 0));
		chest0.setInventorySlotContents(22, new ItemStack(Blocks.web, 1, 0));
		chest0.setInventorySlotContents(24, new ItemStack(Items.wheat_seeds, 5, 0));
		chest0.setInventorySlotContents(25, new ItemStack(Items.wheat_seeds, 5, 0));
		chest0.setInventorySlotContents(26, new ItemStack(Items.wheat_seeds, 5, 0));

		TileEntityChest chest1 = (TileEntityChest)world.getTileEntity(i + 2, j + 1, k + 3);
		chest1.setInventorySlotContents(0, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(1, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(2, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(4, new ItemStack(Blocks.web, 1, 0));
		chest1.setInventorySlotContents(6, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(7, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(8, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(11, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(12, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(13, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(14, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(15, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(18, new ItemStack(Blocks.stone, 1, 0));
		chest1.setInventorySlotContents(22, new ItemStack(Items.wheat_seeds, 5, 0));
		chest1.setInventorySlotContents(26, new ItemStack(Blocks.stone, 1, 0));

		return true;
	}

}
