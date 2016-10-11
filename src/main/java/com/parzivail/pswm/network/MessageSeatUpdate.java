package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSeatUpdate extends PMessage<MessageSeatUpdate>
{
	public int entityId, seatId;
	public float yaw, pitch;

	public MessageSeatUpdate()
	{
	}

	public MessageSeatUpdate(byte nil/*EntitySeatOld seat*/)
	{
		/*entityId = seat.parent.getEntityId();
		seatId = seat.seatInfo.id;
		yaw = seat.looking.getYaw();
		pitch = seat.looking.getPitch();*/
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		/*if (context.side == Side.SERVER)
		{
			Pilotable pilotable = null;
			for (Object obj : context.getServerHandler().playerEntity.worldObj.loadedEntityList)
			{
				if (obj instanceof Pilotable && ((Entity)obj).getEntityId() == entityId)
				{
					pilotable = (Pilotable)obj;
					break;
				}
			}
			if (pilotable != null)
			{
				pilotable.seats[seatId].prevLooking = pilotable.seats[seatId].looking.clone();
				pilotable.seats[seatId].looking.setAngles(yaw, pitch, 0F);
				//If on the server, update all surrounding players with these new angles
				StarWarsMod.network.sendToAllAround(this, new NetworkRegistry.TargetPoint(pilotable.dimension, pilotable.posX, pilotable.posY, pilotable.posZ, 100));
			}
		}
		else if (context.side == Side.CLIENT)
		{
			Pilotable pilotable = null;
			for (int i = 0; i < StarWarsMod.mc.thePlayer.worldObj.loadedEntityList.size(); i++)
			{
				Object obj = StarWarsMod.mc.thePlayer.worldObj.loadedEntityList.get(i);
				if (obj instanceof Pilotable && ((Entity)obj).getEntityId() == entityId)
				{
					pilotable = (Pilotable)obj;
					break;
				}
			}
			if (pilotable != null)
			{
				//If this is the player who sent the packet in the first place, don't read it
				if (pilotable.seats[seatId] == null || pilotable.seats[seatId].riddenByEntity == StarWarsMod.mc.thePlayer)
					return null;
				pilotable.seats[seatId].prevLooking = pilotable.seats[seatId].looking.clone();
				pilotable.seats[seatId].looking.setAngles(yaw, pitch, 0F);
			}
		}*/
		return null;
	}
}
