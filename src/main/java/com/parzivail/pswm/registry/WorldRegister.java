package com.parzivail.pswm.registry;

import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.dimension.dagobah.BiomeGenDagobah;
import com.parzivail.pswm.dimension.dagobah.DagobahProvider;
import com.parzivail.pswm.dimension.endor.BiomeGenEndor;
import com.parzivail.pswm.dimension.endor.EndorProvider;
import com.parzivail.pswm.dimension.hoth.BiomeGenHoth;
import com.parzivail.pswm.dimension.hoth.HothProvider;
import com.parzivail.pswm.dimension.ilum.BiomeGenIlum;
import com.parzivail.pswm.dimension.ilum.IlumProvider;
import com.parzivail.pswm.dimension.kashyyyk.BiomeGenKashyyyk;
import com.parzivail.pswm.dimension.kashyyyk.KashyyykProvider;
import com.parzivail.pswm.dimension.tatooine.BiomeGenTatooine;
import com.parzivail.pswm.dimension.tatooine.TatooineProvider;
import com.parzivail.pswm.dimension.yavin.BiomeGenYavin;
import com.parzivail.pswm.dimension.yavin.YavinProvider;
import com.parzivail.pswm.handlers.TerrainGenHandler;
import com.parzivail.pswm.mobs.MobBantha;
import com.parzivail.pswm.mobs.MobDewback;
import com.parzivail.pswm.mobs.MobDroidProbe;
import com.parzivail.pswm.mobs.MobEwok;
import com.parzivail.pswm.mobs.MobGamorrean;
import com.parzivail.pswm.mobs.MobJawa;
import com.parzivail.pswm.mobs.MobSandtrooper;
import com.parzivail.pswm.mobs.MobTauntaun;
import com.parzivail.pswm.mobs.MobTusken;
import com.parzivail.pswm.mobs.MobWampa;
import com.parzivail.pswm.mobs.MobWookiee;
import com.parzivail.pswm.world.OreGenerator;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.world.WorldUtils;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldRegister
{
	public static void registerAll()
	{
		StarWarsMod.biomeTatooine = new BiomeGenTatooine(ConfigOptions.biomeTatooineId);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeTatooine);
		StarWarsMod.biomeHoth = new BiomeGenHoth(ConfigOptions.biomeHothId);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeHoth);
		StarWarsMod.biomeKashyyyk = new BiomeGenKashyyyk(ConfigOptions.biomeKashyyykId);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeKashyyyk);
		StarWarsMod.biomeYavin4 = new BiomeGenYavin(ConfigOptions.biomeYavin4Id);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeYavin4);
		StarWarsMod.biomeEndor = new BiomeGenEndor(ConfigOptions.biomeEndorId);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeEndor);
		StarWarsMod.biomeIlum = new BiomeGenIlum(ConfigOptions.biomeIlumId);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeIlum);
		// StarWarsMod.biomeEndorPlains = new
		// BiomeEndorPlains(StarWarsMod.dimEndorPlainsId);
		StarWarsMod.biomeDagobah = new BiomeGenDagobah(ConfigOptions.dimDagobahId);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeDagobah);

		WorldUtils.registerDimension(ConfigOptions.dimTatooineId, TatooineProvider.class);
		WorldUtils.registerDimension(ConfigOptions.dimHothId, HothProvider.class);
		WorldUtils.registerDimension(ConfigOptions.dimKashyyykId, KashyyykProvider.class);
		WorldUtils.registerDimension(ConfigOptions.dimYavin4Id, YavinProvider.class);
		WorldUtils.registerDimension(ConfigOptions.dimEndorId, EndorProvider.class);
		WorldUtils.registerDimension(ConfigOptions.dimIlumId, IlumProvider.class);
		WorldUtils.registerDimension(ConfigOptions.dimDagobahId, DagobahProvider.class);

		EntityRegistry.addSpawn(MobGamorrean.class, 3, 1, 3, EnumCreatureType.monster, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobSandtrooper.class, 80, 5, 10, EnumCreatureType.monster, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobJawa.class, 30, 1, 5, EnumCreatureType.monster, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobTusken.class, 3, 1, 3, EnumCreatureType.monster, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobBantha.class, 7, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobDewback.class, 7, 1, 2, EnumCreatureType.creature, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobEwok.class, 10, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeEndor);
		EntityRegistry.addSpawn(MobTauntaun.class, 6, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeHoth);
		EntityRegistry.addSpawn(MobDroidProbe.class, 1, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeHoth);
		EntityRegistry.addSpawn(MobWampa.class, 1, 1, 1, EnumCreatureType.monster, StarWarsMod.biomeHoth);
		EntityRegistry.addSpawn(MobWookiee.class, 15, 1, 3, EnumCreatureType.creature, StarWarsMod.biomeKashyyyk);

		GameRegistry.registerWorldGenerator(new OreGenerator(), 10);

		MinecraftForge.TERRAIN_GEN_BUS.register(new TerrainGenHandler());

		Lumberjack.info("World, reporting for duty!");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\WorldRegister.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */