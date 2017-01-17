package com.parzivail.pswm.registry;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.bank.PItems;
import com.parzivail.pswm.vehicle.itemspawn.*;
import com.parzivail.util.common.Lumberjack;

/**
 * Created by colby on 12/21/2016.
 */
public class ItemRegister
{
	public static void register()
	{
		PItems.spawnXwing = new ItemSpawnXWing();
		PItems.spawnUwing = new ItemSpawnUWing();
		PItems.spawnTIEStriker = new ItemSpawnTIEStriker();
		PItems.spawnTIE = new ItemSpawnTIE();
		PItems.spawnJR4Swoop = new ItemSpawnJR4Swoop();
		PItems.spawnAWing = new ItemSpawnAWing();
		PItems.spawnHothScoot = new ItemSpawnHothScoot();
		PItems.spawnJakkuSpeeder = new ItemSpawnJakkuSpeeder();
		PItems.spawnLandspeeder = new ItemSpawnLandspeeder();
		PItems.spawnScootEmAround = new ItemSpawnScootEmAround();
		PItems.spawnSkyhopper = new ItemSpawnSkyhopper();
		PItems.spawnSnowspeeder = new ItemSpawnSnowspeeder();
		PItems.spawnSpeederBike = new ItemSpawnSpeederBike();
		PItems.spawnT85 = new ItemSpawnT85();
		PItems.spawnTIEAdvanced = new ItemSpawnTIEAdvanced();
		PItems.spawnTIEBomber = new ItemSpawnTIEBomber();
		PItems.spawnTIEInterceptor = new ItemSpawnTIEInterceptor();
		PItems.spawnYWing = new ItemSpawnYWing();

		Lumberjack.log(PSWM.getNextRegisterMessage("ITEMS"));
	}
}
