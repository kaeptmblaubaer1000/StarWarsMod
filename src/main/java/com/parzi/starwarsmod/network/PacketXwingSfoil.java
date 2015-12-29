package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.vehicles.VehicXWing;
import com.parzi.starwarsmod.vehicles.VehicleAirBase;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketXwingSfoil implements IMessage
{
	public static class Handler implements IMessageHandler<PacketXwingSfoil, IMessage>
	{
		@Override
		public IMessage onMessage(PacketXwingSfoil message, MessageContext ctx)
		{
			try
			{
				EntityPlayer player = MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player);
				if (player.ridingEntity instanceof VehicXWing)
					((VehicXWing)player.ridingEntity).setSFoil(message.sfoil);
			}
			catch (Exception e)
			{
				Lumberjack.info("Something went very wrong.");
				e.printStackTrace();
			}
			return null;
		}
	}

	private String player;
	private float sfoil;
	private int dim;

	public PacketXwingSfoil()
	{
	}

	public PacketXwingSfoil(String player, float sfoil, int dim)
	{
		this.player = player;
		this.sfoil = sfoil;
		this.dim = dim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.player = ByteBufUtils.readUTF8String(buf);
		this.sfoil = Float.parseFloat(ByteBufUtils.readUTF8String(buf));
		this.dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.player);
		ByteBufUtils.writeUTF8String(buf, String.valueOf(this.sfoil));
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\network\TeleportPlayerNetwork.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */