package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;

public class MessageStarshipUpdateMovement extends PMessage<MessageStarshipUpdateMovement>
{
	public double posX, posY, posZ, motX, motY, motZ;
	public float yaw, pitch, roll, throttle;
	public Entity vehic;

	public MessageStarshipUpdateMovement()
	{
	}

	/*public MessageStarshipUpdateMovement(StarshipBase vehic)
	{
		this.vehic = vehic;
		posX = vehic.posX;
		posY = vehic.posY;
		posZ = vehic.posZ;
		yaw = vehic.axes.getYaw();
		pitch = vehic.axes.getPitch();
		roll = vehic.axes.getRoll();
		motX = vehic.motionX;
		motY = vehic.motionY;
		motZ = vehic.motionZ;
		throttle = vehic.shipMovementHandler.throttle;
	}*/

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		/*if (this.vehic instanceof StarshipBase)
		{
			StarshipBase ssb = ((StarshipBase)vehic);
			ssb.setPositionRotationAndMotion(posX, posY, posZ, yaw, pitch, roll, motX, motY, motZ);
			ssb.shipMovementHandler.throttle = this.throttle;
		}
		return null;*/
		return null;
	}
}
