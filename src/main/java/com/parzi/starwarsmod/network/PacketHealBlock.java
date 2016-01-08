package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;

import com.parzi.util.ui.Lumberjack;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketHealBlock implements IMessage
{
	public static class Handler implements IMessageHandler<PacketHealBlock, IMessage>
	{
		@Override
		public IMessage onMessage(PacketHealBlock message, MessageContext ctx)
		{
			try
			{
				Block block = MinecraftServer.getServer().worldServerForDimension(message.dim).getBlock(message.x, message.y, message.z);

				Lumberjack.log(block);

				Block ret = block;
				int metadata = MinecraftServer.getServer().worldServerForDimension(message.dim).getBlockMetadata(message.x, message.y, message.z);

				if (block == Blocks.dirt)
				{
					ret = Blocks.grass;
					metadata = 0;
				}
				else if (block == Blocks.deadbush)
				{
					ret = Blocks.sapling;
					metadata = 0;
				}

				MinecraftServer.getServer().worldServerForDimension(message.dim).setBlock(message.x, message.y, message.z, ret);
				MinecraftServer.getServer().worldServerForDimension(message.dim).setBlockMetadataWithNotify(message.x, message.y, message.z, metadata, 4);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
	}

	private int dim;
	private int x;
	private int y;
	private int z;

	public PacketHealBlock()
	{
	}

	public PacketHealBlock(int dim, int x, int y, int z)
	{
		this.dim = dim;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.dim = ByteBufUtils.readVarInt(buf, 5);
		this.x = ByteBufUtils.readVarInt(buf, 5);
		this.y = ByteBufUtils.readVarInt(buf, 5);
		this.z = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
		ByteBufUtils.writeVarInt(buf, this.x, 5);
		ByteBufUtils.writeVarInt(buf, this.y, 5);
		ByteBufUtils.writeVarInt(buf, this.z, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\network\JediRobesSetElementInArmorInv.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */