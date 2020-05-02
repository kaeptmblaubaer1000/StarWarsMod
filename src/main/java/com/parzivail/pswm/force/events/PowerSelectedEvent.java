package com.parzivail.pswm.force.events;

import com.parzivail.pswm.force.ForcePower;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Cancelable
@SideOnly(Side.CLIENT)
public class PowerSelectedEvent extends Event
{
	public ForcePower power;

	public PowerSelectedEvent(ForcePower power)
	{
		this.power = power;
	}
}
