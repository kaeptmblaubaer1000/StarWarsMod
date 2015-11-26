package com.parzi.starwarsmod.registry;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.entities.EntityBlasterHeavyBolt;
import com.parzi.starwarsmod.entities.EntityBlasterPistolBolt;
import com.parzi.starwarsmod.entities.EntityBlasterProbeBolt;
import com.parzi.starwarsmod.entities.EntityBlasterRifleBolt;
import com.parzi.starwarsmod.entities.EntitySpeederBlasterRifleBolt;
import com.parzi.starwarsmod.entities.EntityTIEBolt;
import com.parzi.starwarsmod.entities.EntityXWingBolt;
import com.parzi.starwarsmod.mobs.MobBantha;
import com.parzi.starwarsmod.mobs.MobBith;
import com.parzi.starwarsmod.mobs.MobDewback;
import com.parzi.starwarsmod.mobs.MobDroidAstromech;
import com.parzi.starwarsmod.mobs.MobDroidAstromech2;
import com.parzi.starwarsmod.mobs.MobDroidGNK;
import com.parzi.starwarsmod.mobs.MobDroidMouse;
import com.parzi.starwarsmod.mobs.MobDroidProbe;
import com.parzi.starwarsmod.mobs.MobDroidProtocol;
import com.parzi.starwarsmod.mobs.MobDroidProtocol2;
import com.parzi.starwarsmod.mobs.MobDroidSurgical;
import com.parzi.starwarsmod.mobs.MobDroidTreadwell;
import com.parzi.starwarsmod.mobs.MobEwok;
import com.parzi.starwarsmod.mobs.MobGamorrean;
import com.parzi.starwarsmod.mobs.MobJawa;
import com.parzi.starwarsmod.mobs.MobSandtrooper;
import com.parzi.starwarsmod.mobs.MobTatooineCommoner;
import com.parzi.starwarsmod.mobs.MobTauntaun;
import com.parzi.starwarsmod.mobs.MobTusken;
import com.parzi.starwarsmod.mobs.MobWampa;
import com.parzi.starwarsmod.mobs.MobWookiee;
import com.parzi.starwarsmod.utils.EntityUtils;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.vehicles.VehicAWing;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicJakkuSpeeder;
import com.parzi.starwarsmod.vehicles.VehicLandspeeder;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicTIE;
import com.parzi.starwarsmod.vehicles.VehicTIEInterceptor;
import com.parzi.starwarsmod.vehicles.VehicXWing;
import com.parzi.starwarsmod.weaponry.WeaponDSTurret;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class EntityRegister
{
	public static void registerAll()
	{
		EntityUtils.registerWithSpawnEgg(MobWookiee.class, "wookiee", 9916186, 3940362);
		EntityUtils.registerWithSpawnEgg(MobTusken.class, "tusken", 16776627, 6184522);
		EntityUtils.registerWithSpawnEgg(MobJawa.class, "jawa", 16711680, 10185728);
		EntityUtils.registerWithSpawnEgg(MobEwok.class, "ewok", 8285268, 4142634);
		EntityUtils.registerWithSpawnEgg(MobTauntaun.class, "tauntaun", 16777215, 4906216);
		EntityUtils.registerWithSpawnEgg(MobBantha.class, "bantha", 9127187, 16768685);
		EntityUtils.registerWithSpawnEgg(MobWampa.class, "wampa", 16777215, 8323072);
		EntityUtils.registerWithSpawnEgg(MobGamorrean.class, "gamorrean", 10027059, 2143122);
		EntityUtils.registerWithSpawnEgg(MobDewback.class, "dewback", 16753920, 5523512);
		EntityUtils.registerWithSpawnEgg(MobTatooineCommoner.class, "commoner", 0, 0);
		EntityUtils.registerWithSpawnEgg(MobBith.class, "bith", 0, 0);
		EntityUtils.registerWithSpawnEgg(MobSandtrooper.class, "sandtrooper", 0, 0);
		EntityUtils.registerEntity(MobDroidAstromech.class, "droidAstromech");
		EntityUtils.registerEntity(MobDroidAstromech2.class, "droidAstromech2");
		EntityUtils.registerEntity(MobDroidProtocol.class, "droidProtocol");
		EntityUtils.registerEntity(MobDroidProtocol2.class, "droidProtocol2");
		EntityUtils.registerEntity(MobDroidProbe.class, "droidProbe");
		EntityUtils.registerEntity(MobDroidGNK.class, "droidGonk");
		EntityUtils.registerEntity(MobDroidSurgical.class, "droidSurgical");
		EntityUtils.registerEntity(MobDroidTreadwell.class, "droidTreadwell");
		EntityUtils.registerEntity(MobDroidMouse.class, "droidMouse");
		EntityUtils.registerEntity(VehicHothSpeederBike.class, "hothSpeederBike");
		EntityUtils.registerEntity(VehicTIE.class, "tie");
		EntityUtils.registerEntity(VehicTIEInterceptor.class, "tieInterceptor");
		EntityUtils.registerEntity(VehicXWing.class, "xwing");
		EntityUtils.registerEntity(VehicAWing.class, "awing");
		EntityUtils.registerEntity(VehicSpeederBike.class, "speederBike");
		EntityUtils.registerEntity(VehicLandspeeder.class, "landspeeder");
		EntityUtils.registerEntity(VehicJakkuSpeeder.class, "jakkuSpeeder");
		EntityUtils.registerEntity(WeaponDSTurret.class, "dsTurret");
		EntityUtils.registerEntity(EntityBlasterPistolBolt.class, "blasterBolt");
		EntityUtils.registerEntity(EntityBlasterRifleBolt.class, "blasterRifleBolt");
		EntityUtils.registerEntity(EntityBlasterHeavyBolt.class, "blasterHeavyBolt");
		EntityUtils.registerEntity(EntityBlasterProbeBolt.class, "blasterProbeBolt");
		EntityUtils.registerEntity(EntitySpeederBlasterRifleBolt.class, "blasterSpeederRifleBolt");
		EntityUtils.registerEntity(EntityXWingBolt.class, "blasterXWingBolt");
		EntityUtils.registerEntity(EntityTIEBolt.class, "blasterTIEBolt");
		EntityRegistry.addSpawn(MobGamorrean.class, 3, 1, 3, EnumCreatureType.monster, new BiomeGenBase[] { StarWarsMod.biomeTatooine });
		EntityRegistry.addSpawn(MobSandtrooper.class, 80, 5, 10, EnumCreatureType.monster, new BiomeGenBase[] { StarWarsMod.biomeTatooine });
		EntityRegistry.addSpawn(MobJawa.class, 30, 1, 5, EnumCreatureType.monster, new BiomeGenBase[] { StarWarsMod.biomeTatooine });
		EntityRegistry.addSpawn(MobTusken.class, 3, 1, 3, EnumCreatureType.monster, new BiomeGenBase[] { StarWarsMod.biomeTatooine });
		EntityRegistry.addSpawn(MobBantha.class, 7, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { StarWarsMod.biomeTatooine });
		EntityRegistry.addSpawn(MobDewback.class, 7, 1, 2, EnumCreatureType.creature, new BiomeGenBase[] { StarWarsMod.biomeTatooine });
		EntityRegistry.addSpawn(MobEwok.class, 10, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { StarWarsMod.biomeEndor, StarWarsMod.biomeEndorPlains });
		EntityRegistry.addSpawn(MobTauntaun.class, 6, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { StarWarsMod.biomeHoth });
		EntityRegistry.addSpawn(MobDroidProbe.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { StarWarsMod.biomeHoth });
		EntityRegistry.addSpawn(MobWampa.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { StarWarsMod.biomeHoth });
		EntityRegistry.addSpawn(MobWookiee.class, 10, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { StarWarsMod.biomeKashyyyk });
		Lumberjack.info("Entities, reporting for duty!");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\EntityRegister.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */