package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;

public class MessageSetPosition extends PMessage<MessageSetPosition>
{
	public Entity entity;
	public double x;
	public double y;
	public double z;

	public MessageSetPosition()
	{
	}

	public MessageSetPosition(Entity entity, double x, double y, double z)
	{
		this.entity = entity;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (entity != null)
		{
			entity.prevPosX = entity.posX = x;
			entity.prevPosY = entity.posY = y;
			entity.prevPosZ = entity.posZ = z;
			entity.velocityChanged = true;

			if (entity.riddenByEntity != null)
			{
				entity.riddenByEntity.prevPosX = entity.riddenByEntity.posX = x;
				entity.riddenByEntity.prevPosY = entity.riddenByEntity.posY = y;
				entity.riddenByEntity.prevPosZ = entity.riddenByEntity.posZ = z;
				entity.velocityChanged = true;
			}
		}

		return null;
	}
}
