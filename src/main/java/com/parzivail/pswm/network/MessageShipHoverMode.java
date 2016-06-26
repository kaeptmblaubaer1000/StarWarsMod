package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import com.parzivail.util.vehicle.VehicleAirBase;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

public class MessageShipHoverMode extends PMessage<MessageShipHoverMode>
{
	public EntityPlayer player;
	public boolean hover;

	public MessageShipHoverMode()
	{
	}

	public MessageShipHoverMode(EntityPlayer player, boolean hover)
	{
		this.player = player;
		this.hover = hover;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (player.ridingEntity instanceof VehicleAirBase)
		{
			((VehicleAirBase)player.ridingEntity).setHoverMode(this.hover);
			((VehicleAirBase)player.ridingEntity).move = ((VehicleAirBase)player.ridingEntity).moveModifier;
		}
		return null;
	}
}