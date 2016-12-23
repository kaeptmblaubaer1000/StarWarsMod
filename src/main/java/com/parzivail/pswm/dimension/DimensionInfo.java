package com.parzivail.pswm.dimension;

import com.parzivail.pswm.dimension.tatooine.WorldProviderTatooine;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.management.PlayerList;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Teleporter;
import net.minecraftforge.common.DimensionManager;

/**
 * Created by colby on 12/22/2016.
 */
public class DimensionInfo
{
	public static final int tatooineId = 20;
	public static final DimensionType tatooineDimension = DimensionType.register("Tatooine", "_tatooine", tatooineId, WorldProviderTatooine.class, true);

	public static void register()
	{
		DimensionManager.registerDimension(tatooineId, tatooineDimension);

		Lumberjack.log("[DIMS] Prepare to orbit the planet Yavin.");
	}

	public static void teleportPlayerTo(EntityPlayerMP player, int id)
	{
		long time = System.currentTimeMillis();

		Teleporter teleporter = new InstantTeleporter(player.getServer().worldServerForDimension(id));
		PlayerList pl = player.getServer().getPlayerList();
		pl.transferPlayerToDimension(player, id, teleporter);

		long time2 = System.currentTimeMillis();

		Lumberjack.debug("It took %s seconds to teleport", (time2 - time) / 1000.0F);
	}

	public static void placePlayer(InstantTeleporter teleporter, Entity entity)
	{
		// TODO: spawns per planet
		entity.setLocationAndAngles(0, teleporter.getTerrainHeightAt(0, 0), 0, entity.rotationYaw, 0.0F);
	}
}
