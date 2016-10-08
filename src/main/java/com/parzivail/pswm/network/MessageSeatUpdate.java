package com.parzivail.pswm.network;

import com.parzivail.util.driven.EntitySeat;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;

public class MessageSeatUpdate extends PMessage<MessageSeatUpdate>
{
	public double posX, posY, posZ;
	public double motX, motY, motZ;
	public Entity entity;

	public MessageSeatUpdate()
	{
	}

	public MessageSeatUpdate(EntitySeat seat)
	{
		entity = seat;
		posX = seat.posX;
		posY = seat.posY;
		posZ = seat.posZ;
		motX = seat.motionX;
		motY = seat.motionY;
		motZ = seat.motionZ;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		EntitySeat seat = null;
		if (entity instanceof EntitySeat)
			seat = (EntitySeat)entity;
		if (seat != null)
		{
			seat.setPosition(posX, posY, posZ);
			seat.motionX = motX;
			seat.motionY = motY;
			seat.motionZ = motZ;

			if (seat.riddenByEntity != null)
			{
				seat.riddenByEntity.lastTickPosX = seat.riddenByEntity.prevPosX = seat.riddenByEntity.posX = posX;
				seat.riddenByEntity.lastTickPosY = seat.riddenByEntity.prevPosY = seat.riddenByEntity.posY = posY;
				seat.riddenByEntity.lastTickPosZ = seat.riddenByEntity.prevPosZ = seat.riddenByEntity.posZ = posZ;
			}
		}

		return null;
	}
}
