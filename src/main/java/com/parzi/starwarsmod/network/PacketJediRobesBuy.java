package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;

public class PacketJediRobesBuy implements IMessage
{
	public static class Handler implements IMessageHandler<PacketJediRobesBuy, IMessage>
	{
		@Override
		public IMessage onMessage(PacketJediRobesBuy message, cpw.mods.fml.common.network.simpleimpl.MessageContext ctx)
		{
			net.minecraft.entity.player.EntityPlayer player = net.minecraft.server.MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player);
			player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.setInteger(message.element, message.amt);
			player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.setInteger(message.power, message.level);
			return null;
		}
	}

	private String power;
	private String element;
	private String player;
	private int level;
	private int dim;
	private int amt;

	public PacketJediRobesBuy()
	{
	}

	public PacketJediRobesBuy(String power, int level, String element, int amt, String player, int dim)
	{
		this.power = power;
		this.element = element;
		this.level = level;
		this.amt = amt;
		this.player = player;
		this.dim = dim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.power = ByteBufUtils.readUTF8String(buf);
		this.element = ByteBufUtils.readUTF8String(buf);
		this.level = ByteBufUtils.readVarInt(buf, 5);
		this.amt = ByteBufUtils.readVarInt(buf, 5);
		this.player = ByteBufUtils.readUTF8String(buf);
		this.dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.power);
		ByteBufUtils.writeUTF8String(buf, this.element);
		ByteBufUtils.writeVarInt(buf, this.level, 5);
		ByteBufUtils.writeVarInt(buf, this.amt, 5);
		ByteBufUtils.writeUTF8String(buf, this.player);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\network\JediRobesBuy.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */