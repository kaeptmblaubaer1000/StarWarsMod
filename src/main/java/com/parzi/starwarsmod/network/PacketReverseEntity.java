package com.parzi.starwarsmod.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.server.MinecraftServer;

public class PacketReverseEntity implements IMessage
{
	public static class Handler implements IMessageHandler<PacketReverseEntity, IMessage>
	{
		@Override
		public IMessage onMessage(PacketReverseEntity message, MessageContext ctx)
		{
			try
			{
				Entity e = MinecraftServer.getServer().worldServerForDimension(message.dim).getEntityByID(message.entityId);

				if (e instanceof Entity)
				{
					Entity entity = (Entity)e;
					entity.motionX = -entity.motionX;
					entity.motionY = -entity.motionY;
					entity.motionZ = -entity.motionZ;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
	}

	private int entityId;
	private int dim;

	public PacketReverseEntity()
	{
	}

	public PacketReverseEntity(int entityId, int dim)
	{
		this.entityId = entityId;
		this.dim = dim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.entityId = ByteBufUtils.readVarInt(buf, 5);
		this.dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeVarInt(buf, this.entityId, 5);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\network\JediRobesSetElementInArmorInv.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */