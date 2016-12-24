package com.parzivail.pswm.dimension;

import com.parzivail.pswm.dimension.tatooine.WorldProviderTatooine;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
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
		Teleporter teleporter = new InstantTeleporter(player.getServer().worldServerForDimension(id));
		player.mcServer.getPlayerList().transferPlayerToDimension(player, id, teleporter);
	}

	public void changeDimension(EntityPlayerMP entity, int dimensionIn)
	{
	}

	public static void placePlayer(InstantTeleporter teleporter, Entity entity)
	{
		// TODO: spawns per planet
		entity.setLocationAndAngles(0, teleporter.getTerrainHeightAt(0, 0), 0, entity.rotationYaw, 0.0F);
	}
}
