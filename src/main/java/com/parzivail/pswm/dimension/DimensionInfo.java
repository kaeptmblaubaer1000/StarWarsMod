package com.parzivail.pswm.dimension;

import com.parzivail.pswm.dimension.dagobah.BiomeDagobah;
import com.parzivail.pswm.dimension.dagobah.WorldProviderDagobah;
import com.parzivail.pswm.dimension.endor.BiomeEndor;
import com.parzivail.pswm.dimension.endor.WorldProviderEndor;
import com.parzivail.pswm.dimension.hoth.BiomeHoth;
import com.parzivail.pswm.dimension.hoth.WorldProviderHoth;
import com.parzivail.pswm.dimension.ilum.BiomeIlum;
import com.parzivail.pswm.dimension.ilum.WorldProviderIlum;
import com.parzivail.pswm.dimension.tatooine.BiomeTatooine;
import com.parzivail.pswm.dimension.tatooine.WorldProviderTatooine;
import com.parzivail.pswm.dimension.yavin.BiomeYavin;
import com.parzivail.pswm.dimension.yavin.WorldProviderYavin;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Tuple;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Teleporter;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.vecmath.Vector2f;
import javax.vecmath.Vector3d;

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
	public static int yavinId = 24;
	public static Biome biomeYavin;
	public static DimensionType yavinDimension;
	public static int endorId = 25;
	public static Biome biomeEndor;
	public static DimensionType endorDimension;

	public static void register()
	{
		tatooineDimension = DimensionType.register("Tatooine", "_tatooine", tatooineId, WorldProviderTatooine.class, false);
		dagobahDimension = DimensionType.register("Dagobah", "_dagobah", dagobahId, WorldProviderDagobah.class, false);
		hothDimension = DimensionType.register("Hoth", "_hoth", hothId, WorldProviderHoth.class, false);
		ilumDimension = DimensionType.register("Ilum", "_ilum", ilumId, WorldProviderIlum.class, false);
		yavinDimension = DimensionType.register("Yavin 4", "_yavin", yavinId, WorldProviderYavin.class, false);
		endorDimension = DimensionType.register("Forest Moon of Endor", "_endor", endorId, WorldProviderEndor.class, false);

		biomeTatooine = new BiomeTatooine();
		biomeDagobah = new BiomeDagobah();
		biomeHoth = new BiomeHoth();
		biomeIlum = new BiomeIlum();
		biomeYavin = new BiomeYavin();
		biomeEndor = new BiomeEndor();

		DimensionManager.registerDimension(tatooineId, tatooineDimension);
		DimensionManager.registerDimension(dagobahId, dagobahDimension);
		DimensionManager.registerDimension(hothId, hothDimension);
		DimensionManager.registerDimension(ilumId, ilumDimension);
		DimensionManager.registerDimension(yavinId, yavinDimension);
		DimensionManager.registerDimension(endorId, endorDimension);

		GameRegistry.register(biomeTatooine);
		GameRegistry.register(biomeDagobah);
		GameRegistry.register(biomeHoth);
		GameRegistry.register(biomeIlum);
		GameRegistry.register(biomeYavin);
		GameRegistry.register(biomeEndor);

		Lumberjack.log("[DIMS] Prepare to orbit the planet Yavin.");
	}

	public static void teleportPlayerTo(EntityPlayerMP player, int id)
	{
		Teleporter teleporter = new InstantTeleporter(player.getServer().worldServerForDimension(id));
		transferPlayerToDimension(player, id, teleporter);
	}

	public static void transferPlayerToDimension(EntityPlayerMP player, int dimensionIn, net.minecraft.world.Teleporter teleporter)
	{
		player.mcServer.getPlayerList().transferPlayerToDimension(player, dimensionIn, teleporter);
		Tuple<Vector3d, Vector2f> pos = placePlayer(player.mcServer, dimensionIn);
		player.connection.setPlayerLocation(pos.getFirst().x, pos.getFirst().y, pos.getFirst().z, pos.getSecond().x, pos.getSecond().y);
	}

	public static Tuple<Vector3d, Vector2f> placePlayer(MinecraftServer mcServer, int dimension)
	{
		// TODO: spawns per planet
		return new Tuple<>(new Vector3d(0, mcServer.worldServerForDimension(dimension).getHeight(0, 0), 0), new Vector2f(0, 0));
	}
}
