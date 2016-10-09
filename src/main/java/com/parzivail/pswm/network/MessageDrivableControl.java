package com.parzivail.pswm.network;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.driven.EntitySeat;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.Entity;

public class MessageDrivableControl extends PMessage<MessageDrivableControl>
{
	public double posX, posY, posZ;
	public float yaw, pitch, roll;
	public double motX, motY, motZ;
	public float avelx, avely, avelz;
	public float throttle;
	public float steeringYaw;
	public Entity entity;
	public EntitySeat[] seats;

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
		seats = drivable.seats;
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

				pilotable.seats = seats;
				for (EntitySeat seat : pilotable.seats)
				{
					seat.updatePosition();
					seat.setPosition(seat.playerPosX, seat.playerPosY, seat.playerPosZ);
				}
			}
		}
		else if (context.side == Side.CLIENT)
		{
			if (StarWarsMod.mc.thePlayer == null || StarWarsMod.mc.thePlayer.worldObj == null)
				return null;
			Pilotable pilotable = null;
			if (entity instanceof Pilotable)
				pilotable = (Pilotable)entity;
			if (pilotable != null)
			{
				if (pilotable.seats[0] != null && pilotable.seats[0].riddenByEntity == StarWarsMod.mc.thePlayer)
					return null;

				pilotable.setPositionRotationAndMotion(posX, posY, posZ, yaw, pitch, roll, motX, motY, motZ, avelx, avely, avelz, throttle, steeringYaw);

				pilotable.seats = seats;
				for (EntitySeat seat : pilotable.seats)
				{
					seat.updatePosition();
					seat.setPosition(seat.playerPosX, seat.playerPosY, seat.playerPosZ);
				}
			}
		}

		return null;
	}
}
