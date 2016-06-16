package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

public class MessageToggleLightsaber extends PMessage<MessageToggleLightsaber>
{
	public EntityPlayer player;

	public MessageToggleLightsaber()
	{
	}

	public MessageToggleLightsaber(EntityPlayer player)
	{
		this.player = player;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		return null;
	}

}