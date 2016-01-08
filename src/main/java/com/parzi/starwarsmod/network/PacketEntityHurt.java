package com.parzi.starwarsmod.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;

public class PacketEntityHurt implements IMessage
{
	public static class Handler implements IMessageHandler<PacketEntityHurt, IMessage>
	{
		@Override
		public IMessage onMessage(PacketEntityHurt message, MessageContext ctx)
		{
			try
			{
				Entity e = MinecraftServer.getServer().worldServerForDimension(message.dim).getEntityByID(message.entityId);

				if (e != null)
					e.attackEntityFrom(DamageSource.magic, message.damagePoints);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
	}

	private int entityId;
	private int damagePoints;
	private int dim;

	public PacketEntityHurt()
	{
	}

	public PacketEntityHurt(int entityId, int dim, int damagePoints)
	{
		this.entityId = entityId;
		this.damagePoints = damagePoints;
		this.dim = dim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.entityId = ByteBufUtils.readVarInt(buf, 5);
		this.damagePoints = ByteBufUtils.readVarInt(buf, 5);
		this.dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeVarInt(buf, this.entityId, 5);
		ByteBufUtils.writeVarInt(buf, this.damagePoints, 5);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\network\JediRobesSetElementInArmorInv.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */