package com.parzivail.pswm.network;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageEntityReverse extends Message<MessageEntityReverse>
{
	public Entity entity;

	public MessageEntityReverse()
	{
	}

	public MessageEntityReverse(Entity entity)
	{
		this.entity = entity;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity != null)
		{
			entity.motionX = -entity.motionX;
			entity.motionY = -entity.motionY;
			entity.motionZ = -entity.motionZ;
		}
		return null;
	}
}
