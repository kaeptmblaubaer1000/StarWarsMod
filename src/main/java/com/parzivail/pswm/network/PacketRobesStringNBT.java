package com.parzivail.pswm.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;

import com.parzivail.util.ui.Lumberjack;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketRobesStringNBT implements IMessage
{
	public static class Handler implements IMessageHandler<PacketRobesStringNBT, IMessage>
	{
		@Override
		public IMessage onMessage(PacketRobesStringNBT message, MessageContext ctx)
		{
			try
			{
				MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player).inventory.armorInventory[2].stackTagCompound.setString(message.key, message.value);
			}
			catch (Exception e)
			{
				Lumberjack.warn("Unable to add element " + message.key + " (amount " + String.valueOf(message.value) + ")");
			}
			return null;
		}
	}

	private String key;
	private String player;
	private String value;
	private int dim;

	public PacketRobesStringNBT()
	{
	}

	public PacketRobesStringNBT(String element, String amt, int dim, String player)
	{
		this.key = element;
		this.player = player;
		this.value = amt;
		this.dim = dim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.key = ByteBufUtils.readUTF8String(buf);
		this.player = ByteBufUtils.readUTF8String(buf);
		this.value = ByteBufUtils.readUTF8String(buf);
		this.dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.key);
		ByteBufUtils.writeUTF8String(buf, this.player);
		ByteBufUtils.writeUTF8String(buf, this.value);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\network\JediRobesSetElementInArmorInv.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */