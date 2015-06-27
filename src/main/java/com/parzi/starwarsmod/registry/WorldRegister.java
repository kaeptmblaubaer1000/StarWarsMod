package com.parzi.starwarsmod.registry;

import net.minecraftforge.common.DimensionManager;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.world.BiomeHoth;
import com.parzi.starwarsmod.world.BiomeKashyyyk;
import com.parzi.starwarsmod.world.BiomeTatooine;
import com.parzi.starwarsmod.world.OreGenerator;
import com.parzi.starwarsmod.world.WorldProviderHoth;
import com.parzi.starwarsmod.world.WorldProviderKashyyyk;
import com.parzi.starwarsmod.world.WorldProviderTatooine;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldRegister
{
	public static void registerAll()
	{
		StarWarsMod.dimTatooineId = 156;
		StarWarsMod.biomeTatooine = new BiomeTatooine(StarWarsMod.dimTatooineId);

		StarWarsMod.dimHothId = 155;
		StarWarsMod.biomeHoth = new BiomeHoth(StarWarsMod.dimHothId);

		StarWarsMod.dimKashyyykId = 154;
		StarWarsMod.biomeKashyyyk = new BiomeKashyyyk(StarWarsMod.dimKashyyykId);

		DimensionManager.registerProviderType(StarWarsMod.dimTatooineId, WorldProviderTatooine.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimTatooineId, StarWarsMod.dimTatooineId);

		DimensionManager.registerProviderType(StarWarsMod.dimHothId, WorldProviderHoth.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimHothId, StarWarsMod.dimHothId);

		DimensionManager.registerProviderType(StarWarsMod.dimKashyyykId, WorldProviderKashyyyk.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimKashyyykId, StarWarsMod.dimKashyyykId);

		GameRegistry.registerWorldGenerator(new OreGenerator(), 10);
	}
}
