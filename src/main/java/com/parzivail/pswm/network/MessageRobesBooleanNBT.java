package com.parzivail.pswm.network;

import net.minecraft.entity.player.EntityPlayer;

import com.parzivail.util.network.PMessage;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageRobesBooleanNBT extends PMessage<MessageRobesBooleanNBT>
{
	public EntityPlayer player;
	public String key;
	public boolean value;

	public MessageRobesBooleanNBT()
	{
	}

	public MessageRobesBooleanNBT(EntityPlayer player, String key, boolean value)
	{
		this.player = player;
		this.key = key;
		this.value = value;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.player == null || this.player.inventory == null) return null;
		this.player.inventory.armorInventory[2].stackTagCompound.setBoolean(this.key, this.value);
		return null;
	}

}