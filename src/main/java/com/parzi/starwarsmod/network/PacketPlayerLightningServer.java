package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.Lumberjack;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketPlayerLightningServer implements IMessage
{
	public static class Handler implements IMessageHandler<PacketPlayerLightningServer, IMessage>
	{
		@Override
		public IMessage onMessage(PacketPlayerLightningServer message, MessageContext ctx)
		{
			try
			{
				StarWarsMod.network.sendTo(new PacketPlayerLightning(message.player, message.lightning, message.dim), (EntityPlayerMP)MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player));
			}
			catch (Exception e)
			{
				Lumberjack.info("Something went very wrong.");
				e.printStackTrace();
			}
			return null;
		}
	}

	private String player;
	private boolean lightning;
	private int dim;

	public PacketPlayerLightningServer()
	{
	}

	public PacketPlayerLightningServer(String player, boolean lightning, int dim)
	{
		this.player = player;
		this.lightning = lightning;
		this.dim = dim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.player = ByteBufUtils.readUTF8String(buf);
		this.lightning = ByteBufUtils.readVarInt(buf, 2) == 1;
		this.dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.player);
		ByteBufUtils.writeVarInt(buf, this.lightning ? 1 : 0, 2);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\network\TeleportPlayerNetwork.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */