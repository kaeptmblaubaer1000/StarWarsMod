package com.parzivail.pswm.network;

import com.parzivail.pswm.jedirobes.ArmorJediRobes;
import com.parzivail.util.network.PMessage;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class MessageDrainKnowledge extends PMessage<MessageDrainKnowledge>
{
	public Entity entity;
	public int amount;

	public MessageDrainKnowledge()
	{
	}

	public MessageDrainKnowledge(Entity entity, int amount)
	{
		this.entity = entity;
		this.amount = amount;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity != null && entity instanceof EntityPlayer)
		{
			EntityPlayer entityLiving = (EntityPlayer)entity;
			entityLiving.heal(this.amount);
			ArmorJediRobes.setXP(entityLiving, ArmorJediRobes.getXP(entityLiving) - amount);
			Lumberjack.log("Drained " + entityLiving);
		}
		return null;
	}
}
