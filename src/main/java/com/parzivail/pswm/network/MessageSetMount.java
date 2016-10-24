package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;

public class MessageSetMount extends PMessage<MessageSetMount>
{
	public Entity entity;
	public Entity mount;

	public MessageSetMount()
	{
	}

	public MessageSetMount(Entity entity, Entity mount)
	{
		this.entity = entity;
		this.mount = mount;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity != null)
			entity.mountEntity(mount);
		return null;
	}

}