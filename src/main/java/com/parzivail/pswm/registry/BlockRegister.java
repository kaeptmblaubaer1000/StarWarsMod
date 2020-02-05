package com.parzivail.pswm.registry;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.blocks.*;
import com.parzivail.pswm.blocks.npc.*;
import com.parzivail.pswm.blocks.ore.*;
import com.parzivail.pswm.blocks.sensor.*;
import com.parzivail.pswm.items.*;
import com.parzivail.pswm.items.lightsaber.ItemLightsaberCrystal;
import com.parzivail.pswm.tileentities.*;
import com.parzivail.pswm.tileentities.sensor.*;
import com.parzivail.util.block.BlockMultiHeight;
import com.parzivail.util.block.ItemMultiHeightBlock;
import com.parzivail.util.block.PBlockContainer;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.ui.TextUtils;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class BlockRegister
{
	public static void registerAll()
	{
		StarWarsMod.blockMV = new BlockMV();
		GameRegistry.registerBlock(StarWarsMod.blockMV, "moistureVaporator");
		GameRegistry.registerTileEntity(TileEntityMV.class, "teMoistureVaporator");

		StarWarsMod.blockSensorXWing = registerWithTileEntity(BlockSensorEntityXWing.class, TileEntitySensorEntityXWing.class);
		StarWarsMod.blockSensorYWing = registerWithTileEntity(BlockSensorEntityYWing.class, TileEntitySensorEntityYWing.class);
		StarWarsMod.blockSensorAWing = registerWithTileEntity(BlockSensorEntityAWing.class, TileEntitySensorEntityAWing.class);
		StarWarsMod.blockSensorTIE = registerWithTileEntity(BlockSensorEntityTIE.class, TileEntitySensorEntityTIE.class);
		StarWarsMod.blockSensorTIEAdvanced = registerWithTileEntity(BlockSensorEntityTIEAdvanced.class, TileEntitySensorEntityTIEAdvanced.class);
		StarWarsMod.blockSensorTIEBomber = registerWithTileEntity(BlockSensorEntityTIEBomber.class, TileEntitySensorEntityTIEBomber.class);
		StarWarsMod.blockSensorTIEInterceptor = registerWithTileEntity(BlockSensorEntityTIEInterceptor.class, TileEntitySensorEntityTIEInterceptor.class);
		StarWarsMod.blockSensorSnowspeeder = registerWithTileEntity(BlockSensorEntitySnowspeeder.class, TileEntitySensorEntitySnowspeeder.class);
		StarWarsMod.blockSensorSkyhopper = registerWithTileEntity(BlockSensorEntitySkyhopper.class, TileEntitySensorEntitySkyhopper.class);
		StarWarsMod.blockSensorATST = registerWithTileEntity(BlockSensorEntityATST.class, TileEntitySensorEntityATST.class);
		StarWarsMod.blockSensorLandspeeder = registerWithTileEntity(BlockSensorEntityLandspeeder.class, TileEntitySensorEntityLandspeeder.class);
		StarWarsMod.blockSensorJakkuSpeeder = registerWithTileEntity(BlockSensorEntityJakkuSpeeder.class, TileEntitySensorEntityJakkuSpeeder.class);
		StarWarsMod.blockSensorSpeederBike = registerWithTileEntity(BlockSensorEntitySpeederBike.class, TileEntitySensorEntitySpeederBike.class);
		StarWarsMod.blockSensorHothSpeederBike = registerWithTileEntity(BlockSensorEntityHothSpeederBike.class, TileEntitySensorEntityHothSpeederBike.class);
		StarWarsMod.blockSensorScootemaround = registerWithTileEntity(BlockSensorEntityScootemaround.class, TileEntitySensorEntityScootemaround.class);
		StarWarsMod.blockSensorScootemaroundHoth = registerWithTileEntity(BlockSensorEntityScootemaroundHoth.class, TileEntitySensorEntityScootemaroundHoth.class);

		StarWarsMod.blockSensorQuestAtst = registerWithTileEntity(BlockSensorAtst.class, TileEntitySensorAtst.class);

		StarWarsMod.blockSensorMobTauntaun = registerWithTileEntity(BlockSensorMobTauntaun.class, TileEntitySensorMobTauntaun.class);
		StarWarsMod.blockSensorMobDewback = registerWithTileEntity(BlockSensorMobDewback.class, TileEntitySensorMobDewback.class);
		StarWarsMod.blockSensorMobBantha = registerWithTileEntity(BlockSensorMobBantha.class, TileEntitySensorMobBantha.class);
		StarWarsMod.blockSensorMobWampa = registerWithTileEntity(BlockSensorMobWampa.class, TileEntitySensorMobWampa.class);
		StarWarsMod.blockSensorStructureTusken = registerWithTileEntity(BlockSensorTusken.class, TileEntitySensorStructureTusken.class);

		StarWarsMod.blockSensorStructureEwok = registerWithTileEntity(BlockSensorEwok.class, TileEntitySensorStructureEwok.class);
		StarWarsMod.blockSensorStructureJawa = registerWithTileEntity(BlockSensorJawa.class, TileEntitySensorStructureJawa.class);
		StarWarsMod.blockSensorStructureTatooineCommoner = registerWithTileEntity(BlockSensorTatooineCommoner.class, TileEntitySensorStructureTatooineCommoner.class);
		StarWarsMod.blockSensorStructureWookiee = registerWithTileEntity(BlockSensorWookiee.class, TileEntitySensorStructureWookiee.class);

		StarWarsMod.blockSensorRebelMassassi = registerWithTileEntity(BlockSensorRebelMassassi.class, TileEntitySensorStructureRebelMassassi.class);
		StarWarsMod.blockSensorRebelEcho = registerWithTileEntity(BlockSensorRebelEcho.class, TileEntitySensorStructureRebelEcho.class);
		StarWarsMod.blockSensorRebelHothGenerator = registerWithTileEntity(BlockSensorRebelHothGenerator.class, TileEntitySensorStructureRebelHothGenerator.class);
		StarWarsMod.blockSensorRebelEndor = registerWithTileEntity(BlockSensorRebelEndor.class, TileEntitySensorStructureRebelEndor.class);

		StarWarsMod.blockSensorImperialHeadquarters = registerWithTileEntity(BlockSensorImperialHeadquarters.class, TileEntitySensorStructureImperialHeadquarters.class);
		StarWarsMod.blockSensorImperialEndorShield = registerWithTileEntity(BlockSensorImperialEndorShield.class, TileEntitySensorStructureImperialEndorShield.class);
		StarWarsMod.blockSensorImperialTatooine = registerWithTileEntity(BlockSensorImperialTatooine.class, TileEntitySensorStructureImperialTatooine.class);
		StarWarsMod.blockSensorImperialHoth = registerWithTileEntity(BlockSensorImperialHoth.class, TileEntitySensorStructureImperialHoth.class);

		StarWarsMod.blockAntenna = new BlockAntenna();
		GameRegistry.registerBlock(StarWarsMod.blockAntenna, "blockAntenna");
		GameRegistry.registerTileEntity(TileEntityAntenna.class, "teAntenna");

		StarWarsMod.blockHothSign = new BlockHothSign(false);
		GameRegistry.registerBlock(StarWarsMod.blockHothSign, "blockHothSign");
		StarWarsMod.blockHothSignStanding = new BlockHothSign(true);
		GameRegistry.registerBlock(StarWarsMod.blockHothSignStanding, "blockHothSignStanding");
		GameRegistry.registerTileEntity(TileEntityHothSign.class, "teHothSign");

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

		//		StarWarsMod.blockStaticNpc = new BlockNpcBase[41];
		//
		//		StarWarsMod.blockStaticNpc[0] = new BlockNpcBase(QuestBank.imperial0, Resources.armors[3], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[1] = new BlockNpcBase(QuestBank.imperial1, Resources.armors[3], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[2] = new BlockNpcBase(QuestBank.imperial2, Resources.armors[3], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[3] = new BlockNpcBase(QuestBank.imperial3_1, Resources.armors[3], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[4] = new BlockNpcBase(QuestBank.imperial3_2, Resources.armors[3], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[5] = new BlockNpcBase(QuestBank.imperial4_1, Resources.armors[4], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[6] = new BlockNpcBase(QuestBank.imperial4_2, Resources.armors[4], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[7] = new BlockNpcBase(QuestBank.imperial4_3, Resources.armors[4], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[8] = new BlockNpcBase(QuestBank.imperial5, Resources.armors[4], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[9] = new BlockNpcBase(QuestBank.imperial6_1, Resources.armors[4], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[10] = new BlockNpcBase(QuestBank.imperial6_2, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[11] = new BlockNpcBase(QuestBank.imperial6_3, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[12] = new BlockNpcBase(QuestBank.imperial7, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[13] = new BlockNpcBase(QuestBank.imperial8_1, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[14] = new BlockNpcBase(QuestBank.imperial8_2, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[15] = new BlockNpcBase(QuestBank.imperial8_3, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[16] = new BlockNpcBase(QuestBank.imperial9, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[17] = new BlockNpcBase(QuestBank.imperial10_1, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[18] = new BlockNpcBase(QuestBank.imperial10_2, Resources.armors[5], Resources.allegianceImperial, Resources.skinDefault);
		//
		//		StarWarsMod.blockStaticNpc[19] = new BlockNpcBase(QuestBank.rebel0, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[20] = new BlockNpcBase(QuestBank.rebel1, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[21] = new BlockNpcBase(QuestBank.rebel2, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[22] = new BlockNpcBase(QuestBank.rebel3, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[23] = new BlockNpcBase(QuestBank.rebel4, Resources.armors[1], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[24] = new BlockNpcBase(QuestBank.rebel5, Resources.armors[1], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[25] = new BlockNpcBase(QuestBank.rebel6, Resources.armors[1], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[26] = new BlockNpcBase(QuestBank.rebel6_PostEndor, Resources.armors[2], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[27] = new BlockNpcBase(QuestBank.rebel7, Resources.armors[2], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[28] = new BlockNpcBase(QuestBank.rebel8, Resources.armors[2], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[29] = new BlockNpcBase(QuestBank.rebel8_Yavin, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[30] = new BlockNpcBase(QuestBank.rebel8_PostArmor, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[31] = new BlockNpcBase(QuestBank.rebel9, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[32] = new BlockNpcBase(QuestBank.rebel10, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[32] = new BlockNpcBase(QuestBank.rebel10_Over, Resources.armors[0], Resources.allegianceRebel, Resources.skinDefault);
		//
		//		StarWarsMod.blockStaticNpc[33] = new BlockNpcBase(QuestBank.jedi1_1, null, Resources.allegianceJedi, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[34] = new BlockNpcBase(QuestBank.jedi1_2, null, Resources.allegianceJedi, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[35] = new BlockNpcBase(QuestBank.jedi2, null, Resources.allegianceJedi, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[36] = new BlockNpcBase(QuestBank.jedi3, null, Resources.allegianceJedi, Resources.skinDefault);
		//
		//		StarWarsMod.blockStaticNpc[37] = new BlockNpcBase(QuestBank.sith1, null, Resources.allegianceSith, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[38] = new BlockNpcBase(QuestBank.sith2, null, Resources.allegianceSith, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[39] = new BlockNpcBase(QuestBank.sith3, null, Resources.allegianceSith, Resources.skinDefault);
		//		StarWarsMod.blockStaticNpc[40] = new BlockNpcBase(QuestBank.sith3_PostSaber, null, Resources.allegianceSith, Resources.skinDefault);
		//
		//		for (int i = 0; i < StarWarsMod.blockStaticNpc.length; i++)
		//		{
		//			GameRegistry.registerBlock(StarWarsMod.blockStaticNpc[i], "staticNpc" + String.valueOf(i));
		//		}

		StarWarsMod.blockStaticNpcRebelRex = new BlockNpcRebelRex();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcRebelRex, "blockStaticNpcRebelRex");

		StarWarsMod.blockStaticNpcRebelCarlist = new BlockNpcRebelCarlist();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcRebelCarlist, "blockStaticNpcRebelCarlist");

		StarWarsMod.blockStaticNpcRebelTantor = new BlockNpcRebelTantor();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcRebelTantor, "blockStaticNpcRebelTantor");

		StarWarsMod.blockStaticNpcRebelDreis = new BlockNpcRebelDreis();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcRebelDreis, "blockStaticNpcRebelDreis");

		StarWarsMod.blockStaticNpcRecruiterRebel = new BlockNpcRecruiterRebel();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcRecruiterRebel, "blockStaticNpcRecruiterRebel");

		StarWarsMod.blockStaticNpcImperialCody = new BlockNpcImperialCody();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcImperialCody, "blockStaticNpcImperialCody");

		StarWarsMod.blockStaticNpcImperialDaala = new BlockNpcImperialDaala();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcImperialDaala, "blockStaticNpcImperialDaala");

		StarWarsMod.blockStaticNpcImperialFurgan = new BlockNpcImperialFurgan();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcImperialFurgan, "blockStaticNpcImperialFurgan");

		StarWarsMod.blockStaticNpcImperialVeers = new BlockNpcImperialVeers();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcImperialVeers, "blockStaticNpcImperialVeers");

		StarWarsMod.blockStaticNpcRecruiterEmpire = new BlockNpcRecruiterEmpire();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcRecruiterEmpire, "blockStaticNpcRecruiterEmpire");

		StarWarsMod.blockStaticNpcYoda = new BlockNpcJediYoda();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcYoda, "blockStaticNpcYoda");

		StarWarsMod.blockStaticNpcObiWan = new BlockNpcJediObiWan();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcObiWan, "blockStaticNpcObiWan");

		StarWarsMod.blockStaticNpcSith = new BlockNpcSith();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcSith, "blockStaticNpcSith");

		StarWarsMod.blockStaticNpcRebelYavinQuartermaster = new BlockNpcRebelYavinQuartermaster();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcRebelYavinQuartermaster, "blockStaticNpcRebelYavinQuartermaster");

		StarWarsMod.blockStaticNpcEmpireEndorQuartermaster = new BlockNpcEmpireEndorQuartermaster();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcEmpireEndorQuartermaster, "blockStaticNpcEmpireEndorQuartermaster");

		StarWarsMod.blockStaticNpcJawaQuartermaster = new BlockNpcJawaQuartermaster();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcJawaQuartermaster, "blockStaticNpcJawaQuartermaster");

		StarWarsMod.blockStaticNpcMerchant = new BlockNpcMerchant();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcMerchant, "blockStaticNpcMerchant");

		StarWarsMod.blockStaticNpcCorellian = new BlockNpcCorellian();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcCorellian, "blockStaticNpcCorellian");

		StarWarsMod.blockStaticNpcWeaponsDealer = new BlockNpcWeaponsDealer();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcWeaponsDealer, "blockStaticNpcWeaponsDealer");

		StarWarsMod.blockStaticNpcBartender = new BlockNpcBartender();
		GameRegistry.registerBlock(StarWarsMod.blockStaticNpcBartender, "blockStaticNpcBartender");

		GameRegistry.registerTileEntity(TileEntityStaticNpc.class, "teStaticNpc");
		GameRegistry.registerTileEntity(TileEntityStaticNpcJawa.class, "teStaticNpcJawa");
		GameRegistry.registerTileEntity(TileEntityStaticNpcYoda.class, "teStaticNpcYoda");

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

		StarWarsMod.blockHothSnowCut = new BlockHothSnowCut();
		GameRegistry.registerBlock(StarWarsMod.blockHothSnowCut, "blockHothSnowCut");

		StarWarsMod.blockHothSandbag = new BlockHothSandbag();
		GameRegistry.registerBlock(StarWarsMod.blockHothSandbag, "blockHothSandbag");

		StarWarsMod.blockHothBaseDoor = new BlockHothBaseDoor();
		GameRegistry.registerBlock(StarWarsMod.blockHothBaseDoor, "blockHothBaseDoor");

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

		StarWarsMod.blockHardenedClayStairs = new BlockHardenedClayStairs();
		GameRegistry.registerBlock(StarWarsMod.blockHardenedClayStairs, "blockHardenedClayStairs");

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

		StarWarsMod.blockHardpackSnow = new BlockUnmeltingSnow();
		GameRegistry.registerBlock(StarWarsMod.blockHardpackSnow, "blockHardpackSnow");

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

		StarWarsMod.blockCrate1 = registerWithTileEntity(BlockCrateMass1.class, TileEntityCrate1.class);
		StarWarsMod.blockFloorLight = registerWithTileEntity(BlockFloorLight.class, TileEntityFloorLight.class);
		StarWarsMod.blockHolotableMass = registerWithTileEntity(BlockHolotableMass.class, TileEntityHolotableMass.class);
		StarWarsMod.blockLadder = registerWithTileEntity(BlockLadder.class, TileEntityLadder.class);
		StarWarsMod.blockPipeClampedMass = registerWithTileEntity(BlockPipeClampedMass.class, TileEntityPipeClampedMass.class);
		StarWarsMod.blockPipeMass = registerWithTileEntity(BlockPipeMass.class, TileEntityPipeMass.class);
		StarWarsMod.blockPipeSleevedMass = registerWithTileEntity(BlockPipeSleevedMass.class, TileEntityPipeSleevedMass.class);
		StarWarsMod.blockConsoleHoth1 = registerWithTileEntity(BlockConsoleHoth1.class, TileEntityConsoleHoth1.class);
		StarWarsMod.blockConsoleHoth2 = registerWithTileEntity(BlockConsoleHoth2.class, TileEntityConsoleHoth2.class);
		StarWarsMod.blockConsoleHoth3 = registerWithTileEntity(BlockConsoleHoth3.class, TileEntityConsoleHoth3.class);
		StarWarsMod.blockPanelHoth = registerWithTileEntity(BlockPanelHoth.class, TileEntityPanelHoth.class);
		StarWarsMod.blockHothCeilingLight = registerWithTileEntity(BlockHothCeilingLight.class, TileEntityHothCeilingLight.class);

		//StarWarsMod.blockPipeDoubleOffsetTopSpecial = registerWithTileEntity(BlockPipeDoubleOffsetTopSpecial.class, TileEntityPipeDoubleOffsetTopSpecial.class);
		StarWarsMod.blockMedicalConsole = registerWithTileEntity(BlockMedicalConsole.class, TileEntityMedicalConsole.class);
		StarWarsMod.blockMedicalConsole2 = registerWithTileEntity(BlockMedicalConsole2.class, TileEntityMedicalConsole2.class);
		StarWarsMod.blockPipeDoubleOffsetBot = registerWithTileEntity(BlockPipeDoubleOffsetBot.class, TileEntityPipeDoubleOffsetBot.class);
		StarWarsMod.blockPipeDoubleOffsetBotSpecial = registerWithTileEntity(BlockPipeDoubleOffsetBotSpecial.class, TileEntityPipeDoubleOffsetBotSpecial.class);
		//StarWarsMod.blockPipeDoubleOffsetTop = registerWithTileEntity(BlockPipeDoubleOffsetTop.class, TileEntityPipeDoubleOffsetTop.class);
		StarWarsMod.blockFloorLight2 = registerWithTileEntity(BlockFloorLight2.class, TileEntityFloorLight2.class);
		StarWarsMod.blockHothCrate1 = registerWithTileEntity(BlockCrateHoth1.class, TileEntityCrateHoth1.class);
		StarWarsMod.blockHothCrate2 = registerWithTileEntity(BlockCrateHoth2.class, TileEntityCrateHoth2.class);
		StarWarsMod.blockGunRack = registerWithTileEntity(BlockGunRack.class, TileEntityGunRack.class);
		StarWarsMod.blockDoorHoth = registerWithTileEntity(BlockDoorHoth.class, TileEntityDoorHoth.class);
		StarWarsMod.blockHothCeilingLight2 = registerWithTileEntity(BlockHothCeilingLight2.class, TileEntityHothCeilingLight2.class);
		StarWarsMod.blockTarget = registerWithTileEntity(BlockTarget.class, TileEntityTarget.class);

		StarWarsMod.blockAncientJediStatue = new BlockAncientJediStatue();
		GameRegistry.registerBlock(StarWarsMod.blockAncientJediStatue, "ancientJediStatue");
		GameRegistry.registerTileEntity(TileEntityAncientJediStatue.class, "teAncientJediStatue");

		StarWarsMod.blockTable2 = new BlockMudTable();
		GameRegistry.registerBlock(StarWarsMod.blockTable2, "mudTable");
		GameRegistry.registerTileEntity(TileEntityMudTable.class, "teMudTable");

		StarWarsMod.blockSnowSlab = new BlockSnowSlab(false);
		GameRegistry.registerBlock(StarWarsMod.blockSnowSlab, "blockSnowSlab");

		StarWarsMod.blockHardenedClaySlab = new BlockHardenedClaySlab(false);
		GameRegistry.registerBlock(StarWarsMod.blockHardenedClaySlab, "blockHardenedClaySlab");

		StarWarsMod.blockSnowDoubleSlab = new BlockSnowSlab(true);
		GameRegistry.registerBlock(StarWarsMod.blockSnowDoubleSlab, "blockSnowDoubleSlab");

		StarWarsMod.blockHardenedClayDoubleSlab = new BlockHardenedClaySlab(true);
		GameRegistry.registerBlock(StarWarsMod.blockHardenedClayDoubleSlab, "blockHardenedClayDoubleSlab");

		Lumberjack.info("Blocks, reporting for duty!");
	}

	private static PBlockContainer registerWithTileEntity(Class<? extends PBlockContainer> blockClass, Class<? extends TileEntity> tileEntityClass)
	{
		try
		{
			PBlockContainer container = blockClass.newInstance();
			GameRegistry.registerBlock(container, container.name);
			//tileEntityClass = container.createNewTileEntity(null, 0).getClass();
			GameRegistry.registerTileEntity(tileEntityClass, "te" + TextUtils.upperFirst(container.name));
			return container;
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			Lumberjack.warn(String.format("Unable to register block and tile %s - %s!", blockClass, tileEntityClass));
			e.printStackTrace();
		}
		return null;
	}
}
