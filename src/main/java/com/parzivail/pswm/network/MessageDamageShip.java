package com.parzivail.pswm.network;

import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;

/**
 * Created by colby on 10/23/2016.
 */
public class MessageDamageShip extends PMessage<MessageDamageShip>
{
	public Entity entity;
	public String damageType;
	public float amount;

	public MessageDamageShip()
	{
	}

	public MessageDamageShip(Pilotable entity, DamageSource source, float amount)
	{
		this.entity = entity;
		this.damageType = source.damageType;
		this.amount = amount;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity instanceof Pilotable)
			((Pilotable)this.entity).processDamage(damageType, amount);
		return null;
	}

}