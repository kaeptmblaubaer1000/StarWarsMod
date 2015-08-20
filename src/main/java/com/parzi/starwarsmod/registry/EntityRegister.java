package com.parzi.starwarsmod.registry;

import net.minecraft.entity.EnumCreatureType;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.entities.EntityBlasterHeavyBolt;
import com.parzi.starwarsmod.entities.EntityBlasterPistolBolt;
import com.parzi.starwarsmod.entities.EntityBlasterRifleBolt;
import com.parzi.starwarsmod.entities.EntitySpeederBlasterRifleBolt;
import com.parzi.starwarsmod.mobs.MobBantha;
import com.parzi.starwarsmod.mobs.MobDewback;
import com.parzi.starwarsmod.mobs.MobDroidAstromech;
import com.parzi.starwarsmod.mobs.MobDroidGNK;
import com.parzi.starwarsmod.mobs.MobDroidProtocol;
import com.parzi.starwarsmod.mobs.MobEwok;
import com.parzi.starwarsmod.mobs.MobGamorrean;
import com.parzi.starwarsmod.mobs.MobJawa;
import com.parzi.starwarsmod.mobs.MobTatooineCommoner;
import com.parzi.starwarsmod.mobs.MobTauntaun;
import com.parzi.starwarsmod.mobs.MobTusken;
import com.parzi.starwarsmod.mobs.MobWampa;
import com.parzi.starwarsmod.mobs.MobWookiee;
import com.parzi.starwarsmod.utils.EntityUtils;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicLandspeeder;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;
import com.parzi.starwarsmod.weaponry.WeaponDSTurret;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityRegister
{
	public static void registerAll()
	{
		EntityUtils.registerWithSpawnEgg(MobWookiee.class, "wookiee", 0x974F1A, 0x3C200A);
		EntityUtils.registerWithSpawnEgg(MobTusken.class, "tusken", 0xFFFDB3, 0x5E5E4A);
		EntityUtils.registerWithSpawnEgg(MobJawa.class, "jawa", 0xFF0000, 0x9B6C00);
		EntityUtils.registerWithSpawnEgg(MobEwok.class, "ewok", 0x7e6c54, 0x3f362a);
		EntityUtils.registerWithSpawnEgg(MobTauntaun.class, "tauntaun", 0xFFFFFF, 0x4ADCE8);
		EntityUtils.registerWithSpawnEgg(MobBantha.class, "bantha", 0x8B4513, 0xFFDEAD);
		EntityUtils.registerWithSpawnEgg(MobWampa.class, "wampa", 0xFFFFFF, 0x7F0000);
		EntityUtils.registerWithSpawnEgg(MobGamorrean.class, "gamorrean", 0x990033, 0x20B392);
		EntityUtils.registerWithSpawnEgg(MobDewback.class, "dewback", 0xFFA500, 0x544838);
		EntityUtils.registerWithSpawnEgg(MobTatooineCommoner.class, "commoner", 0x000000, 0x000000);

		EntityUtils.registerEntity(MobDroidAstromech.class, "droidAstromech");
		EntityUtils.registerEntity(MobDroidProtocol.class, "droidProtocol");
		EntityUtils.registerEntity(MobDroidGNK.class, "droidGonk");

		EntityUtils.registerEntity(VehicHothSpeederBike.class, "hothSpeederBike");
		EntityUtils.registerEntity(VehicSpeederBike.class, "speederBike");
		EntityUtils.registerEntity(VehicLandspeeder.class, "landspeeder");

		EntityUtils.registerEntity(WeaponDSTurret.class, "dsTurret");

		EntityUtils.registerEntity(EntityBlasterPistolBolt.class, "blasterBolt");
		EntityUtils.registerEntity(EntityBlasterRifleBolt.class, "blasterRifleBolt");
		EntityUtils.registerEntity(EntityBlasterHeavyBolt.class, "blasterHeavyBolt");
		EntityUtils.registerEntity(EntitySpeederBlasterRifleBolt.class, "blasterSpeederRifleBolt");

		EntityRegistry.addSpawn(MobGamorrean.class, 3, 1, 3, EnumCreatureType.monster, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobJawa.class, 30, 1, 5, EnumCreatureType.monster, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobTusken.class, 3, 1, 3, EnumCreatureType.monster, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobBantha.class, 7, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeTatooine);
		EntityRegistry.addSpawn(MobDewback.class, 7, 1, 2, EnumCreatureType.creature, StarWarsMod.biomeTatooine);

		EntityRegistry.addSpawn(MobEwok.class, 10, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeEndor, StarWarsMod.biomeEndorPlains);

		EntityRegistry.addSpawn(MobTauntaun.class, 6, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeHoth);
		EntityRegistry.addSpawn(MobWampa.class, 1, 1, 1, EnumCreatureType.monster, StarWarsMod.biomeHoth);

		EntityRegistry.addSpawn(MobWookiee.class, 10, 1, 1, EnumCreatureType.creature, StarWarsMod.biomeKashyyyk);

		Lumberjack.info("Entities, reporting for duty!");
	}
}
