package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;

public class MessageEntityReverse extends PMessage<MessageEntityReverse>
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
			this.entity.motionX = -this.entity.motionX;
			this.entity.motionY = -this.entity.motionY;
			this.entity.motionZ = -this.entity.motionZ;
		}
		return null;
	}
}
