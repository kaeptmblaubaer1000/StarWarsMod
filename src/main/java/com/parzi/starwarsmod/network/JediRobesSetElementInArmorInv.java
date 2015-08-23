package com.parzi.starwarsmod.network;

import net.minecraft.server.MinecraftServer;
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
				MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player).inventory.armorInventory[2].stackTagCompound.setInteger(message.element, message.amt);
			}
			catch (Exception e)
			{
				Lumberjack.warn("Unable to add element " + message.element + " (amount " + String.valueOf(message.amt) + ")");
			}
			return null; // no response in this case
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
		element = ByteBufUtils.readUTF8String(buf);
		player = ByteBufUtils.readUTF8String(buf);
		amt = ByteBufUtils.readVarInt(buf, 5);
		dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, element);
		ByteBufUtils.writeUTF8String(buf, player);
		ByteBufUtils.writeVarInt(buf, amt, 5);
		ByteBufUtils.writeVarInt(buf, dim, 5);
	}
}
