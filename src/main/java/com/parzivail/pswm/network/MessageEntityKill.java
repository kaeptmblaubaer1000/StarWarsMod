package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;

public class MessageEntityKill extends PMessage<MessageEntityKill>
{
	public Entity entity;

	public MessageEntityKill()
	{
	}

	public MessageEntityKill(Entity entity)
	{
		this.entity = entity;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity != null)
			entity.setDead();
		return null;
	}

}