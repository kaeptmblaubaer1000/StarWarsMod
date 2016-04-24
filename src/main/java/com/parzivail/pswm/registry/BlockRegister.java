package com.parzivail.pswm.registry;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.blocks.BlockBactaTank;
import com.parzivail.pswm.blocks.BlockBasket;
import com.parzivail.pswm.blocks.BlockDagobahMud;
import com.parzivail.pswm.blocks.BlockDeathStar;
import com.parzivail.pswm.blocks.BlockDeathStarDoor;
import com.parzivail.pswm.blocks.BlockDeathStarGlass;
import com.parzivail.pswm.blocks.BlockDeathStarLight;
import com.parzivail.pswm.blocks.BlockEndorBaseWall;
import com.parzivail.pswm.blocks.BlockEndorBaseWallStairs;
import com.parzivail.pswm.blocks.BlockFieldEmitter;
import com.parzivail.pswm.blocks.BlockHangingBucket;
import com.parzivail.pswm.blocks.BlockHangingCauldron;
import com.parzivail.pswm.blocks.BlockHolotable;
import com.parzivail.pswm.blocks.BlockMV;
import com.parzivail.pswm.blocks.BlockMudStairs;
import com.parzivail.pswm.blocks.BlockMudTable;
import com.parzivail.pswm.blocks.BlockSpaceLamp;
import com.parzivail.pswm.blocks.BlockTatooineSand;
import com.parzivail.pswm.blocks.BlockTatooineSandstone;
import com.parzivail.pswm.blocks.BlockTatooineTable;
import com.parzivail.pswm.blocks.BlockTempleStone;
import com.parzivail.pswm.blocks.BlockTempleStoneSlab;
import com.parzivail.pswm.blocks.BlockTitaniumChromium;
import com.parzivail.pswm.blocks.ore.BlockBeneOre;
import com.parzivail.pswm.blocks.ore.BlockChromiumOre;
import com.parzivail.pswm.blocks.ore.BlockCortosisOre;
import com.parzivail.pswm.blocks.ore.BlockDolomiteOre;
import com.parzivail.pswm.blocks.ore.BlockExoniumOre;
import com.parzivail.pswm.blocks.ore.BlockHeliciteOre;
import com.parzivail.pswm.blocks.ore.BlockIoniteOre;
import com.parzivail.pswm.blocks.ore.BlockKeleriumOre;
import com.parzivail.pswm.blocks.ore.BlockRubindumOre;
import com.parzivail.pswm.blocks.ore.BlockTitaniumOre;
import com.parzivail.pswm.items.ItemDeathStarBlock;
import com.parzivail.pswm.items.ItemDeathStarLight;
import com.parzivail.pswm.items.ItemEndorBaseWall;
import com.parzivail.pswm.items.ItemHolotableBlock;
import com.parzivail.pswm.items.ItemTatooineSand;
import com.parzivail.pswm.items.ItemTatooineSandstone;
import com.parzivail.pswm.items.ItemTempleStoneBlock;
import com.parzivail.pswm.items.ItemTempleStoneSlabBlock;
import com.parzivail.pswm.tileentities.TileEntityBactaTank;
import com.parzivail.pswm.tileentities.TileEntityBasket;
import com.parzivail.pswm.tileentities.TileEntityDeathStarDoor;
import com.parzivail.pswm.tileentities.TileEntityFieldEmitter;
import com.parzivail.pswm.tileentities.TileEntityHangingBucket;
import com.parzivail.pswm.tileentities.TileEntityHangingCauldron;
import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;
import com.parzivail.pswm.tileentities.TileEntityHoloTableLarge;
import com.parzivail.pswm.tileentities.TileEntityHoloTableMedium;
import com.parzivail.pswm.tileentities.TileEntityHoloTableWar;
import com.parzivail.pswm.tileentities.TileEntityMV;
import com.parzivail.pswm.tileentities.TileEntityMudTable;
import com.parzivail.pswm.tileentities.TileEntityTatooineTable;
import com.parzivail.util.ui.Lumberjack;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister
{
	public static void registerAll()
	{
		if (Resources.IS_DEV_ENVIRONVENT)
		{
			StarWarsMod.blockHoloTable = new BlockHolotable();
			GameRegistry.registerBlock(StarWarsMod.blockHoloTable, ItemHolotableBlock.class, "holoTable");
			GameRegistry.registerTileEntity(TileEntityHoloTableBase.class, "teHoloTableSmall");
			GameRegistry.registerTileEntity(TileEntityHoloTableMedium.class, "teHoloTableMedium");
			GameRegistry.registerTileEntity(TileEntityHoloTableLarge.class, "teHoloTableLarge");
			GameRegistry.registerTileEntity(TileEntityHoloTableWar.class, "teHoloTableWar");
		}

		StarWarsMod.blockMV = new BlockMV();
		GameRegistry.registerBlock(StarWarsMod.blockMV, "moistureVaporator");
		GameRegistry.registerTileEntity(TileEntityMV.class, "teMoistureVaporator");

		StarWarsMod.blockFieldEmitter = new BlockFieldEmitter();
		GameRegistry.registerBlock(StarWarsMod.blockFieldEmitter, "fieldEmitter");
		GameRegistry.registerTileEntity(TileEntityFieldEmitter.class, "teFieldEmitter");

		StarWarsMod.blockDeathStarDoor = new BlockDeathStarDoor();
		GameRegistry.registerBlock(StarWarsMod.blockDeathStarDoor, "deathStarDoor");
		GameRegistry.registerTileEntity(TileEntityDeathStarDoor.class, "teDeathStarDoor");

		StarWarsMod.blockHangingCauldron = new BlockHangingCauldron();
		GameRegistry.registerBlock(StarWarsMod.blockHangingCauldron, "hangingCauldron");
		GameRegistry.registerTileEntity(TileEntityHangingCauldron.class, "teHangingCauldron");

		StarWarsMod.blockHangingBucket = new BlockHangingBucket();
		GameRegistry.registerBlock(StarWarsMod.blockHangingBucket, "hangingBucket");
		GameRegistry.registerTileEntity(TileEntityHangingBucket.class, "teHangingBucket");

		StarWarsMod.blockBasket = new BlockBasket();
		GameRegistry.registerBlock(StarWarsMod.blockBasket, "basket");
		GameRegistry.registerTileEntity(TileEntityBasket.class, "teBasket");

		StarWarsMod.blockBactaTank = new BlockBactaTank();
		GameRegistry.registerBlock(StarWarsMod.blockBactaTank, "bactaTank");
		GameRegistry.registerTileEntity(TileEntityBactaTank.class, "teBactaTank");

		StarWarsMod.blockCortosisOre = new BlockCortosisOre();
		GameRegistry.registerBlock(StarWarsMod.blockCortosisOre, "blockCortosisOre");

		StarWarsMod.blockDolomiteOre = new BlockDolomiteOre();
		GameRegistry.registerBlock(StarWarsMod.blockDolomiteOre, "blockDolomiteOre");

		StarWarsMod.blockExoniumOre = new BlockExoniumOre();
		GameRegistry.registerBlock(StarWarsMod.blockExoniumOre, "blockExoniumOre");

		StarWarsMod.blockHeliciteOre = new BlockHeliciteOre();
		GameRegistry.registerBlock(StarWarsMod.blockHeliciteOre, "blockHeliciteOre");

		StarWarsMod.blockBeneOre = new BlockBeneOre();
		GameRegistry.registerBlock(StarWarsMod.blockBeneOre, "blockBeneOre");

		StarWarsMod.blockTempleStone = new BlockTempleStone(false);
		GameRegistry.registerBlock(StarWarsMod.blockTempleStone, ItemTempleStoneBlock.class, "blockTempleStone");

		StarWarsMod.blockTempleStoneSlab = new BlockTempleStoneSlab(false, false);
		GameRegistry.registerBlock(StarWarsMod.blockTempleStoneSlab, ItemTempleStoneSlabBlock.class, "blockTempleStoneSlab");

		StarWarsMod.blockTempleStoneLit = new BlockTempleStone(true);
		GameRegistry.registerBlock(StarWarsMod.blockTempleStoneLit, ItemTempleStoneBlock.class, "blockTempleStoneLit");

		StarWarsMod.blockTempleStoneSlabLit = new BlockTempleStoneSlab(false, true);
		GameRegistry.registerBlock(StarWarsMod.blockTempleStoneSlabLit, ItemTempleStoneSlabBlock.class, "blockTempleStoneSlabLit");

		StarWarsMod.blockIoniteOre = new BlockIoniteOre();
		GameRegistry.registerBlock(StarWarsMod.blockIoniteOre, "blockIoniteOre");

		StarWarsMod.blockKeleriumOre = new BlockKeleriumOre();
		GameRegistry.registerBlock(StarWarsMod.blockKeleriumOre, "blockKeleriumOre");

		StarWarsMod.blockRubindumOre = new BlockRubindumOre();
		GameRegistry.registerBlock(StarWarsMod.blockRubindumOre, "blockRubindumOre");

		StarWarsMod.blockChromiumOre = new BlockChromiumOre();
		GameRegistry.registerBlock(StarWarsMod.blockChromiumOre, "chromiumOre");

		StarWarsMod.blockTitaniumOre = new BlockTitaniumOre();
		GameRegistry.registerBlock(StarWarsMod.blockTitaniumOre, "titaniumOre");

		StarWarsMod.blockTitaniumChromiumBlock = new BlockTitaniumChromium();
		GameRegistry.registerBlock(StarWarsMod.blockTitaniumChromiumBlock, "titaniumChromiumBlock");

		StarWarsMod.blockDagobahMud = new BlockDagobahMud();
		GameRegistry.registerBlock(StarWarsMod.blockDagobahMud, "dagobahMud");

		StarWarsMod.blockEndorBaseWall = new BlockEndorBaseWall();
		GameRegistry.registerBlock(StarWarsMod.blockEndorBaseWall, ItemEndorBaseWall.class, "endorBaseWall");

		StarWarsMod.blockEndorBaseWallStairs = new BlockEndorBaseWallStairs();
		GameRegistry.registerBlock(StarWarsMod.blockEndorBaseWallStairs, "endorBaseWallStairs");

		StarWarsMod.blockDeathStarBlock = new BlockDeathStar();
		GameRegistry.registerBlock(StarWarsMod.blockDeathStarBlock, ItemDeathStarBlock.class, "deathStarBlock");

		StarWarsMod.blockDeathStarLight = new BlockDeathStarLight();
		GameRegistry.registerBlock(StarWarsMod.blockDeathStarLight, ItemDeathStarLight.class, "deathStarLight");

		StarWarsMod.blockDeathStarGlass = new BlockDeathStarGlass();
		GameRegistry.registerBlock(StarWarsMod.blockDeathStarGlass, "deathStarGlass");

		StarWarsMod.blockMudStairs = new BlockMudStairs();
		GameRegistry.registerBlock(StarWarsMod.blockMudStairs, "mudStairs");

		StarWarsMod.blockTatooineSand = new BlockTatooineSand();
		GameRegistry.registerBlock(StarWarsMod.blockTatooineSand, ItemTatooineSand.class, "tatooineSand");

		StarWarsMod.blockTatooineSandstone = new BlockTatooineSandstone();
		GameRegistry.registerBlock(StarWarsMod.blockTatooineSandstone, ItemTatooineSandstone.class, "tatooineSandstone");

		StarWarsMod.blockSpaceLamp = new BlockSpaceLamp();
		GameRegistry.registerBlock(StarWarsMod.blockSpaceLamp, "spaceLamp");

		StarWarsMod.blockTable = new BlockTatooineTable();
		GameRegistry.registerBlock(StarWarsMod.blockTable, "table");
		GameRegistry.registerTileEntity(TileEntityTatooineTable.class, "teTatooineTable");

		StarWarsMod.blockTable2 = new BlockMudTable();
		GameRegistry.registerBlock(StarWarsMod.blockTable2, "mudTable");
		GameRegistry.registerTileEntity(TileEntityMudTable.class, "teMudTable");
		Lumberjack.info("Blocks, reporting for duty!");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\BlockRegister.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */