package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

public class MessageSetPlayerPosition extends PMessage<MessageSetPlayerPosition>
{
	public EntityPlayer player;
	public double x;
	public double y;
	public double z;

	public MessageSetPlayerPosition()
	{
	}

	public MessageSetPlayerPosition(EntityPlayer player, double x, double y, double z)
	{
		this.player = player;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		player.prevPosX = player.posX = x;
		player.prevPosY = player.posY = y;
		player.prevPosZ = player.posZ = z;

		Lumberjack.debug(String.format("set pos to %s %s %s", x, y, z));

		return null;
	}
}
