package com.parzivail.util.schematic;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.ui.Lumberjack;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

/**
 * @author Colby
 */
public class PBlockMap
{
	public static Block idToBlock(int id)
	{
		switch (id)
		{
			case 166:
				return StarWarsMod.blockMV; // moistureVaporator

			case 167:
				return StarWarsMod.blockSensorXWing; // sensor-VehicXWing

			case 168:
				return StarWarsMod.blockSensorYWing; // sensor-VehicYWing

			case 169:
				return StarWarsMod.blockSensorAWing; // sensor-VehicAWing

			case 176:
				return StarWarsMod.blockSensorTIE; // sensor-VehicTIE

			case 177:
				return StarWarsMod.blockSensorTIEAdvanced; // sensor-VehicTIEAdvanced

			case 178:
				return StarWarsMod.blockSensorTIEBomber; // sensor-VehicTIEBomber

			case 179:
				return StarWarsMod.blockSensorTIEInterceptor; // sensor-VehicTIEInterceptor

			case 180:
				return StarWarsMod.blockSensorSnowspeeder; // sensor-VehicSnowspeeder

			case 181:
				return StarWarsMod.blockSensorSkyhopper; // sensor-VehicSkyhopper

			case 182:
				return StarWarsMod.blockSensorATST; // sensor-VehicATST

			case 183:
				return StarWarsMod.blockSensorLandspeeder; // sensor-VehicLandspeeder

			case 184:
				return StarWarsMod.blockSensorJakkuSpeeder; // sensor-VehicJakkuSpeeder

			case 185:
				return StarWarsMod.blockSensorSpeederBike; // sensor-VehicSpeederBike

			case 186:
				return StarWarsMod.blockSensorHothSpeederBike; // sensor-VehicHothSpeederBike

			case 187:
				return StarWarsMod.blockSensorScootemaround; // sensor-VehicScootemaround

			case 188:
				return StarWarsMod.blockSensorScootemaroundHoth; // sensor-VehicScootemaroundHoth

			case 189:
				return StarWarsMod.blockAntenna; // antenna

			case 190:
				return StarWarsMod.blockMovingLightSource; // movingLightSource

			case 191:
				return StarWarsMod.blockLightsaberForge; // lightsaberForge

			case 192:
				return StarWarsMod.blockCrystalCompressor; // crystalCompressor

			case 193:
				return StarWarsMod.blockHoloTable; // holoTable

			case 194:
				return StarWarsMod.blockFieldEmitter; // fieldEmitter

			case 195:
				return StarWarsMod.blockDeathStarDoor; // deathStarDoor

			case 196:
				return StarWarsMod.blockHangingCauldron; // cauldronHanging

			case 197:
				return StarWarsMod.blockHangingBucket; // bucketHanging

			case 198:
				return StarWarsMod.blockStaticNpc[0]; // staticNpc.welcometothegalacticempire

			case 199:
				return StarWarsMod.blockStaticNpc[1]; // staticNpc.thest

			case 200:
				return StarWarsMod.blockStaticNpc[2]; // staticNpc.maintenanceduty

			case 201:
				return StarWarsMod.blockStaticNpc[3]; // staticNpc.reconmission

			case 202:
				return StarWarsMod.blockStaticNpc[4]; // staticNpc.reconmission

			case 203:
				return StarWarsMod.blockStaticNpc[5]; // staticNpc.sandytroopers

			case 204:
				return StarWarsMod.blockStaticNpc[6]; // staticNpc.sandytroopers

			case 205:
				return StarWarsMod.blockStaticNpc[7]; // staticNpc.sandytroopers

			case 206:
				return StarWarsMod.blockStaticNpc[8]; // staticNpc.awretchedhiveofscumandvillainy

			case 207:
				return StarWarsMod.blockStaticNpc[9]; // staticNpc.therebelswilltrembleinfear

			case 208:
				return StarWarsMod.blockStaticNpc[10]; // staticNpc.therebelswilltrembleinfear

			case 209:
				return StarWarsMod.blockStaticNpc[11]; // staticNpc.therebelswilltrembleinfear

			case 210:
				return StarWarsMod.blockStaticNpc[12]; // staticNpc.routinemaintenance

			case 211:
				return StarWarsMod.blockStaticNpc[13]; // staticNpc.theimperialnavy

			case 212:
				return StarWarsMod.blockStaticNpc[14]; // staticNpc.theimperialnavy

			case 213:
				return StarWarsMod.blockStaticNpc[15]; // staticNpc.theimperialnavy

			case 214:
				return StarWarsMod.blockStaticNpc[16]; // staticNpc.bombingrun

			case 215:
				return StarWarsMod.blockStaticNpc[17]; // staticNpc.arealmission

			case 216:
				return StarWarsMod.blockStaticNpc[18]; // staticNpc.arealmission

			case 217:
				return StarWarsMod.blockStaticNpc[19]; // staticNpc.welcometotherepublicalliance

			case 218:
				return StarWarsMod.blockStaticNpc[20]; // staticNpc.enlisting

			case 219:
				return StarWarsMod.blockStaticNpc[21]; // staticNpc.targetpractice

			case 220:
				return StarWarsMod.blockStaticNpc[22]; // staticNpc.yourtickettothegalaxy

			case 221:
				return StarWarsMod.blockStaticNpc[23]; // staticNpc.shhhimhuntingwampa

			case 222:
				return StarWarsMod.blockStaticNpc[24]; // staticNpc.itsnobeggarscanyon

			case 223:
				return StarWarsMod.blockStaticNpc[25]; // staticNpc.thatsnomoon

			case 224:
				return StarWarsMod.blockStaticNpc[26]; // staticNpc.thatsnomoon

			case 225:
				return StarWarsMod.blockStaticNpc[27]; // staticNpc.meetingtheewoks

			case 226:
				return StarWarsMod.blockStaticNpc[28]; // staticNpc.redsquadron

			case 227:
				return StarWarsMod.blockStaticNpc[29]; // staticNpc.redsquadron

			case 228:
				return StarWarsMod.blockStaticNpc[30]; // staticNpc.redsquadron

			case 229:
				return StarWarsMod.blockStaticNpc[31]; // staticNpc.earningyourwings

			case 230:
				return StarWarsMod.blockStaticNpc[32]; // staticNpc.infiltration

			case 231:
				return StarWarsMod.blockStaticNpc[33]; // staticNpc.thejediorder

			case 232:
				return StarWarsMod.blockStaticNpc[34]; // staticNpc.thejediorder

			case 233:
				return StarWarsMod.blockStaticNpc[35]; // staticNpc.thelightsaber

			case 234:
				return StarWarsMod.blockStaticNpc[36]; // staticNpc.thedarkside

			case 235:
				return StarWarsMod.blockStaticNpc[37]; // staticNpc.anewholocron

			case 236:
				return StarWarsMod.blockStaticNpc[38]; // staticNpc.amasterandanapprentice

			case 237:
				return StarWarsMod.blockStaticNpc[39]; // staticNpc.theweaponofasith

			case 238:
				return StarWarsMod.blockStaticNpc[40]; // staticNpc.theweaponofasith

			case 239:
				return StarWarsMod.blockBasket; // basket

			case 240:
				return StarWarsMod.blockHyperdrive; // hyperdriveBlock

			case 241:
				return StarWarsMod.blockBactaTank; // bactaTank

			case 242:
				return StarWarsMod.blockTempleStoneMH; // multiHeight.templeStone

			case 243:
				return StarWarsMod.blockFocusingCrystalOre; // focusingCrystalOre

			case 244:
				return StarWarsMod.blockHothSnowCut; // hothSnowCut

			case 245:
				return StarWarsMod.blockHothSandbag; // hothSandbag

			case 246:
				return StarWarsMod.blockHothBaseDoor; // hothDoor

			case 247:
				return StarWarsMod.blockCortosisOre; // cortosisOre

			case 248:
				return StarWarsMod.blockDiatiumOre; // diatiumOre

			case 249:
				return StarWarsMod.blockExoniumOre; // exoniumOre

			case 250:
				return StarWarsMod.blockHeliciteOre; // heliciteOre

			case 251:
				return StarWarsMod.blockThorolideOre; // thorolideOre

			case 252:
				return StarWarsMod.blockTempleStone; // templeStone

			case 253:
				return StarWarsMod.blockTempleStoneStairs; // templeStoneStairs

			case 254:
				return StarWarsMod.blockTempleStoneStairsBrick; // templeStoneStairsBrick

			case 255:
				return StarWarsMod.blockTempleStoneStairsFancy; // templeStoneStairsBrickFancy

			case 409:
				return StarWarsMod.blockTempleStoneStairsSlabTopDark; // templeStoneStairsSlabTop

			case 410:
				return StarWarsMod.blockTempleStoneStairsSlabTopDark; // templeStoneStairsSlabTopDark

			case 411:
				return StarWarsMod.blockTempleStoneSlabLit; // templeStoneSlab

			case 412:
				return StarWarsMod.blockTempleStoneLit; // templeStoneLit

			case 413:
				return StarWarsMod.blockTempleStoneSlabLit; // templeStoneSlabLit

			case 414:
				return StarWarsMod.blockIoniteOre; // ioniteOre

			case 415:
				return StarWarsMod.blockKeleriumOre; // keleriumOre

			case 416:
				return StarWarsMod.blockRubindumOre; // rubindumOre

			case 423:
				return StarWarsMod.blockChromiumOre; // chromiumOre

			case 424:
				return StarWarsMod.blockTitaniumOre; // titaniumOre

			case 425:
				return StarWarsMod.blockTitaniumChromiumBlock; // titaniumChromiumBlock

			case 426:
				return StarWarsMod.blockDagobahMud; // dagobahMud

			case 427:
				return StarWarsMod.blockEndorBaseWall; // endorBaseWall

			case 428:
				return StarWarsMod.blockEndorBaseWallStairs; // endorBaseWallStairs

			case 429:
				return StarWarsMod.blockCrystalOre; // crystal

			case 430:
				return StarWarsMod.blockDeathStarBlock; // deathStarBlock

			case 431:
				return StarWarsMod.blockDeathStarLight; // deathStarLight

			case 432:
				return StarWarsMod.blockDeathStarGlass; // deathStarGlass

			case 433:
				return StarWarsMod.blockDeathStarLightStairs; // deathStarLightStairs

			case 434:
				return StarWarsMod.blockDeathStarLightFence; // deathStarLightFence

			case 435:
				return StarWarsMod.blockMudStairs; // mudStairs

			case 436:
				return StarWarsMod.blockTatooineSand; // tatooineSand

			case 437:
				return StarWarsMod.blockTatooineSandstone; // tatooineSandstone

			case 438:
				return StarWarsMod.blockSpaceLamp; // spaceLamp

			case 439:
				return StarWarsMod.blockIlumStone; // ilumStone

			case 440:
				return StarWarsMod.blockTable; // table

			case 441:
				return StarWarsMod.blockCrate1; // crate1

			case 442:
				return StarWarsMod.blockFloorLight; // floorLight

			case 443:
				return StarWarsMod.blockHolotableMass; // holotableMass

			case 444:
				return StarWarsMod.blockLadder; // ladder

			case 445:
				return StarWarsMod.blockPipeClampedMass; // pipeClampedMass

			case 446:
				return StarWarsMod.blockPipeMass; // pipeMass

			case 447:
				return StarWarsMod.blockPipeSleevedMass; // pipeSleevedMass

			case 448:
				return StarWarsMod.blockConsoleHoth1; // blockConsoleHoth1

			case 449:
				return StarWarsMod.blockConsoleHoth2; // blockConsoleHoth2

			case 450:
				return StarWarsMod.blockConsoleHoth3; // blockConsoleHoth3

			case 451:
				return StarWarsMod.blockPanelHoth; // blockPanelHoth

			case 452:
				return StarWarsMod.blockHothCeilingLight; // hothCeilingLight

			case 453:
				return StarWarsMod.blockPipeDoubleOffsetTopSpecial; // pipeDoubleOffsetTopSpecial

			case 454:
				return StarWarsMod.blockMedicalConsole; // medicalConsole

			case 455:
				return StarWarsMod.blockMedicalConsole2; // medicalConsole2

			case 456:
				return StarWarsMod.blockPipeDoubleOffsetBot; // pipeDoubleOffsetBot

			case 457:
				return StarWarsMod.blockPipeDoubleOffsetBotSpecial; // pipeDoubleOffsetBotSpecial

			case 458:
				return StarWarsMod.blockPipeDoubleOffsetTop; // pipeDoubleOffsetTop

			case 459:
				return StarWarsMod.blockFloorLight2; // floorLight2

			case 460:
				return StarWarsMod.blockHothCrate1; // crateHoth1

			case 461:
				return StarWarsMod.blockHothCrate2; // crateHoth2

			case 462:
				return StarWarsMod.blockAncientJediStatue; // ancientJediStatue

			case 463:
				return StarWarsMod.blockTable2; // mudTable

		}
		Block b = Block.getBlockById(id);
		if (b == Blocks.air && id != 0)
			Lumberjack.debug("Unknown PSWM block ID " + id);
		return b;
	}
}
