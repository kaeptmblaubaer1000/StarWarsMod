package com.parzivail.pswm.network;

import com.parzivail.util.ui.Lumberjack;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;

public class PacketRobesIntNBT implements IMessage
{
	public static class Handler implements IMessageHandler<PacketRobesIntNBT, IMessage>
	{
		@Override
		public IMessage onMessage(PacketRobesIntNBT message, MessageContext ctx)
		{
			try
			{
				MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player).inventory.armorInventory[2].stackTagCompound.setInteger(message.key, message.value);
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
	private int value;
	private int dim;

	public PacketRobesIntNBT()
	{
	}

	public PacketRobesIntNBT(String element, int amt, int dim, String player)
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
		this.value = ByteBufUtils.readVarInt(buf, 5);
		this.dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.key);
		ByteBufUtils.writeUTF8String(buf, this.player);
		ByteBufUtils.writeVarInt(buf, this.value, 5);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\network\JediRobesSetElementInArmorInv.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */