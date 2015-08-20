package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.Lumberjack;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class TogglePlayerLightsaber implements IMessage
{

	public static class Handler implements IMessageHandler<TogglePlayerLightsaber, IMessage>
	{

		@Override
		public IMessage onMessage(TogglePlayerLightsaber message, MessageContext ctx)
		{
			EntityPlayer player = MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player);
			ItemStack cur = player.inventory.getCurrentItem();

			if (cur.getTagCompound() != null && cur.getTagCompound().hasKey("timeout") && cur.getTagCompound().getInteger("timeout") == 0)
			{
				Item n = cur.getItem() == StarWarsMod.lightsaber ? StarWarsMod.lightsaberOff : StarWarsMod.lightsaber;

				player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(n, 1, cur.getItemDamage()));
			}
			return null; // no response in this case
		}
	}

	private String player;

	private int dim;

	public TogglePlayerLightsaber()
	{
	}

	public TogglePlayerLightsaber(String player, int dim)
	{
		this.player = player;
		this.dim = dim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		player = ByteBufUtils.readUTF8String(buf);
		dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, player);
		ByteBufUtils.writeVarInt(buf, dim, 5);
	}
}
