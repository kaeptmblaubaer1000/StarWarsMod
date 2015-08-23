package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class JediRobesBuy implements IMessage
{

	public static class Handler implements IMessageHandler<JediRobesBuy, IMessage>
	{

		@Override
		public IMessage onMessage(JediRobesBuy message, MessageContext ctx)
		{
			EntityPlayer player = MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player);

			player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.setInteger(message.element, message.amt);
			player.inventory.mainInventory[player.inventory.currentItem].stackTagCompound.setInteger(message.power, message.level);

			return null; // no response in this case
		}
	}

	private String power;
	private String element;
	private String player;
	private int level;
	private int dim;

	private int amt;

	public JediRobesBuy()
	{
	}

	public JediRobesBuy(String power, int level, String element, int amt, String player, int dim)
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
		power = ByteBufUtils.readUTF8String(buf);
		element = ByteBufUtils.readUTF8String(buf);
		level = ByteBufUtils.readVarInt(buf, 5);
		amt = ByteBufUtils.readVarInt(buf, 5);
		player = ByteBufUtils.readUTF8String(buf);
		dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, power);
		ByteBufUtils.writeUTF8String(buf, element);
		ByteBufUtils.writeVarInt(buf, level, 5);
		ByteBufUtils.writeVarInt(buf, amt, 5);
		ByteBufUtils.writeUTF8String(buf, player);
		ByteBufUtils.writeVarInt(buf, dim, 5);
	}
}
