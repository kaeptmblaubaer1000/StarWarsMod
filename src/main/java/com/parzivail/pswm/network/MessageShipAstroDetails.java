package com.parzivail.pswm.network;

import com.parzivail.pswm.vehicles.VehicXWing;
import com.parzivail.util.network.PMessage;
import com.parzivail.util.vehicle.VehicleAirBase;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class MessageShipAstroDetails extends PMessage<MessageShipAstroDetails>
{
	public Entity ship;
	public EntityPlayer player;
	public boolean astro;
	public int type;

	public MessageShipAstroDetails()
	{
	}

	public MessageShipAstroDetails(VehicleAirBase ship, EntityPlayer player, boolean astro, int type)
	{
		this.ship = ship;
		this.astro = astro;
		this.player = player;
		this.type = type;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (ship instanceof VehicXWing)
		{
			((VehicXWing)ship).setAstroType(type);
			((VehicXWing)ship).setHasAstro(astro);
			player.inventory.mainInventory[player.inventory.currentItem] = null;
		}
		return null;
	}
}