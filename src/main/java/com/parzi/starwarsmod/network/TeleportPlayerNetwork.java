package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;

import com.parzi.starwarsmod.world.TransferDim;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class TeleportPlayerNetwork implements IMessage
{

	public static class Handler implements IMessageHandler<TeleportPlayerNetwork, IMessage>
	{

		@Override
		public IMessage onMessage(TeleportPlayerNetwork message, MessageContext ctx)
		{
			new TransferDim(MinecraftServer.getServer().worldServerForDimension(message.newDim)).teleport(MinecraftServer.getServer().worldServerForDimension(message.oldDim).getPlayerEntityByName(message.player));
			return null; // no response in this case
		}
	}

	private String player;
	private int oldDim;

	private int newDim;

	public TeleportPlayerNetwork()
	{
	}

	public TeleportPlayerNetwork(String player, int oldDim, int newDim)
	{
		this.player = player;
		this.oldDim = oldDim;
		this.newDim = newDim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		player = ByteBufUtils.readUTF8String(buf);
		oldDim = ByteBufUtils.readVarInt(buf, 5);
		newDim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, player);
		ByteBufUtils.writeVarInt(buf, oldDim, 5);
		ByteBufUtils.writeVarInt(buf, newDim, 5);
	}
}
