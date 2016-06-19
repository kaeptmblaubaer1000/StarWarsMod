package com.parzivail.pswm.network;

import com.parzivail.pswm.force.Cron;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

public class MessageRobesStringNBT extends PMessage<MessageRobesStringNBT>
{
	public EntityPlayer player;
	public String key;
	public String value;

	public MessageRobesStringNBT()
	{
	}

	public MessageRobesStringNBT(EntityPlayer player, String key, String value)
	{
		this.player = player;
		this.key = key;
		this.value = value;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.player == null || this.player.inventory == null)
			return null;
		if (Cron.getHolocron(player) != null && Cron.getHolocron(player).hasTagCompound())
			Cron.getHolocron(player).stackTagCompound.setString(this.key, this.value);
		return null;
	}

}