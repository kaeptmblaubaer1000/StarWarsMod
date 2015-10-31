package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;

import com.parzi.starwarsmod.utils.Lumberjack;
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
			try
			{
				new TransferDim(MinecraftServer.getServer().worldServerForDimension(message.newDim)).teleport(MinecraftServer.getServer().worldServerForDimension(message.oldDim).getPlayerEntityByName(message.player));
			}
			catch (Exception e)
			{
				Lumberjack.info("Something went very wrong.");
				e.printStackTrace();
			}
			MinecraftServer.getServer().worldServerForDimension(message.newDim).getPlayerEntityByName(message.player).setSneaking(false);
			return null;
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
		this.player = ByteBufUtils.readUTF8String(buf);
		this.oldDim = ByteBufUtils.readVarInt(buf, 5);
		this.newDim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.player);
		ByteBufUtils.writeVarInt(buf, this.oldDim, 5);
		ByteBufUtils.writeVarInt(buf, this.newDim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\network\TeleportPlayerNetwork.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */