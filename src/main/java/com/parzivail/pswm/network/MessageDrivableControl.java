package com.parzivail.pswm.network;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.handler.NetworkHandler;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.network.PMessage;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageDrivableControl extends PMessage<MessageDrivableControl>
{
	public double posX, posY, posZ;
	public float yaw, pitch, roll;
	public double motX, motY, motZ;
	public float avelx, avely, avelz;
	public float throttle;
	public float steeringYaw;
	public Entity entity;
	//public EntitySeatOld[] seats;

	public MessageDrivableControl()
	{
	}

	public MessageDrivableControl(Pilotable drivable)
	{
		entity = drivable;
		posX = drivable.posX;
		posY = drivable.posY;
		posZ = drivable.posZ;
		yaw = drivable.axes.getYaw();
		pitch = drivable.axes.getPitch();
		roll = drivable.axes.getRoll();
		motX = drivable.motionX;
		motY = drivable.motionY;
		motZ = drivable.motionZ;
		avelx = drivable.angularVelocity.x;
		avely = drivable.angularVelocity.y;
		avelz = drivable.angularVelocity.z;
		throttle = drivable.throttle;
		//seats = drivable.seats;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (context.side == Side.SERVER)
		{
			Pilotable pilotable = null;
			if (entity instanceof Pilotable)
				pilotable = (Pilotable)entity;
			if (pilotable != null)
			{
				pilotable.setPositionRotationAndMotion(posX, posY, posZ, yaw, pitch, roll, motX, motY, motZ, avelx, avely, avelz, throttle, steeringYaw);

				NetworkHandler.INSTANCE.sendToDimension(new MessageDrivableControl(pilotable), pilotable.dimension);
			}
		}
		else if (context.side == Side.CLIENT)
		{
			if (PSWM.mc.player == null || PSWM.mc.player.world == null)
				return null;
			Pilotable pilotable = null;
			if (entity instanceof Pilotable)
				pilotable = (Pilotable)entity;
			if (pilotable != null && pilotable.getControllingPassenger() != PSWM.mc.player)
			{
				pilotable.setPositionRotationAndMotion(posX, posY, posZ, yaw, pitch, roll, motX, motY, motZ, avelx, avely, avelz, throttle, steeringYaw);
			}
		}

		return null;
	}
}
