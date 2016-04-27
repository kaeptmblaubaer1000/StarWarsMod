package com.parzivail.test;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;
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
		NBTTagCompound tag0 = new NBTTagCompound();
		NBTTagList tag0_list = new NBTTagList();
		NBTTagCompound tag0_listItem0 = new NBTTagCompound();
		tag0_listItem0.setByte("Slot", (byte)0);
		tag0_listItem0.setShort("id", (short)1);
		tag0_listItem0.setByte("Count", (byte)1);
		tag0_listItem0.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem0);
		NBTTagCompound tag0_listItem1 = new NBTTagCompound();
		tag0_listItem1.setByte("Slot", (byte)4);
		tag0_listItem1.setShort("id", (short)295);
		tag0_listItem1.setByte("Count", (byte)5);
		tag0_listItem1.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem1);
		NBTTagCompound tag0_listItem2 = new NBTTagCompound();
		tag0_listItem2.setByte("Slot", (byte)8);
		tag0_listItem2.setShort("id", (short)1);
		tag0_listItem2.setByte("Count", (byte)1);
		tag0_listItem2.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem2);
		NBTTagCompound tag0_listItem3 = new NBTTagCompound();
		tag0_listItem3.setByte("Slot", (byte)11);
		tag0_listItem3.setShort("id", (short)295);
		tag0_listItem3.setByte("Count", (byte)5);
		tag0_listItem3.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem3);
		NBTTagCompound tag0_listItem4 = new NBTTagCompound();
		tag0_listItem4.setByte("Slot", (byte)12);
		tag0_listItem4.setShort("id", (short)295);
		tag0_listItem4.setByte("Count", (byte)5);
		tag0_listItem4.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem4);
		NBTTagCompound tag0_listItem5 = new NBTTagCompound();
		tag0_listItem5.setByte("Slot", (byte)13);
		tag0_listItem5.setShort("id", (short)295);
		tag0_listItem5.setByte("Count", (byte)5);
		tag0_listItem5.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem5);
		NBTTagCompound tag0_listItem6 = new NBTTagCompound();
		tag0_listItem6.setByte("Slot", (byte)14);
		tag0_listItem6.setShort("id", (short)295);
		tag0_listItem6.setByte("Count", (byte)5);
		tag0_listItem6.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem6);
		NBTTagCompound tag0_listItem7 = new NBTTagCompound();
		tag0_listItem7.setByte("Slot", (byte)15);
		tag0_listItem7.setShort("id", (short)295);
		tag0_listItem7.setByte("Count", (byte)5);
		tag0_listItem7.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem7);
		NBTTagCompound tag0_listItem8 = new NBTTagCompound();
		tag0_listItem8.setByte("Slot", (byte)18);
		tag0_listItem8.setShort("id", (short)295);
		tag0_listItem8.setByte("Count", (byte)5);
		tag0_listItem8.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem8);
		NBTTagCompound tag0_listItem9 = new NBTTagCompound();
		tag0_listItem9.setByte("Slot", (byte)19);
		tag0_listItem9.setShort("id", (short)295);
		tag0_listItem9.setByte("Count", (byte)5);
		tag0_listItem9.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem9);
		NBTTagCompound tag0_listItem10 = new NBTTagCompound();
		tag0_listItem10.setByte("Slot", (byte)20);
		tag0_listItem10.setShort("id", (short)295);
		tag0_listItem10.setByte("Count", (byte)5);
		tag0_listItem10.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem10);
		NBTTagCompound tag0_listItem11 = new NBTTagCompound();
		tag0_listItem11.setByte("Slot", (byte)22);
		tag0_listItem11.setShort("id", (short)30);
		tag0_listItem11.setByte("Count", (byte)1);
		tag0_listItem11.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem11);
		NBTTagCompound tag0_listItem12 = new NBTTagCompound();
		tag0_listItem12.setByte("Slot", (byte)24);
		tag0_listItem12.setShort("id", (short)295);
		tag0_listItem12.setByte("Count", (byte)5);
		tag0_listItem12.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem12);
		NBTTagCompound tag0_listItem13 = new NBTTagCompound();
		tag0_listItem13.setByte("Slot", (byte)25);
		tag0_listItem13.setShort("id", (short)295);
		tag0_listItem13.setByte("Count", (byte)5);
		tag0_listItem13.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem13);
		NBTTagCompound tag0_listItem14 = new NBTTagCompound();
		tag0_listItem14.setByte("Slot", (byte)26);
		tag0_listItem14.setShort("id", (short)295);
		tag0_listItem14.setByte("Count", (byte)5);
		tag0_listItem14.setShort("Damage", (short)0);

		tag0_list.appendTag(tag0_listItem14);
		tag0.setTag("Items", tag0_list);
		tag0.setString("id", "Chest");
		tag0.setInteger("x", 2);
		tag0.setInteger("y", 1);
		tag0.setInteger("z", 2);
		world.getTileEntity(i + 2, j + 1, k + 2).readFromNBT(tag0);

		NBTTagCompound tag1 = new NBTTagCompound();
		NBTTagList tag1_list = new NBTTagList();
		NBTTagCompound tag1_listItem0 = new NBTTagCompound();
		tag1_listItem0.setByte("Slot", (byte)0);
		tag1_listItem0.setShort("id", (short)295);
		tag1_listItem0.setByte("Count", (byte)5);
		tag1_listItem0.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem0);
		NBTTagCompound tag1_listItem1 = new NBTTagCompound();
		tag1_listItem1.setByte("Slot", (byte)1);
		tag1_listItem1.setShort("id", (short)295);
		tag1_listItem1.setByte("Count", (byte)5);
		tag1_listItem1.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem1);
		NBTTagCompound tag1_listItem2 = new NBTTagCompound();
		tag1_listItem2.setByte("Slot", (byte)2);
		tag1_listItem2.setShort("id", (short)295);
		tag1_listItem2.setByte("Count", (byte)5);
		tag1_listItem2.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem2);
		NBTTagCompound tag1_listItem3 = new NBTTagCompound();
		tag1_listItem3.setByte("Slot", (byte)4);
		tag1_listItem3.setShort("id", (short)30);
		tag1_listItem3.setByte("Count", (byte)1);
		tag1_listItem3.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem3);
		NBTTagCompound tag1_listItem4 = new NBTTagCompound();
		tag1_listItem4.setByte("Slot", (byte)6);
		tag1_listItem4.setShort("id", (short)295);
		tag1_listItem4.setByte("Count", (byte)5);
		tag1_listItem4.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem4);
		NBTTagCompound tag1_listItem5 = new NBTTagCompound();
		tag1_listItem5.setByte("Slot", (byte)7);
		tag1_listItem5.setShort("id", (short)295);
		tag1_listItem5.setByte("Count", (byte)5);
		tag1_listItem5.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem5);
		NBTTagCompound tag1_listItem6 = new NBTTagCompound();
		tag1_listItem6.setByte("Slot", (byte)8);
		tag1_listItem6.setShort("id", (short)295);
		tag1_listItem6.setByte("Count", (byte)5);
		tag1_listItem6.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem6);
		NBTTagCompound tag1_listItem7 = new NBTTagCompound();
		tag1_listItem7.setByte("Slot", (byte)11);
		tag1_listItem7.setShort("id", (short)295);
		tag1_listItem7.setByte("Count", (byte)5);
		tag1_listItem7.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem7);
		NBTTagCompound tag1_listItem8 = new NBTTagCompound();
		tag1_listItem8.setByte("Slot", (byte)12);
		tag1_listItem8.setShort("id", (short)295);
		tag1_listItem8.setByte("Count", (byte)5);
		tag1_listItem8.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem8);
		NBTTagCompound tag1_listItem9 = new NBTTagCompound();
		tag1_listItem9.setByte("Slot", (byte)13);
		tag1_listItem9.setShort("id", (short)295);
		tag1_listItem9.setByte("Count", (byte)5);
		tag1_listItem9.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem9);
		NBTTagCompound tag1_listItem10 = new NBTTagCompound();
		tag1_listItem10.setByte("Slot", (byte)14);
		tag1_listItem10.setShort("id", (short)295);
		tag1_listItem10.setByte("Count", (byte)5);
		tag1_listItem10.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem10);
		NBTTagCompound tag1_listItem11 = new NBTTagCompound();
		tag1_listItem11.setByte("Slot", (byte)15);
		tag1_listItem11.setShort("id", (short)295);
		tag1_listItem11.setByte("Count", (byte)5);
		tag1_listItem11.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem11);
		NBTTagCompound tag1_listItem12 = new NBTTagCompound();
		tag1_listItem12.setByte("Slot", (byte)18);
		tag1_listItem12.setShort("id", (short)1);
		tag1_listItem12.setByte("Count", (byte)1);
		tag1_listItem12.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem12);
		NBTTagCompound tag1_listItem13 = new NBTTagCompound();
		tag1_listItem13.setByte("Slot", (byte)22);
		tag1_listItem13.setShort("id", (short)295);
		tag1_listItem13.setByte("Count", (byte)5);
		tag1_listItem13.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem13);
		NBTTagCompound tag1_listItem14 = new NBTTagCompound();
		tag1_listItem14.setByte("Slot", (byte)26);
		tag1_listItem14.setShort("id", (short)1);
		tag1_listItem14.setByte("Count", (byte)1);
		tag1_listItem14.setShort("Damage", (short)0);

		tag1_list.appendTag(tag1_listItem14);
		tag1.setTag("Items", tag1_list);
		tag1.setString("id", "Chest");
		tag1.setInteger("x", 2);
		tag1.setInteger("y", 1);
		tag1.setInteger("z", 3);
		world.getTileEntity(i + 2, j + 1, k + 3).readFromNBT(tag1);

		return true;
	}

}
