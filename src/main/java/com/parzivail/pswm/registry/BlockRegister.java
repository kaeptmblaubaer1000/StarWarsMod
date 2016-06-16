package com.parzivail.pswm.registry;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.blocks.*;
import com.parzivail.pswm.blocks.npc.BlockNpcBase;
import com.parzivail.pswm.blocks.ore.*;
import com.parzivail.pswm.items.*;
import com.parzivail.pswm.quest.QuestBank;
import com.parzivail.pswm.tileentities.*;
import com.parzivail.pswm.vehicles.VehicAWing;
import com.parzivail.pswm.vehicles.VehicXWing;
import com.parzivail.pswm.vehicles.VehicYWing;
import com.parzivail.util.block.BlockMultiHeight;
import com.parzivail.util.block.ItemMultiHeightBlock;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister
{
	public static void registerAll()
	{
		StarWarsMod.blockMV = new BlockMV();
		GameRegistry.registerBlock(StarWarsMod.blockMV, "moistureVaporator");
		GameRegistry.registerTileEntity(TileEntityMV.class, "teMoistureVaporator");

		GameRegistry.registerTileEntity(TileEntitySensorEntity.class, "teSensorEntity");

		GameRegistry.registerBlock(StarWarsMod.blockSensorXWing = new BlockSensorEntity(VehicXWing.class, 0, 3, 0), "blockSensorXWing");
		GameRegistry.registerBlock(StarWarsMod.blockSensorYWing = new BlockSensorEntity(VehicYWing.class, 0, 3, 0), "blockSensorYWing");
		GameRegistry.registerBlock(StarWarsMod.blockSensorAWing = new BlockSensorEntity(VehicAWing.class, 0, 3, 0), "blockSensorAWing");

		StarWarsMod.blockAntenna = new BlockAntenna();
		GameRegistry.registerBlock(StarWarsMod.blockAntenna, "blockAntenna");
		GameRegistry.registerTileEntity(TileEntityAntenna.class, "teAntenna");

		StarWarsMod.blockMovingLightSource = new BlockMovingLightSource();
		GameRegistry.registerBlock(StarWarsMod.blockMovingLightSource, "blockMovingLightSource");
		GameRegistry.registerTileEntity(TileEntityMovingLightSource.class, "teMovingLightSource");

		StarWarsMod.blockLightsaberForge = new BlockLightsaberForge();
		GameRegistry.registerBlock(StarWarsMod.blockLightsaberForge, "blockLightsaberForge");
		GameRegistry.registerTileEntity(TileEntityLightsaberForge.class, "teLightsaberForge");

		StarWarsMod.blockCrystalCompressor = new BlockCrystalCompressor();
		GameRegistry.registerBlock(StarWarsMod.blockCrystalCompressor, "blockCrystalCompressor");
		GameRegistry.registerTileEntity(TileEntityCrystalCompressor.class, "teCrystalCompressor");

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

		StarWarsMod.blockStaticNpc = new BlockNpcBase[41];

		StarWarsMod.blockStaticNpc[0] = new BlockNpcBase(QuestBank.imperial0, Resources.armors[3], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[1] = new BlockNpcBase(QuestBank.imperial1, Resources.armors[3], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[2] = new BlockNpcBase(QuestBank.imperial2, Resources.armors[3], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[3] = new BlockNpcBase(QuestBank.imperial3_1, Resources.armors[3], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[4] = new BlockNpcBase(QuestBank.imperial3_2, Resources.armors[3], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[5] = new BlockNpcBase(QuestBank.imperial4_1, Resources.armors[4], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[6] = new BlockNpcBase(QuestBank.imperial4_2, Resources.armors[4], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[7] = new BlockNpcBase(QuestBank.imperial4_3, Resources.armors[4], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[8] = new BlockNpcBase(QuestBank.imperial5, Resources.armors[4], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[9] = new BlockNpcBase(QuestBank.imperial6_1, Resources.armors[4], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[10] = new BlockNpcBase(QuestBank.imperial6_2, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[11] = new BlockNpcBase(QuestBank.imperial6_3, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[12] = new BlockNpcBase(QuestBank.imperial7, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[13] = new BlockNpcBase(QuestBank.imperial8_1, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[14] = new BlockNpcBase(QuestBank.imperial8_2, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[15] = new BlockNpcBase(QuestBank.imperial8_3, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[16] = new BlockNpcBase(QuestBank.imperial9, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[17] = new BlockNpcBase(QuestBank.imperial10_1, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[18] = new BlockNpcBase(QuestBank.imperial10_2, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);

		StarWarsMod.blockStaticNpc[19] = new BlockNpcBase(QuestBank.rebel0, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[20] = new BlockNpcBase(QuestBank.rebel1, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[21] = new BlockNpcBase(QuestBank.rebel2, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[22] = new BlockNpcBase(QuestBank.rebel3, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[23] = new BlockNpcBase(QuestBank.rebel4, Resources.armors[1], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[24] = new BlockNpcBase(QuestBank.rebel5, Resources.armors[1], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[25] = new BlockNpcBase(QuestBank.rebel6, Resources.armors[1], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[26] = new BlockNpcBase(QuestBank.rebel6_PostEndor, Resources.armors[2], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[27] = new BlockNpcBase(QuestBank.rebel7, Resources.armors[2], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[28] = new BlockNpcBase(QuestBank.rebel8, Resources.armors[2], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[29] = new BlockNpcBase(QuestBank.rebel8_Yavin, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[30] = new BlockNpcBase(QuestBank.rebel8_PostArmor, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[31] = new BlockNpcBase(QuestBank.rebel9, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[32] = new BlockNpcBase(QuestBank.rebel10, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[32] = new BlockNpcBase(QuestBank.rebel10_Over, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);

		StarWarsMod.blockStaticNpc[33] = new BlockNpcBase(QuestBank.jedi1_1, null, Resources.allegianceJedi, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[34] = new BlockNpcBase(QuestBank.jedi1_2, null, Resources.allegianceJedi, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[35] = new BlockNpcBase(QuestBank.jedi2, null, Resources.allegianceJedi, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[36] = new BlockNpcBase(QuestBank.jedi3, null, Resources.allegianceJedi, Resources.skinDefault);

		StarWarsMod.blockStaticNpc[37] = new BlockNpcBase(QuestBank.sith1, null, Resources.allegianceSith, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[38] = new BlockNpcBase(QuestBank.sith2, null, Resources.allegianceSith, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[39] = new BlockNpcBase(QuestBank.sith3, null, Resources.allegianceSith, Resources.skinDefault);
		StarWarsMod.blockStaticNpc[40] = new BlockNpcBase(QuestBank.sith3_PostSaber, null, Resources.allegianceSith, Resources.skinDefault);

		for (int i = 0; i < StarWarsMod.blockStaticNpc.length; i++)
		{
			GameRegistry.registerBlock(StarWarsMod.blockStaticNpc[i], "staticNpc" + String.valueOf(i));
		}

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

		StarWarsMod.blockFocusingCrystalOre = new BlockFocusingCrystalOre();
		GameRegistry.registerBlock(StarWarsMod.blockFocusingCrystalOre, "blockFocusingCrystalOre");

		StarWarsMod.blockCortosisOre = new BlockCortosisOre();
		GameRegistry.registerBlock(StarWarsMod.blockCortosisOre, "blockCortosisOre");

		StarWarsMod.blockDiatiumOre = new BlockDiatiumOre();
		GameRegistry.registerBlock(StarWarsMod.blockDiatiumOre, "blockDiatiumOre");

		StarWarsMod.blockExoniumOre = new BlockExoniumOre();
		GameRegistry.registerBlock(StarWarsMod.blockExoniumOre, "blockExoniumOre");

		StarWarsMod.blockHeliciteOre = new BlockHeliciteOre();
		GameRegistry.registerBlock(StarWarsMod.blockHeliciteOre, "blockHeliciteOre");

		StarWarsMod.blockThorolideOre = new BlockThorolideOre();
		GameRegistry.registerBlock(StarWarsMod.blockThorolideOre, "blockThorolideOre");

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

		StarWarsMod.blockDeathStarLightStairs = new BlockDeathStarLightStairs();
		GameRegistry.registerBlock(StarWarsMod.blockDeathStarLightStairs, "blockDeathStarLightStairs");

		StarWarsMod.blockDeathStarLightFence = new BlockDeathStarLightFence();
		GameRegistry.registerBlock(StarWarsMod.blockDeathStarLightFence, "blockDeathStarLightFence");

		StarWarsMod.blockMudStairs = new BlockMudStairs();
		GameRegistry.registerBlock(StarWarsMod.blockMudStairs, "mudStairs");

		StarWarsMod.blockTatooineSand = new BlockTatooineSand();
		GameRegistry.registerBlock(StarWarsMod.blockTatooineSand, ItemTatooineSand.class, "tatooineSand");

		StarWarsMod.blockTatooineSandstone = new BlockTatooineSandstone();
		GameRegistry.registerBlock(StarWarsMod.blockTatooineSandstone, ItemTatooineSandstone.class, "tatooineSandstone");

		StarWarsMod.blockSpaceLamp = new BlockSpaceLamp();
		GameRegistry.registerBlock(StarWarsMod.blockSpaceLamp, "spaceLamp");

		StarWarsMod.blockIlumStone = new BlockIlumStone();
		GameRegistry.registerBlock(StarWarsMod.blockIlumStone, "IlumStone");

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
