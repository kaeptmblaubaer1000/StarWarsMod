package com.parzivail.pswm.registry;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.bank.PItems;
import com.parzivail.pswm.vehicle.ItemSpawnUWing;
import com.parzivail.pswm.vehicle.ItemSpawnXWing;
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

		Lumberjack.log(PSWM.getNextRegisterMessage("ITEMS"));
	}
}
