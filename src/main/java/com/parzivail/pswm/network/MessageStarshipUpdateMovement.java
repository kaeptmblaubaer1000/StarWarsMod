package com.parzivail.pswm.network;

import com.parzivail.util.math.RotatedAxes;
import com.parzivail.util.network.PMessage;
import com.parzivail.util.vehicle.StarshipBase;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

public class MessageStarshipUpdateMovement extends PMessage<MessageStarshipUpdateMovement>
{
	public Entity entity;
	public Vec3 velocity;
	public Vec3 rotVel;
	public RotatedAxes axes;

	public MessageStarshipUpdateMovement()
	{
	}

	public MessageStarshipUpdateMovement(StarshipBase entity)
	{
		this.entity = entity;
		this.axes = entity.axes;
		this.velocity = entity.shipMovementHandler.velocity;
		this.rotVel = entity.shipMovementHandler.rotVel;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity instanceof StarshipBase)
		{
			StarshipBase ship = (StarshipBase)this.entity;
			ship.axes = this.axes;
			ship.shipMovementHandler.velocity = this.velocity;
			ship.shipMovementHandler.rotVel = this.rotVel;
		}
		return null;
	}
}
