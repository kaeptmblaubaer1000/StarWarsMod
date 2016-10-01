package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import com.parzivail.util.vehicle.StarshipBase;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

public class MessageStarshipUpdateMovement extends PMessage<MessageStarshipUpdateMovement>
{
	public Entity entity;
	public Vec3 rotation;
	public Vec3 velocity;

	public MessageStarshipUpdateMovement()
	{
	}

	public MessageStarshipUpdateMovement(Entity entity, Vec3 rotation, Vec3 velocity)
	{
		this.entity = entity;
		this.rotation = rotation;
		this.velocity = velocity;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity instanceof StarshipBase)
		{
			StarshipBase ship = (StarshipBase)this.entity;
			ship.shipMovementHandler.rotation = rotation;
			ship.shipMovementHandler.velocity = velocity;
		}
		return null;
	}
}
