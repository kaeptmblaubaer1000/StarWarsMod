package com.parzi.starwarsmod.registry;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.entities.EntityBlasterBolt;
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

public class EntityRegister
{
	public static void registerAll()
	{
		EntityUtils.registerMob(StarWarsMod.instance, MobWookiee.class, "wookiee", 80, 0x974F1A, 0x3C200A);
		EntityUtils.registerMob(StarWarsMod.instance, MobTusken.class, "tusken", 80, 0xFFFDB3, 0x5E5E4A);
		EntityUtils.registerMob(StarWarsMod.instance, MobJawa.class, "jawa", 80, 0xFF0000, 0x9B6C00);
		EntityUtils.registerMob(StarWarsMod.instance, MobEwok.class, "ewok", 80, 0x7e6c54, 0x3f362a);
		EntityUtils.registerMob(StarWarsMod.instance, MobTauntaun.class, "tauntaun", 80, 0xFFFFFF, 0x4ADCE8);
		EntityUtils.registerMob(StarWarsMod.instance, MobBantha.class, "bantha", 80, 0x8B4513, 0xFFDEAD);
		EntityUtils.registerMob(StarWarsMod.instance, MobWampa.class, "wampa", 80, 0xFFFFFF, 0x7F0000);

		EntityUtils.registerMob(StarWarsMod.instance, MobDroidAstromech.class, "droidAstromech", 80, 0xFFFFFF, 0x2D00FF);
		EntityUtils.registerMob(StarWarsMod.instance, MobGNK.class, "droidGonk", 80, 0x6B6B6B, 0x000000);

		EntityUtils.registerMob(StarWarsMod.instance, VehicSpeederBike.class, "speederBike", 80, 0x001F00, 0x003F00);
		EntityUtils.registerMob(StarWarsMod.instance, VehicLandspeeder.class, "landspeeder", 80, 0x1F0000, 0x3F0000);

		EntityUtils.registerEntity(StarWarsMod.instance, EntityBlasterBolt.class, "blasterBolt", 80);
	}
}
