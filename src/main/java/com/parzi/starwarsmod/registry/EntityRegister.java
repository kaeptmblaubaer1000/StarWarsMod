package com.parzi.starwarsmod.registry;

import com.parzi.starwarsmod.entities.EntityBlasterPistolBolt;
import com.parzi.starwarsmod.entities.EntityBlasterRifleBolt;
import com.parzi.starwarsmod.mobs.MobBantha;
import com.parzi.starwarsmod.mobs.MobDroidAstromech;
import com.parzi.starwarsmod.mobs.MobEwok;
import com.parzi.starwarsmod.mobs.MobGNK;
import com.parzi.starwarsmod.mobs.MobJawa;
import com.parzi.starwarsmod.mobs.MobTauntaun;
import com.parzi.starwarsmod.mobs.MobTusken;
import com.parzi.starwarsmod.mobs.MobWampa;
import com.parzi.starwarsmod.mobs.MobWookiee;
import com.parzi.starwarsmod.utils.EntityUtils;
import com.parzi.starwarsmod.vehicles.VehicLandspeeder;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;
import com.parzi.starwarsmod.weaponry.WeaponDSTurret;

public class EntityRegister
{
	public static void registerAll()
	{
		EntityUtils.registerMob(MobWookiee.class, "wookiee", 0x974F1A, 0x3C200A);
		EntityUtils.registerMob(MobTusken.class, "tusken", 0xFFFDB3, 0x5E5E4A);
		EntityUtils.registerMob(MobJawa.class, "jawa", 0xFF0000, 0x9B6C00);
		EntityUtils.registerMob(MobEwok.class, "ewok", 0x7e6c54, 0x3f362a);
		EntityUtils.registerMob(MobTauntaun.class, "tauntaun", 0xFFFFFF, 0x4ADCE8);
		EntityUtils.registerMob(MobBantha.class, "bantha", 0x8B4513, 0xFFDEAD);
		EntityUtils.registerMob(MobWampa.class, "wampa", 0xFFFFFF, 0x7F0000);

		EntityUtils.registerMob(MobDroidAstromech.class, "droidAstromech", 0xFFFFFF, 0x2D00FF);
		EntityUtils.registerMob(MobGNK.class, "droidGonk", 0x6B6B6B, 0x000000);

		EntityUtils.registerMob(VehicSpeederBike.class, "speederBike", 0x001F00, 0x003F00);
		EntityUtils.registerMob(VehicLandspeeder.class, "landspeeder", 0x1F0000, 0x3F0000);

		EntityUtils.registerMob(WeaponDSTurret.class, "dsTurret", 0x000000, 0x000000);

		EntityUtils.registerEntity(EntityBlasterPistolBolt.class, "blasterBolt");
		EntityUtils.registerEntity(EntityBlasterRifleBolt.class, "blasterRifleBolt");
	}
}
