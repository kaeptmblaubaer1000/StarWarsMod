package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import com.parzivail.util.vehicle.VehicleAirBase;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

public class MessageShipTargetLock extends PMessage<MessageShipTargetLock>
{
	public EntityPlayer player;
	public boolean lock;

	public MessageShipTargetLock()
	{
	}

	public MessageShipTargetLock(EntityPlayer player, boolean lock)
	{
		this.player = player;
		this.lock = lock;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (player == null)
			return null;

		if (player.ridingEntity instanceof VehicleAirBase)
			((VehicleAirBase)player.ridingEntity).setTargetLock(this.lock);
		return null;
	}
}