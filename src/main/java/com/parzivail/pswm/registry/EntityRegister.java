package com.parzivail.pswm.registry;

import com.parzivail.pswm.entities.EntityBlasterHeavyBolt;
import com.parzivail.pswm.entities.EntityBlasterPistolBolt;
import com.parzivail.pswm.entities.EntityBlasterProbeBolt;
import com.parzivail.pswm.entities.EntityBlasterRifleBolt;
import com.parzivail.pswm.entities.EntityDestruction;
import com.parzivail.pswm.entities.EntitySpeederBlasterRifleBolt;
import com.parzivail.pswm.entities.EntityTIEBolt;
import com.parzivail.pswm.entities.EntityXWingBolt;
import com.parzivail.pswm.mobs.MobBantha;
import com.parzivail.pswm.mobs.MobBith;
import com.parzivail.pswm.mobs.MobDewback;
import com.parzivail.pswm.mobs.MobDroidAstromech;
import com.parzivail.pswm.mobs.MobDroidAstromech2;
import com.parzivail.pswm.mobs.MobDroidAstromechBb8;
import com.parzivail.pswm.mobs.MobDroidAstromechImperial;
import com.parzivail.pswm.mobs.MobDroidAstromechImperial2;
import com.parzivail.pswm.mobs.MobDroidGNK;
import com.parzivail.pswm.mobs.MobDroidMouse;
import com.parzivail.pswm.mobs.MobDroidProbe;
import com.parzivail.pswm.mobs.MobDroidProtocol;
import com.parzivail.pswm.mobs.MobDroidProtocol2;
import com.parzivail.pswm.mobs.MobDroidSurgical;
import com.parzivail.pswm.mobs.MobDroidTreadwell;
import com.parzivail.pswm.mobs.MobEwok;
import com.parzivail.pswm.mobs.MobGamorrean;
import com.parzivail.pswm.mobs.MobJawa;
import com.parzivail.pswm.mobs.MobSandtrooper;
import com.parzivail.pswm.mobs.MobTatooineCommoner;
import com.parzivail.pswm.mobs.MobTauntaun;
import com.parzivail.pswm.mobs.MobTusken;
import com.parzivail.pswm.mobs.MobWampa;
import com.parzivail.pswm.mobs.MobWookiee;
import com.parzivail.pswm.vehicles.VehicAWing;
import com.parzivail.pswm.vehicles.VehicHothSpeederBike;
import com.parzivail.pswm.vehicles.VehicJakkuSpeeder;
import com.parzivail.pswm.vehicles.VehicLandspeeder;
import com.parzivail.pswm.vehicles.VehicSpeederBike;
import com.parzivail.pswm.vehicles.VehicTIE;
import com.parzivail.pswm.vehicles.VehicTIEInterceptor;
import com.parzivail.pswm.vehicles.VehicXWing;
import com.parzivail.pswm.weaponry.WeaponDSTurret;
import com.parzivail.util.entity.EntityUtils;
import com.parzivail.util.ui.Lumberjack;

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
		EntityUtils.registerWithSpawnEgg(MobTatooineCommoner.class, "commoner", 0x6AC8D8, 0x6BD67B);
		EntityUtils.registerWithSpawnEgg(MobBith.class, "bith", 0xDBBA81, 0x000000);
		EntityUtils.registerWithSpawnEgg(MobSandtrooper.class, "sandtrooper", 0xFFFFFF, 0xFF611F);
		EntityUtils.registerEntity(MobDroidAstromech.class, "droidAstromech");
		EntityUtils.registerEntity(MobDroidAstromechImperial.class, "droidAstromechImperial");
		EntityUtils.registerEntity(MobDroidAstromechImperial2.class, "droidAstromechImperial2");
		EntityUtils.registerEntity(MobDroidAstromech2.class, "droidAstromech2");
		EntityUtils.registerEntity(MobDroidAstromechBb8.class, "droidAstromechBb8");
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
		EntityUtils.registerEntity(EntityDestruction.class, "destructionBolt");
		EntityUtils.registerEntity(EntitySpeederBlasterRifleBolt.class, "blasterSpeederRifleBolt");
		EntityUtils.registerEntity(EntityXWingBolt.class, "blasterXWingBolt");
		EntityUtils.registerEntity(EntityTIEBolt.class, "blasterTIEBolt");
		Lumberjack.info("Entities, reporting for duty!");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\EntityRegister.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */