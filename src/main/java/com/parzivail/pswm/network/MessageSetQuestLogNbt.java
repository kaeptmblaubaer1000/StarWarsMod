package com.parzivail.pswm.network;

import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class MessageSetQuestLogNbt extends PMessage<MessageSetQuestLogNbt>
{
	public EntityPlayer player;
	public NBTTagCompound compound;

	public MessageSetQuestLogNbt()
	{
	}

	public MessageSetQuestLogNbt(EntityPlayer player, NBTTagCompound compound)
	{
		this.player = player;
		this.compound = compound;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.player == null || this.player.inventory == null || ItemQuestLog.getQuestContainer(player) == null)
			return null;
		ItemQuestLog.getQuestContainer(player).stackTagCompound = compound;
		return null;
	}

}