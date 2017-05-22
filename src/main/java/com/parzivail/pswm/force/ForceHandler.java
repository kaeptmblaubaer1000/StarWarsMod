package com.parzivail.pswm.force;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by colby on 5/19/2017.
 */
public class ForceHandler
{
	public static final IForcePower[] FORCE_POWERS = new IForcePower[] { new ForcePowerEmpty() };

	private static int currentPowerIdx = 0;

	public static boolean isCurrentPower(ForcePowerAttribute attribute)
	{
		return FORCE_POWERS[currentPowerIdx].getAttributes().contains(attribute);
	}

	public static void useCurrentPower(EntityPlayer player)
	{
		FORCE_POWERS[currentPowerIdx].use(player);
	}
}
