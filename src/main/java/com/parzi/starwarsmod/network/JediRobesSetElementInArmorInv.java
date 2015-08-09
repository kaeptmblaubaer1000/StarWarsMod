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
				ctx.getServerHandler().playerEntity.inventory.armorInventory[2].stackTagCompound.setInteger(message.element, message.amt);
			}
			catch (Exception e)
			{
				Lumberjack.warn("Unable to add element " + message.element + " (amount " + String.valueOf(message.amt) + ")");
			}
			return null; // no response in this case
		}
	}

	private String element;

	private int amt;

	public JediRobesSetElementInArmorInv()
	{
	}

	public JediRobesSetElementInArmorInv(String element, int amt)
	{
		this.element = element;
		this.amt = amt;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		element = ByteBufUtils.readUTF8String(buf);
		amt = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, element);
		ByteBufUtils.writeVarInt(buf, amt, 5);
	}
}
