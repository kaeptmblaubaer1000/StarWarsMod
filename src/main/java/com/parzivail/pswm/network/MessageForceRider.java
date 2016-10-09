package com.parzivail.pswm.network;

import com.parzivail.util.driven.EntitySeat;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;

public class MessageForceRider extends PMessage<MessageForceRider>
{
	public Entity entity;
	public Entity rider;

	public MessageForceRider()
	{
	}

	public MessageForceRider(EntitySeat seat, Entity rider)
	{
		this.entity = seat;
		this.rider = rider;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		EntitySeat seat = null;
		if (entity instanceof EntitySeat)
			seat = (EntitySeat)entity;

		if (seat != null)
		{
			seat.riddenByEntity = rider;
		}

		return null;
	}
}
