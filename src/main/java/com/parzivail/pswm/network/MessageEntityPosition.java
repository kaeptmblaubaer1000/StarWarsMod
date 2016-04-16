package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

public class MessageEntityPosition extends PMessage<MessageEntityPosition>
{
	public Entity entity;
	public Vec3 position;

	public MessageEntityPosition()
	{
	}

	public MessageEntityPosition(Entity entity, Vec3 position)
	{
		this.entity = entity;
		this.position = position;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity != null)
		{
			this.entity.setPosition(position.xCoord, position.yCoord, position.zCoord);
		}
		return null;
	}
}
