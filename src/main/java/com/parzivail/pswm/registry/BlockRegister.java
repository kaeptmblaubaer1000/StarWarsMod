package com.parzivail.pswm.registry;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.blocks.*;
import com.parzivail.pswm.blocks.npc.BlockNpcBase;
import com.parzivail.pswm.blocks.ore.*;
import com.parzivail.pswm.items.*;
import com.parzivail.pswm.tileentities.*;
import com.parzivail.util.block.BlockMultiHeight;
import com.parzivail.util.block.ItemMultiHeightBlock;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister
{
	public static void registerAll()
	{
		if (Resources.IS_DEV_ENVIRONVENT)
		{
		}

		StarWarsMod.blockMV = new BlockMV();
		GameRegistry.registerBlock(StarWarsMod.blockMV, "moistureVaporator");
		GameRegistry.registerTileEntity(TileEntityMV.class, "teMoistureVaporator");

		StarWarsMod.blockAntenna = new BlockAntenna();
		GameRegistry.registerBlock(StarWarsMod.blockAntenna, "blockAntenna");
		GameRegistry.registerTileEntity(TileEntityAntenna.class, "teAntenna");

		StarWarsMod.blockHoloTable = new BlockHolotable();
		GameRegistry.registerBlock(StarWarsMod.blockHoloTable, ItemHolotableBlock.class, "holoTable");
		GameRegistry.registerTileEntity(TileEntityHoloTableBase.class, "teHoloTableSmall");
		GameRegistry.registerTileEntity(TileEntityHoloTableMedium.class, "teHoloTableMedium");
		GameRegistry.registerTileEntity(TileEntityHoloTableLarge.class, "teHoloTableLarge");
		GameRegistry.registerTileEntity(TileEntityHoloTableWar.class, "teHoloTableWar");

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

		StarWarsMod.blockStaticNpc = new BlockNpcBase();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpc, "staticNpc");
		GameRegistry.registerTileEntity(TileEntityStaticNpc.class, "teStaticNpc");

		StarWarsMod.blockBasket = new BlockBasket();
		GameRegistry.registerBlock(StarWarsMod.blockBasket, "basket");
		GameRegistry.registerTileEntity(TileEntityBasket.class, "teBasket");

		StarWarsMod.blockHyperdrive = new BlockHyperdrive();
		GameRegistry.registerBlock(StarWarsMod.blockHyperdrive, "blockHyperdrive");
		GameRegistry.registerTileEntity(TileEntityHyperdrive.class, "teHyperdrive");

		StarWarsMod.blockBactaTank = new BlockBactaTank();
		GameRegistry.registerBlock(StarWarsMod.blockBactaTank, "bactaTank");
		GameRegistry.registerTileEntity(TileEntityBactaTank.class, "teBactaTank");

		StarWarsMod.blockTempleStoneMH = new BlockMultiHeight("templeStone");
		GameRegistry.registerBlock(StarWarsMod.blockTempleStoneMH, ItemMultiHeightBlock.class, "blockTempleStoneMH");

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

		StarWarsMod.blockTempleStoneStairs = new BlockTempleStoneStairs();
		GameRegistry.registerBlock(StarWarsMod.blockTempleStoneStairs, "blockTempleStoneStairs");

		StarWarsMod.blockTempleStoneStairsBrick = new BlockTempleStoneStairsBrick();
		GameRegistry.registerBlock(StarWarsMod.blockTempleStoneStairsBrick, "blockTempleStoneStairsBrick");

		StarWarsMod.blockTempleStoneStairsFancy = new BlockTempleStoneStairsFancy();
		GameRegistry.registerBlock(StarWarsMod.blockTempleStoneStairsFancy, "blockTempleStoneStairsFancy");

		StarWarsMod.blockTempleStoneStairsSlabTop = new BlockTempleStoneStairsSlabTop();
		GameRegistry.registerBlock(StarWarsMod.blockTempleStoneStairsSlabTop, "blockTempleStoneStairsStabTop");

		StarWarsMod.blockTempleStoneStairsSlabTopDark = new BlockTempleStoneStairsSlabTopDark();
		GameRegistry.registerBlock(StarWarsMod.blockTempleStoneStairsSlabTopDark, "blockTempleStoneStairsSlabTopDark");

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

		StarWarsMod.blockCrystalOre = new BlockCrystalOre();
		GameRegistry.registerBlock(StarWarsMod.blockCrystalOre, ItemCrystalOreBlock.class, "blockCrystalOre");

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

		StarWarsMod.blockAncientJediStatue = new BlockAncientJediStatue();
		GameRegistry.registerBlock(StarWarsMod.blockAncientJediStatue, "ancientJediStatue");
		GameRegistry.registerTileEntity(TileEntityAncientJediStatue.class, "teAncientJediStatue");

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