package com.parzivail.pswm.registry;

import com.parzivail.pswm.entities.*;
import com.parzivail.pswm.mobs.*;
import com.parzivail.pswm.mobs.trooper.*;
import com.parzivail.pswm.turrets.GroundTurretImperial;
import com.parzivail.pswm.vehicles.*;
import com.parzivail.pswm.vehicles.npc.VehicNpcLandspeeder;
import com.parzivail.pswm.vehicles.npc.VehicNpcXWing;
import com.parzivail.util.entity.EntityUtils;
import com.parzivail.util.ui.Lumberjack;

public class EntityRegister
{
	public static void registerAll()
	{
		EntityUtils.registerWithSpawnEgg(MobSandtrooper.class, "sandtrooper", 0xFFFFFF, 0xFF611F);
		EntityUtils.registerWithSpawnEgg(MobStormtrooper.class, "stormtrooper", 0xFFFFFF, 0x000000);
		EntityUtils.registerWithSpawnEgg(MobScouttrooper.class, "scouttrooper", 0xFFFFFF, 0x003300);
		EntityUtils.registerWithSpawnEgg(MobSnowtrooper.class, "snowtrooper", 0xF9FFD4, 0x919191);
		EntityUtils.registerWithSpawnEgg(MobAtatPilot.class, "atatPilot", 0xFFFFFF, 0x919191);
		EntityUtils.registerWithSpawnEgg(MobTiePilot.class, "tiePilot", 0x000000, 0x919191);
		EntityUtils.registerWithSpawnEgg(MobImperialOfficer.class, "imperialOfficer", 0x000000, 0x919191);
		EntityUtils.registerWithSpawnEgg(MobAtstPilot.class, "atstPilot", 0x000000, 0x919191);

		EntityUtils.registerWithSpawnEgg(MobEndorRebel.class, "endorRebel", 0x17BF3E, 0x318F47);
		EntityUtils.registerWithSpawnEgg(MobHothRebel.class, "hothRebel", 0xF0F4FF, 0xE3EDCE);
		EntityUtils.registerWithSpawnEgg(MobRebelPilot.class, "rebelPilot", 0xF0A646, 0xD9D8D7);
		EntityUtils.registerWithSpawnEgg(MobRebelPilotA.class, "rebelPilotA", 0xF0A646, 0xD9D8D7);
		EntityUtils.registerWithSpawnEgg(MobRebelPilotY.class, "rebelPilotY", 0xF0A646, 0xD9D8D7);
		EntityUtils.registerWithSpawnEgg(MobRebelWorker.class, "rebelWorker", 0xF0A646, 0xD9D8D7);
		EntityUtils.registerWithSpawnEgg(MobRebelTechnician.class, "rebelTechnician", 0xF0A646, 0xD9D8D7);

		EntityUtils.registerWithSpawnEgg(MobBountyhunter.class, "bountyhunter", 0x3EA877, 0x9CBD8F);

		EntityUtils.registerEntity(MobDefaultBiped.class, "defaultBiped");
		EntityUtils.registerEntity(MobYodaBiped.class, "yodaBiped");

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
		//EntityUtils.registerWithSpawnEgg(MobBith.class, "bith", 0xDBBA81, 0x000000);
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
		EntityUtils.registerEntity(MobDroidMouse.class, "droidMouse");
		EntityUtils.registerEntity(MobDroidTrainingRemote.class, "droidTrainingRemote");
		EntityUtils.registerEntity(VehicHothSpeederBike.class, "hothSpeederBike");
		EntityUtils.registerEntity(VehicTIE.class, "tie");
		EntityUtils.registerEntity(VehicTIEBomber.class, "tieBomber");
		EntityUtils.registerEntity(VehicTIEAdvanced.class, "tieAdvanced");
		EntityUtils.registerEntity(VehicTIEInterceptor.class, "tieInterceptor");
		EntityUtils.registerEntity(VehicXWing.class, "xwing");
		EntityUtils.registerEntity(VehicYWing.class, "ywing");
		EntityUtils.registerEntity(VehicAWing.class, "awing");
		EntityUtils.registerEntity(VehicATST.class, "atst");
		EntityUtils.registerEntity(VehicSnowspeeder.class, "snowspeeder");
		EntityUtils.registerEntity(VehicScootemaround.class, "scootemaround");
		EntityUtils.registerEntity(VehicScootemaroundHoth.class, "scootemaroundHoth");
		EntityUtils.registerEntity(VehicSkyhopper.class, "skyhopper");
		EntityUtils.registerEntity(VehicSpeederBike.class, "speederBike");
		EntityUtils.registerEntity(VehicLandspeeder.class, "landspeeder");
		EntityUtils.registerEntity(VehicNpcLandspeeder.class, "landspeederNpc");
		EntityUtils.registerEntity(VehicNpcXWing.class, "xwingNpc");
		EntityUtils.registerEntity(VehicJakkuSpeeder.class, "jakkuSpeeder");
		EntityUtils.registerEntity(EntityBlasterVariableBolt.class, "blasterBolt");
		EntityUtils.registerEntity(EntityBlasterEzraBolt.class, "blasterEzraBolt");
		EntityUtils.registerEntity(EntityBlasterRifleBolt.class, "blasterRifleBolt");
		EntityUtils.registerEntity(EntityBlasterHeavyBolt.class, "blasterHeavyBolt");
		EntityUtils.registerEntity(EntityBlasterProbeBolt.class, "blasterProbeBolt");
		EntityUtils.registerEntity(EntityProtonTorpedo.class, "protonTorpedo");
		EntityUtils.registerEntity(EntityBomb.class, "tieBomb");
		EntityUtils.registerEntity(EntityDestruction.class, "destructionBolt");
		EntityUtils.registerEntity(EntitySpeederBlasterRifleBolt.class, "blasterSpeederRifleBolt");
		EntityUtils.registerEntity(EntityXWingBolt.class, "blasterXWingBolt");
		EntityUtils.registerEntity(EntityTIEBolt.class, "blasterTIEBolt");
		EntityUtils.registerEntity(EntityBlasterBoltPlayer.class, "blasterBoltRed");
		EntityUtils.registerEntity(EntityBlasterBoltEntity.class, "blasterBoltEntityRed");

		// New Turrets
		EntityUtils.registerEntity(GroundTurretImperial.class, "imperialGroundTurret");
		// Turrets laser
		EntityUtils.registerEntity(EntityLaserTurret.class, "imperialGroundTurret");

		EntityUtils.registerEntity(EntityThrownSaber.class, "thrownSaber");

		Lumberjack.info("Entities, reporting for duty!");
	}
}
