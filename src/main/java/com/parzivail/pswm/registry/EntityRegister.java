package com.parzivail.pswm.registry;

import com.parzivail.pswm.entity.EntityBlasterBoltBase;
import com.parzivail.pswm.entity.EntityBlasterVariableBolt;
import com.parzivail.pswm.entity.EntityXWingBolt;
import com.parzivail.pswm.vehicle.*;
import com.parzivail.util.EntityUtils;
import com.parzivail.util.driven.EntityCamera;

/**
 * Created by colby on 1/15/2017.
 */
public class EntityRegister
{
	public static void register()
	{
		EntityUtils.registerEntity(VehicXWing.class, "xwing");
		EntityUtils.registerEntity(VehicUWing.class, "uwing");
		EntityUtils.registerEntity(VehicTIEStriker.class, "tiestriker");
		EntityUtils.registerEntity(VehicTIE.class, "tie");
		EntityUtils.registerEntity(VehicJR4Swoop.class, "jr4swoop");
		EntityUtils.registerEntity(VehicAWing.class, "awing");
		EntityUtils.registerEntity(VehicHothScoot.class, "hothscoot");
		EntityUtils.registerEntity(VehicJakkuSpeeder.class, "jakkuspeeder");
		EntityUtils.registerEntity(VehicLandspeeder.class, "landspeeder");
		EntityUtils.registerEntity(VehicScootEmAround.class, "scootemaround");
		EntityUtils.registerEntity(VehicSkyhopper.class, "skyhopper");
		EntityUtils.registerEntity(VehicSnowspeeder.class, "snowspeeder");
		EntityUtils.registerEntity(VehicSpeederBike.class, "speederbike");
		EntityUtils.registerEntity(VehicT85.class, "t85");
		EntityUtils.registerEntity(VehicTIEAdvanced.class, "tieadvanced");
		EntityUtils.registerEntity(VehicTIEBomber.class, "tiebomber");
		EntityUtils.registerEntity(VehicTIEInterceptor.class, "tieinterceptor");
		EntityUtils.registerEntity(VehicYWing.class, "ywing");
		EntityUtils.registerEntity(VehicT13.class, "t13");

		EntityUtils.registerEntity(EntityBlasterBoltBase.class, "blasterbolt");
		EntityUtils.registerEntity(EntityBlasterVariableBolt.class, "variableblasterbolt");
		EntityUtils.registerEntity(EntityXWingBolt.class, "xwingblasterbolt");

		EntityUtils.registerEntity(EntityCamera.class, "camera");
	}
}
