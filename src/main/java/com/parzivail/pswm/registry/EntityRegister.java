package com.parzivail.pswm.registry;

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
		EntityUtils.registerEntity(EntityCamera.class, "camera");
	}
}
