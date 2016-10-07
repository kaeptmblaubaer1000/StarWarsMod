package com.parzivail.pswm.network;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.driven.EntitySeat;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.Entity;

public class MessageSeatUpdate extends PMessage<MessageSeatUpdate>
{
	public int seatId;
	public float yaw, pitch;
	public Entity entity;

	public MessageSeatUpdate()
	{
	}

	public MessageSeatUpdate(EntitySeat seat)
	{
		entity = seat.parent;
		seatId = seat.seatInfo.id;
		yaw = seat.looking.getYaw();
		pitch = seat.looking.getPitch();
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		Pilotable drivable = null;
		if (entity instanceof Pilotable)
			drivable = (Pilotable)entity;

		if (context.side == Side.SERVER)
		{
			if (drivable != null)
			{
				drivable.seats[seatId].prevLooking = drivable.seats[seatId].looking.clone();
				drivable.seats[seatId].looking.setAngles(yaw, pitch, 0F);
				//If on the server, update all surrounding players with these new angles
				StarWarsMod.network.sendToAllAround(this, new NetworkRegistry.TargetPoint(drivable.dimension, drivable.posX, drivable.posY, drivable.posZ, 100));
			}
		}
		else if (context.side == Side.CLIENT)
		{
			if (drivable != null)
			{
				//If this is the player who sent the packet in the first place, don't read it
				if (drivable.seats[seatId] == null || drivable.seats[seatId].riddenByEntity == StarWarsMod.mc.thePlayer)
					return null;
				drivable.seats[seatId].prevLooking = drivable.seats[seatId].looking.clone();
				drivable.seats[seatId].looking.setAngles(yaw, pitch, 0F);
			}
		}

		return null;
	}
}
