package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import com.parzivail.util.vehicle.DrivenBase;
import com.parzivail.util.vehicle.StarshipBase;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageStarshipUpdateMovement extends PMessage<MessageStarshipUpdateMovement>
{
	public double posX, posY, posZ;
	public float yaw, pitch, roll;
	public double motX;
	public double motY;
	public double motZ;
	public DrivenBase vehic;

	public MessageStarshipUpdateMovement()
	{
	}

	public MessageStarshipUpdateMovement(DrivenBase vehic)
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
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.vehic instanceof StarshipBase)
			vehic.setPositionRotationAndMotion(posX, posY, posZ, yaw, pitch, roll, motX, motY, motZ);
		return null;
	}
}
