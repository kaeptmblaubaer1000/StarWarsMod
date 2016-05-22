package com.parzivail.pswm.network;

import com.parzivail.pswm.jedi.JediUtils;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

public class MessageRobesIntNBT extends PMessage<MessageRobesIntNBT>
{
	public EntityPlayer player;
	public String key;
	public int value;

	public MessageRobesIntNBT()
	{
	}

	public MessageRobesIntNBT(EntityPlayer player, String key, int value)
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
		JediUtils.getHolocron(this.player).stackTagCompound.setInteger(this.key, this.value);
		return null;
	}

}