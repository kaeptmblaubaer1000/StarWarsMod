package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHeal extends PMessage<MessageHeal>
{
	public Entity entity;
	public float amount;

	public MessageHeal()
	{
	}

	public MessageHeal(Entity entity, float amount)
	{
		this.entity = entity;
		this.amount = amount;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity != null && entity instanceof EntityLiving)
		{
			EntityLiving entityLiving = (EntityLiving)entity;
			entityLiving.heal(this.amount);
			Lumberjack.debug("Healed " + entityLiving);
		}
		else if (this.entity != null && entity instanceof EntityPlayer)
		{
			EntityPlayer entityLiving = (EntityPlayer)entity;
			entityLiving.heal(this.amount);
			Lumberjack.debug("Healed " + entityLiving);
		}
		return null;
	}
}
