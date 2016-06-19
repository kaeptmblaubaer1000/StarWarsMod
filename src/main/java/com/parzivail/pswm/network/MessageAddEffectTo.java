package com.parzivail.pswm.network;

import com.parzivail.pswm.force.Cron;
import com.parzivail.pswm.utils.EntityCooldownEntry;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageAddEffectTo extends PMessage<MessageAddEffectTo>
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
		Cron.entitiesWithEffects.add(this.entry);
		return null;
	}
}
