package com.parzivail.pswm.registry;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.bank.PBlocks;
import com.parzivail.pswm.blocks.*;
import com.parzivail.pswm.blocks.hoth.*;
import com.parzivail.pswm.blocks.pipe.*;
import com.parzivail.util.basic.BasicBlock;
import com.parzivail.util.common.Lumberjack;

/**
 * Created by colby on 12/21/2016.
 */
public class BlockRegister
{
	public static void register()
	{
		PBlocks.infraBlack = new BasicBlock("infra_black");
		PBlocks.infraCaution = new BasicBlock("infra_caution");
		PBlocks.infraCrate = new BasicBlock("infra_crate");
		PBlocks.infraDarkGray = new BasicBlock("infra_darkgray");
		PBlocks.infraDarkGrayLit = new BasicBlock("infra_darkgray_lit");
		PBlocks.infraDarkGrayLit2 = new BasicBlock("infra_darkgray_lit2");
		PBlocks.infraForest = new BasicBlock("infra_forest");
		PBlocks.infraForestInset = new BasicBlock("infra_forestinset");
		PBlocks.infraForestPanel1 = new BasicBlock("infra_forestpanel1");
		PBlocks.infraForestPanel2 = new BasicBlock("infra_forestpanel2");
		PBlocks.infraForestPanel3 = new BasicBlock("infra_forestpanel3");
		PBlocks.infraForestVine = new BasicBlock("infra_forestvine");
		PBlocks.infraLight = new BasicBlock("infra_light");
		PBlocks.infraLightinset = new BasicBlock("infra_lightinset");
		PBlocks.infraLightLit = new BasicBlock("infra_light_lit");
		PBlocks.infraPanel1 = new BasicBlock("infra_panel1");
		PBlocks.infraWhite = new BasicBlock("infra_white");
		PBlocks.chromiumOre = new BasicBlock("chromium_ore");
		PBlocks.cortosisOre = new BasicBlock("cortosis_ore");
		PBlocks.cortosisReverseOre = new BasicBlock("cortosis_reverse_ore");
		PBlocks.crystalBlack = new BasicBlock("crystal_black");
		PBlocks.crystalBlue = new BasicBlock("crystal_blue");
		PBlocks.crystalCyan = new BasicBlock("crystal_cyan");
		PBlocks.crystalGray = new BasicBlock("crystal_gray");
		PBlocks.crystalGreen = new BasicBlock("crystal_green");
		PBlocks.crystalPink = new BasicBlock("crystal_pink");
		PBlocks.crystalPrism = new BasicBlock("crystal_prism");
		PBlocks.crystalPurple = new BasicBlock("crystal_purple");
		PBlocks.crystalWhite = new BasicBlock("crystal_white");
		PBlocks.crystalYellow = new BasicBlock("crystal_yellow");
		PBlocks.dagobahMud = new BasicBlock("dagobah_mud");
		PBlocks.diatiumOre = new BasicBlock("diatium_ore");
		PBlocks.exoniumOre = new BasicBlock("exonium_ore");
		PBlocks.focusingCrystalOre = new BasicBlock("focusing_crystal_ore");
		PBlocks.hardpackSnow = new BasicBlock("hardpack_snow");
		PBlocks.heliciteOre = new BasicBlock("helicite_ore");
		PBlocks.hothDoor = new BasicBlock("hoth_door");
		PBlocks.hothSnowCut = new BasicBlock("hoth_snow_cut");
		PBlocks.ilumStone = new BasicBlock("ilum_stone");
		PBlocks.ioniteOre = new BasicBlock("ionite_ore");
		PBlocks.keleriumOre = new BasicBlock("kelerium_ore");
		PBlocks.rubindumOre = new BasicBlock("rubindum_ore");
		PBlocks.spaceLamp = new BasicBlock("space_lamp");
		PBlocks.tatooineSand0 = new BasicBlock("tatooine_sand0");
		PBlocks.tatooineSand1 = new BasicBlock("tatooine_sand1");
		PBlocks.tatooineSandstoneBottom = new BasicBlock("tatooine_sandstone_bottom");
		PBlocks.tatooineSandstoneCarved = new BasicBlock("tatooine_sandstone_carved");
		PBlocks.tatooineSandstoneNormal = new BasicBlock("tatooine_sandstone_normal");
		PBlocks.tatooineSandstoneSmooth = new BasicBlock("tatooine_sandstone_smooth");
		PBlocks.tatooineSandstoneTop = new BasicBlock("tatooine_sandstone_top");
		PBlocks.templeStone = new BasicBlock("temple_stone");
		PBlocks.templeStoneBrick = new BasicBlock("temple_stone_brick");
		PBlocks.templeStoneBrickFancy = new BasicBlock("temple_stone_brick_fancy");
		PBlocks.templeStoneLit = new BasicBlock("temple_stone_lit");
		PBlocks.templeStoneLitBrick = new BasicBlock("temple_stone_lit_brick");
		PBlocks.templeStoneLitBrickFancy = new BasicBlock("temple_stone_lit_brick_fancy");
		PBlocks.templeStoneLitSlabTop = new BasicBlock("temple_stone_lit_slab_top");
		PBlocks.templeStoneLitSlabTopDark = new BasicBlock("temple_stone_lit_slab_top_dark");
		PBlocks.templeStoneSlabTop = new BasicBlock("temple_stone_slab_top");
		PBlocks.templeStoneSlabTopDark = new BasicBlock("temple_stone_slab_top_dark");
		PBlocks.thorolideOre = new BasicBlock("thorolide_ore");
		PBlocks.titaniumChromiumBlock = new BasicBlock("titanium_chromium_block");
		PBlocks.titaniumOre = new BasicBlock("titanium_ore");

		PBlocks.consoleHoth1 = new BlockConsoleHoth1();
		PBlocks.consoleHothCurved1 = new BlockConsoleHothCurved1();
		PBlocks.consoleHothCurved2 = new BlockConsoleHothCurved2();
		PBlocks.consoleHothCurved3 = new BlockConsoleHothCurved3();
		PBlocks.floorLight = new BlockFloorLight();
		PBlocks.floorLight2 = new BlockFloorLight2();
		PBlocks.hothCeilingLight = new BlockHothCeilingLight();
		PBlocks.hothCrate1 = new BlockHothCrate1();
		PBlocks.hothCrate2 = new BlockHothCrate2();
		PBlocks.medicalConsole = new BlockMedicalConsole();
		PBlocks.medicalConsole2 = new BlockMedicalConsole2();
		PBlocks.pipeDoubleOffsetBot = new BlockPipeDoubleOffsetBot();
		PBlocks.pipeDoubleOffsetBotSpecial = new BlockPipeDoubleOffsetBotSpecial();
		PBlocks.pipeDoubleOffsetTop = new BlockPipeDoubleOffsetTop();
		PBlocks.pipeDoubleOffsetTopSpecial = new BlockPipeDoubleOffsetTopSpecial();
		PBlocks.pipesClampedMass = new BlockPipesClampedMass();
		PBlocks.pipesMass = new BlockPipesMass();
		PBlocks.pipesSleevedMass = new BlockPipesSleevedMass();
		PBlocks.ancientJediStatue = new BlockAncientJediStatue();
		PBlocks.antenna = new BlockAntenna();
		PBlocks.bactaTank = new BlockBactaTank();
		PBlocks.basket = new BlockBasket();
		PBlocks.blockTable = new BlockBlockTable();
		PBlocks.crateMass1 = new BlockCrateMass1();
		PBlocks.crateMosEspa = new BlockCrateMosEspa();
		PBlocks.crateVilla = new BlockCrateVilla();
		PBlocks.crystalCompressor = new BlockCrystalCompressor();
		PBlocks.deathStarDoor = new BlockDeathStarDoor();
		PBlocks.doorHoth = new BlockDoorHoth();
		PBlocks.generator = new BlockGenerator();
		PBlocks.girder = new BlockGirder();
		PBlocks.gunRack = new BlockGunRack();
		PBlocks.hangingBucket = new BlockHangingBucket();
		PBlocks.hangingCauldron = new BlockHangingCauldron();
		PBlocks.holotableMass = new BlockHolotableMass();
		PBlocks.hothCeilingLight2 = new BlockHothCeilingLight2();
		PBlocks.hyperdriveBlock = new BlockHyperdriveBlock();
		PBlocks.ladder = new BlockLadder();
		PBlocks.ladderTop = new BlockLadderTop();
		PBlocks.lightsaberForge = new BlockLightsaberForge();
		PBlocks.mV = new BlockMV();
		PBlocks.mV2 = new BlockMV2();
		PBlocks.target = new BlockTarget();

		Lumberjack.log(PSWM.getNextRegisterMessage("BLOCKS"));
	}
}
