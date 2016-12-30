package com.parzivail.pswm.dimension;

import com.parzivail.pswm.dimension.dagobah.BiomeDagobah;
import com.parzivail.pswm.dimension.dagobah.WorldProviderDagobah;
import com.parzivail.pswm.dimension.hoth.BiomeHoth;
import com.parzivail.pswm.dimension.hoth.WorldProviderHoth;
import com.parzivail.pswm.dimension.ilum.BiomeIlum;
import com.parzivail.pswm.dimension.ilum.WorldProviderIlum;
import com.parzivail.pswm.dimension.tatooine.BiomeTatooine;
import com.parzivail.pswm.dimension.tatooine.WorldProviderTatooine;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketEntityEffect;
import net.minecraft.network.play.server.SPacketPlayerAbilities;
import net.minecraft.network.play.server.SPacketRespawn;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.management.PlayerList;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by colby on 12/22/2016.
 */
public class DimensionInfo
{
	public static int tatooineId = 20;
	public static Biome biomeTatooine;
	public static DimensionType tatooineDimension;
	public static int dagobahId = 21;
	public static Biome biomeDagobah;
	public static DimensionType dagobahDimension;
	public static int hothId = 22;
	public static Biome biomeHoth;
	public static DimensionType hothDimension;
	public static int ilumId = 23;
	public static Biome biomeIlum;
	public static DimensionType ilumDimension;

	public static void register()
	{
		tatooineDimension = DimensionType.register("Tatooine", "_tatooine", tatooineId, WorldProviderTatooine.class, false);
		dagobahDimension = DimensionType.register("Dagobah", "_dagobah", dagobahId, WorldProviderDagobah.class, false);
		hothDimension = DimensionType.register("Hoth", "_hoth", hothId, WorldProviderHoth.class, false);
		ilumDimension = DimensionType.register("Ilum", "_ilum", ilumId, WorldProviderIlum.class, false);

		biomeTatooine = new BiomeTatooine();
		biomeDagobah = new BiomeDagobah();
		biomeHoth = new BiomeHoth();
		biomeIlum = new BiomeIlum();

		DimensionManager.registerDimension(tatooineId, tatooineDimension);
		DimensionManager.registerDimension(dagobahId, dagobahDimension);
		DimensionManager.registerDimension(hothId, hothDimension);
		DimensionManager.registerDimension(ilumId, ilumDimension);

		GameRegistry.register(biomeTatooine);
		GameRegistry.register(biomeDagobah);
		GameRegistry.register(biomeHoth);
		GameRegistry.register(biomeIlum);

		Lumberjack.log("[DIMS] Prepare to orbit the planet Yavin.");
	}

	public static void teleportPlayerTo(EntityPlayerMP player, int id)
	{
		Teleporter teleporter = new InstantTeleporter(player.getServer().worldServerForDimension(id));
		transferPlayerToDimension(player, id, teleporter);
	}

	public static void transferPlayerToDimension(EntityPlayerMP player, int dimensionIn, net.minecraft.world.Teleporter teleporter)
	{
		PlayerList plist = player.mcServer.getPlayerList();
		int i = player.dimension;
		WorldServer worldserver = player.mcServer.worldServerForDimension(player.dimension);
		player.dimension = dimensionIn;
		WorldServer worldserver1 = player.mcServer.worldServerForDimension(player.dimension);
		player.connection.sendPacket(new SPacketRespawn(player.dimension, worldserver1.getDifficulty(), worldserver1.getWorldInfo().getTerrainType(), player.interactionManager.getGameType()));
		plist.updatePermissionLevel(player);
		player.setDropItemsWhenDead(false);
		worldserver.removeEntityDangerously(player);
		plist.transferEntityToWorld(player, i, worldserver, worldserver1, teleporter);
		plist.preparePlayer(player, worldserver);
		player.connection.setPlayerLocation(player.posX, player.posY, player.posZ, player.rotationYaw, player.rotationPitch);
		player.interactionManager.setWorld(worldserver1);
		player.connection.sendPacket(new SPacketPlayerAbilities(player.capabilities));
		plist.updateTimeAndWeatherForPlayer(player, worldserver1);
		plist.syncPlayerInventory(player);
		player.setDropItemsWhenDead(true);

		for (PotionEffect potioneffect : player.getActivePotionEffects())
		{
			player.connection.sendPacket(new SPacketEntityEffect(player.getEntityId(), potioneffect));
		}
		net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerChangedDimensionEvent(player, i, dimensionIn);
	}

	public static void placePlayer(InstantTeleporter teleporter, Entity entity)
	{
		// TODO: spawns per planet
		entity.setLocationAndAngles(0, teleporter.getTerrainHeightAt(0, 0), 0, entity.rotationYaw, 0.0F);
	}
}
