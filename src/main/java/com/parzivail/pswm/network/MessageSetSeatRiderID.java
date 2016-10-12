package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;

public class MessageSetSeatRiderID extends PMessage<MessageSetSeatRiderID>
{
	public Entity entity;
	int riderId;

	public MessageSetSeatRiderID()
	{
	}

	public MessageSetSeatRiderID(/*EntitySeatOld seat, */int riderId)
	{
		//		this.entity = seat;
		this.riderId = riderId;
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
		//			seat.riderId = riderId;
		//		}

		return null;
	}
}
