package com.parzivail.pswm.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import com.parzivail.pswm.world.TransferDim;
import com.parzivail.util.network.PMessage;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageHyperdrive extends PMessage<MessageHyperdrive>
{
	public EntityPlayer player;
	public int destDim;

	public MessageHyperdrive()
	{
	}

	public MessageHyperdrive(EntityPlayer player, int destDim)
	{
		this.player = player;
		this.destDim = destDim;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		new TransferDim(MinecraftServer.getServer().worldServerForDimension(this.destDim)).teleport(this.player);
		this.player.setSneaking(false);
		return null;
	}
}
