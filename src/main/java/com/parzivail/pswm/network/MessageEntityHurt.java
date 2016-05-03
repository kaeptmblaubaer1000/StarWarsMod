package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;

public class MessageEntityHurt extends PMessage<MessageEntityHurt>
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