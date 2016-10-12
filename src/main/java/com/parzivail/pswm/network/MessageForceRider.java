package com.parzivail.pswm.network;

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

	public MessageForceRider(/*EntitySeatOld seat, */Entity rider)
	{
		//		this.entity = seat;
		this.rider = rider;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		//		EntitySeatOld seat = null;
		//		if (entity instanceof EntitySeatOld)
		//			seat = (EntitySeatOld)entity;
		//
		//		if (seat != null)
		//		{
		//			seat.riddenByEntity = rider;
		//		}

		return null;
	}
}
