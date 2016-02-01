package com.parzivail.pswm.network;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageEntityHurt extends Message<MessageEntityHurt>
{
	public Entity entity;
	public float amount;

	public MessageEntityHurt()
	{
	}

	public MessageEntityHurt(Entity entity, float amount)
	{
		this.entity = entity;
		this.amount = amount;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity != null)
			this.entity.attackEntityFrom(DamageSource.magic, this.amount);
		return null;
	}

}