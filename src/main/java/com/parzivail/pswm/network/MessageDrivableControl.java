package com.parzivail.pswm.network;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.driven.DrivableBase;
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

	public MessageDrivableControl()
	{
	}

	public MessageDrivableControl(DrivableBase drivable)
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
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (context.side == Side.SERVER)
		{
			DrivableBase drivable = null;
			if (entity instanceof DrivableBase)
				drivable = (DrivableBase)entity;
			if (drivable != null)
				drivable.setPositionRotationAndMotion(posX, posY, posZ, yaw, pitch, roll, motX, motY, motZ, avelx, avely, avelz, throttle, steeringYaw);
		}
		else if (context.side == Side.CLIENT)
		{
			if (StarWarsMod.mc.thePlayer == null || StarWarsMod.mc.thePlayer.worldObj == null)
				return null;
			DrivableBase drivable = null;
			if (entity instanceof DrivableBase)
				drivable = (DrivableBase)entity;
			if (drivable != null)
				drivable.setPositionRotationAndMotion(posX, posY, posZ, yaw, pitch, roll, motX, motY, motZ, avelx, avely, avelz, throttle, steeringYaw);
		}

		return null;
	}
}
