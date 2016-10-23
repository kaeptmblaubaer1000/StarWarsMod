package com.parzivail.pswm.network;

import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.driven.Seat;
import com.parzivail.util.driven.ShipData;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;

/**
 * Created by colby on 10/23/2016.
 */
public class MessageShipData extends PMessage<MessageShipData>
{
	public Entity entity;
	public ShipData data;

	public MessageShipData()
	{
	}

	public MessageShipData(Pilotable entity)
	{
		this.entity = entity;
		this.data = entity.data;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity instanceof Pilotable)
		{
			Seat[] seats = ((Pilotable)this.entity).data.seatInfo;
			((Pilotable)this.entity).data = data;
			((Pilotable)this.entity).data.seatInfo = seats;
		}
		return null;
	}

}