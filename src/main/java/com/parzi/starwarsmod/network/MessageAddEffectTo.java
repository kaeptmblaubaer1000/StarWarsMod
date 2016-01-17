package com.parzi.starwarsmod.network;

import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.starwarsmod.utils.ForceUtils.EntityCooldownEntry;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageAddEffectTo extends Message<MessageAddEffectTo>
{
	public EntityCooldownEntry entry;

	public MessageAddEffectTo()
	{
	}

	public MessageAddEffectTo(EntityCooldownEntry entry)
	{
		this.entry = entry;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		ForceUtils.entitiesWithEffects.add(this.entry);
		return null;
	}
}
