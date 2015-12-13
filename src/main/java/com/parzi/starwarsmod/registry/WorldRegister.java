package com.parzi.starwarsmod.registry;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobBantha;
import com.parzi.starwarsmod.mobs.MobDewback;
import com.parzi.starwarsmod.mobs.MobDroidProbe;
import com.parzi.starwarsmod.mobs.MobEwok;
import com.parzi.starwarsmod.mobs.MobGamorrean;
import com.parzi.starwarsmod.mobs.MobJawa;
import com.parzi.starwarsmod.mobs.MobSandtrooper;
import com.parzi.starwarsmod.mobs.MobTauntaun;
import com.parzi.starwarsmod.mobs.MobTusken;
import com.parzi.starwarsmod.mobs.MobWampa;
import com.parzi.starwarsmod.mobs.MobWookiee;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.utils.WorldUtils;
import com.parzi.starwarsmod.world.OreGenerator;
import com.parzi.starwarsmod.world.biome.BiomeDagobah;
import com.parzi.starwarsmod.world.biome.BiomeEndor;
import com.parzi.starwarsmod.world.biome.BiomeEndorPlains;
import com.parzi.starwarsmod.world.biome.BiomeHoth;
import com.parzi.starwarsmod.world.biome.BiomeKashyyyk;
import com.parzi.starwarsmod.world.biome.BiomeTatooine;
import com.parzi.starwarsmod.world.biome.BiomeYavinFour;
import com.parzi.starwarsmod.world.provider.WorldProviderDagobah;
import com.parzi.starwarsmod.world.provider.WorldProviderEndor;
import com.parzi.starwarsmod.world.provider.WorldProviderHoth;
import com.parzi.starwarsmod.world.provider.WorldProviderKashyyyk;
import com.parzi.starwarsmod.world.provider.WorldProviderTatooine;
import com.parzi.starwarsmod.world.provider.WorldProviderYavinFour;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class WorldRegister
{
	public static void registerAll()
	{
		StarWarsMod.dimTatooineId = DimensionManager.getNextFreeDimId();
		StarWarsMod.dimHothId = DimensionManager.getNextFreeDimId();
		StarWarsMod.dimKashyyykId = DimensionManager.getNextFreeDimId();
		StarWarsMod.dimYavin4Id = DimensionManager.getNextFreeDimId();
		StarWarsMod.dimEndorId = DimensionManager.getNextFreeDimId();
		StarWarsMod.dimEndorPlainsId = DimensionManager.getNextFreeDimId();
		StarWarsMod.dimDagobahId = DimensionManager.getNextFreeDimId();

		StarWarsMod.biomeTatooine = new BiomeTatooine(StarWarsMod.dimTatooineId);
		StarWarsMod.biomeHoth = new BiomeHoth(StarWarsMod.dimHothId);
		StarWarsMod.biomeKashyyyk = new BiomeKashyyyk(StarWarsMod.dimKashyyykId);
		StarWarsMod.biomeYavin4 = new BiomeYavinFour(StarWarsMod.dimYavin4Id);
		StarWarsMod.biomeEndor = new BiomeEndor(StarWarsMod.dimEndorId);
		StarWarsMod.biomeEndorPlains = new BiomeEndorPlains(StarWarsMod.dimEndorPlainsId);
		StarWarsMod.biomeDagobah = new BiomeDagobah(StarWarsMod.dimDagobahId);

		WorldUtils.registerDimension(StarWarsMod.dimTatooineId, WorldProviderTatooine.class);
		WorldUtils.registerDimension(StarWarsMod.dimHothId, WorldProviderHoth.class);
		WorldUtils.registerDimension(StarWarsMod.dimKashyyykId, WorldProviderKashyyyk.class);
		WorldUtils.registerDimension(StarWarsMod.dimYavin4Id, WorldProviderYavinFour.class);
		WorldUtils.registerDimension(StarWarsMod.dimEndorId, WorldProviderEndor.class);
		WorldUtils.registerDimension(StarWarsMod.dimDagobahId, WorldProviderDagobah.class);

		/*
		 * WorldUtils.removeSpawnBiome(StarWarsMod.biomeEndor);
		 * WorldUtils.removeSpawnBiome(StarWarsMod.biomeEndorPlains);
		 * WorldUtils.removeSpawnBiome(StarWarsMod.biomeHoth);
		 * WorldUtils.removeSpawnBiome(StarWarsMod.biomeKashyyyk);
		 * WorldUtils.removeSpawnBiome(StarWarsMod.biomeTatooine);
		 * WorldUtils.removeSpawnBiome(StarWarsMod.biomeYavin4);
		 * WorldUtils.removeSpawnBiome(StarWarsMod.biomeDagobah);
		 */

		EntityRegistry.addSpawn(MobGamorrean.class, 3, 1, 3, EnumCreatureType.monster, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobSandtrooper.class, 80, 5, 10, EnumCreatureType.monster, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobJawa.class, 30, 1, 5, EnumCreatureType.monster, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobTusken.class, 3, 1, 3, EnumCreatureType.monster, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobBantha.class, 7, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobDewback.class, 7, 1, 2, EnumCreatureType.creature, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobEwok.class, 10, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeEndor, StarWarsMod.biomeEndorPlains);
		EntityRegistry.addSpawn(MobTauntaun.class, 6, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeHoth);
		EntityRegistry.addSpawn(MobDroidProbe.class, 1, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeHoth);
		EntityRegistry.addSpawn(MobWampa.class, 1, 1, 1, EnumCreatureType.monster, StarWarsMod.biomeHoth);
		EntityRegistry.addSpawn(MobWookiee.class, 10, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeKashyyyk);

		GameRegistry.registerWorldGenerator(new OreGenerator(), 10);
		Lumberjack.info("World, reporting for duty!");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\WorldRegister.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */