package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;

import com.parzi.starwarsmod.utils.Lumberjack;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class JediRobesSetElementInArmorInv implements IMessage
{
	public static class Handler implements IMessageHandler<JediRobesSetElementInArmorInv, IMessage>
	{
		@Override
		public IMessage onMessage(JediRobesSetElementInArmorInv message, MessageContext ctx)
		{
			try
			{
				net.minecraft.server.MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player).inventory.armorInventory[2].stackTagCompound.setInteger(message.element, message.amt);
			}
			catch (Exception e)
			{
				Lumberjack.warn("Unable to add element " + message.element + " (amount " + String.valueOf(message.amt) + ")");
			}
			return null;
		}
	}

	private String element;
	private String player;
	private int amt;
	private int dim;

	public JediRobesSetElementInArmorInv()
	{
	}

	public JediRobesSetElementInArmorInv(String element, int amt, int dim, String player)
	{
		this.element = element;
		this.player = player;
		this.amt = amt;
		this.dim = dim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.element = ByteBufUtils.readUTF8String(buf);
		this.player = ByteBufUtils.readUTF8String(buf);
		this.amt = ByteBufUtils.readVarInt(buf, 5);
		this.dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.element);
		ByteBufUtils.writeUTF8String(buf, this.player);
		ByteBufUtils.writeVarInt(buf, this.amt, 5);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\network\JediRobesSetElementInArmorInv.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */