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

public class WorldGenTest extends WorldGenerator implements IWorldGenerator
{
	public WorldGenTest() { }

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
