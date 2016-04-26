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
		this.setBlock(world, i + 1, j + 0, k + 0, StarWarsMod.blockTempleStoneStairsFancy, 0);
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
		NBTTagCompound tag0 = new NBTTagCompound();
		tag0.setString("id", "teBasket");
		tag0.setInteger("x", 3);
		tag0.setInteger("y", 0);
		tag0.setInteger("z", 6);
		world.getTileEntity(i + 3, j + 0, k + 6).readFromNBT(tag0);

		NBTTagCompound tag1 = new NBTTagCompound();
		tag1.setInteger("color", -10066177);
		tag1.setInteger("offset", -20);
		tag1.setInteger("sidelength", 64);
		tag1.setString("id", "teHoloTableSmall");
		tag1.setInteger("x", 1);
		tag1.setInteger("y", 0);
		tag1.setInteger("z", 4);
		world.getTileEntity(i + 1, j + 0, k + 4).readFromNBT(tag1);

		NBTTagCompound tag2 = new NBTTagCompound();
		tag2.setString("id", "teFieldEmitter");
		tag2.setInteger("x", 2);
		tag2.setInteger("y", 0);
		tag2.setInteger("z", 4);
		world.getTileEntity(i + 2, j + 0, k + 4).readFromNBT(tag2);

		NBTTagCompound tag3 = new NBTTagCompound();
		tag3.setString("id", "teHangingBucket");
		tag3.setInteger("x", 4);
		tag3.setInteger("y", 0);
		tag3.setInteger("z", 6);
		world.getTileEntity(i + 4, j + 0, k + 6).readFromNBT(tag3);

		NBTTagCompound tag4 = new NBTTagCompound();
		tag4.setString("id", "teHangingCauldron");
		tag4.setInteger("x", 5);
		tag4.setInteger("y", 0);
		tag4.setInteger("z", 6);
		world.getTileEntity(i + 5, j + 0, k + 6).readFromNBT(tag4);

		NBTTagCompound tag5 = new NBTTagCompound();
		tag5.setInteger("color", -10066177);
		tag5.setInteger("offset", -20);
		tag5.setInteger("sidelength", 128);
		tag5.setString("id", "teHoloTableMedium");
		tag5.setInteger("x", 0);
		tag5.setInteger("y", 0);
		tag5.setInteger("z", 4);
		world.getTileEntity(i + 0, j + 0, k + 4).readFromNBT(tag5);

		NBTTagCompound tag6 = new NBTTagCompound();
		tag6.setString("id", "teTatooineTable");
		tag6.setInteger("x", 4);
		tag6.setInteger("y", 0);
		tag6.setInteger("z", 7);
		world.getTileEntity(i + 4, j + 0, k + 7).readFromNBT(tag6);

		NBTTagCompound tag7 = new NBTTagCompound();
		tag7.setString("id", "teMudTable");
		tag7.setInteger("x", 7);
		tag7.setInteger("y", 0);
		tag7.setInteger("z", 6);
		world.getTileEntity(i + 7, j + 0, k + 6).readFromNBT(tag7);

		NBTTagCompound tag8 = new NBTTagCompound();
		tag8.setInteger("color", -10066177);
		tag8.setInteger("offset", -20);
		tag8.setInteger("sidelength", 256);
		tag8.setString("id", "teHoloTableWar");
		tag8.setInteger("x", 7);
		tag8.setInteger("y", 0);
		tag8.setInteger("z", 3);
		world.getTileEntity(i + 7, j + 0, k + 3).readFromNBT(tag8);

		NBTTagCompound tag9 = new NBTTagCompound();
		tag9.setInteger("color", -10066177);
		tag9.setInteger("offset", -20);
		tag9.setInteger("sidelength", 192);
		tag9.setString("id", "teHoloTableLarge");
		tag9.setInteger("x", 8);
		tag9.setInteger("y", 0);
		tag9.setInteger("z", 3);
		world.getTileEntity(i + 8, j + 0, k + 3).readFromNBT(tag9);

		NBTTagCompound tag10 = new NBTTagCompound();
		NBTTagCompound tag10_nest = new NBTTagCompound();
		tag10_nest.setShort("id", 4174);
		tag10_nest.setByte("Count", 7);
		tag10_nest.setShort("Damage", 0);
		tag10.setTag("droplets", tag10_nest)
		tag10.setInteger("progress", 505);
		tag10.setShort("facing", 0);
		tag10.setString("id", "teMoistureVaporator");
		tag10.setInteger("x", 8);
		tag10.setInteger("y", 0);
		tag10.setInteger("z", 8);
		world.getTileEntity(i + 8, j + 0, k + 8).readFromNBT(tag10);

		return true;
	}

}
