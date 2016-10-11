package com.parzivail.pswm.network;

import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;

public class MessageSetSeats extends PMessage<MessageSetSeats>
{
	public Entity entity;
	//	public EntitySeatOld[] seats;

	public MessageSetSeats()
	{
	}

	public MessageSetSeats(Pilotable entity/*, EntitySeatOld[] seats*/)
	{
		this.entity = entity;
		//		this.seats = seats;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		/*Pilotable ship = null;
		if (entity instanceof Pilotable)
			ship = (Pilotable)entity;

		if (ship != null)
		{
			ship.seats = seats;
			Lumberjack.debug("reset seats via message");
		}*/

		return null;
	}
}
