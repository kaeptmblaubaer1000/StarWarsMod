package com.parzivail.pswm.network;

import com.parzivail.pswm.StarWarsMod;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

public class PacketTogglePlayerSequelLightsaber implements IMessage
{
	public static class Handler implements IMessageHandler<PacketTogglePlayerSequelLightsaber, IMessage>
	{
		@Override
		public IMessage onMessage(PacketTogglePlayerSequelLightsaber message, MessageContext ctx)
		{
			EntityPlayer player = MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player);
			ItemStack cur = player.inventory.getCurrentItem();
			if (cur.getTagCompound() != null && cur.getTagCompound().hasKey("timeout") && cur.getTagCompound().getInteger("timeout") == 0)
			{
				Item n = cur.getItem() == StarWarsMod.sequelLightsaber ? StarWarsMod.sequelLightsaberOff : StarWarsMod.sequelLightsaber;
				player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(n, 1, cur.getItemDamage()));
			}
			return null;
		}
	}

	private String player;
	private int dim;

	public PacketTogglePlayerSequelLightsaber()
	{
	}

	public PacketTogglePlayerSequelLightsaber(String player, int dim)
	{
		this.player = player;
		this.dim = dim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.player = ByteBufUtils.readUTF8String(buf);
		this.dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.player);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\network\TogglePlayerLightsaber.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */