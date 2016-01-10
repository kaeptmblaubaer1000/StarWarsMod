package com.parzi.starwarsmod.network;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;
import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.util.ui.Lumberjack;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class PacketUpdateRobes implements IMessage
{
	public static class Handler implements IMessageHandler<PacketUpdateRobes, IMessage>
	{
		@Override
		public IMessage onMessage(PacketUpdateRobes message, MessageContext ctx)
		{
			try
			{
				EntityPlayer player = MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player);
				if (player != null)
				{
					player.getDataWatcher().updateObject(Resources.activeDatawatcherId, message.activeName);
					ArmorJediRobes.setActive(player, message.activeName);

					player.getDataWatcher().updateObject(Resources.durationDatawatcherId, message.isDuration);
					ArmorJediRobes.setDuration(player, message.isDuration == 1);

					player.getDataWatcher().updateObject(Resources.runningDatawatcherId, message.isRunning);
					ArmorJediRobes.setRunning(player, message.isRunning == 1);
				}
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
	private String activeName;
	private int isDuration;
	private int isRunning;
	private int dim;

	public PacketUpdateRobes()
	{
	}

	public PacketUpdateRobes(String player, String active, boolean running, boolean duration, int dim)
	{
		this.player = player;
		this.activeName = active;
		this.isDuration = duration ? 1 : 0;
		this.isRunning = running ? 1 : 0;
		this.dim = dim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.player = ByteBufUtils.readUTF8String(buf);
		this.activeName = ByteBufUtils.readUTF8String(buf);
		this.isDuration = ByteBufUtils.readVarInt(buf, 2);
		this.isRunning = ByteBufUtils.readVarInt(buf, 2);
		this.dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.player);
		ByteBufUtils.writeUTF8String(buf, this.activeName);
		ByteBufUtils.writeVarInt(buf, this.isDuration, 2);
		ByteBufUtils.writeVarInt(buf, this.isRunning, 2);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\network\TeleportPlayerNetwork.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */