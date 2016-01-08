package com.parzi.starwarsmod.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Vec3;

public class PacketEntitySetMotion implements IMessage
{
	public static class Handler implements IMessageHandler<PacketEntitySetMotion, IMessage>
	{
		@Override
		public IMessage onMessage(PacketEntitySetMotion message, MessageContext ctx)
		{
			try
			{
				Entity e = MinecraftServer.getServer().worldServerForDimension(message.dim).getEntityByID(message.entityId);

				if (e != null)
				{
					String[] vecString = message.vector.split(",");
					Vec3 vector = Vec3.createVectorHelper(Float.parseFloat(vecString[0]), Float.parseFloat(vecString[1]), Float.parseFloat(vecString[2]));

					e.motionX = vector.xCoord;
					e.motionY = vector.yCoord;
					e.motionZ = vector.zCoord;
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
	private String vector;
	private int dim;

	public PacketEntitySetMotion()
	{
	}

	public PacketEntitySetMotion(int entityId, int dim, String vector)
	{
		this.entityId = entityId;
		this.vector = vector;
		this.dim = dim;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.entityId = ByteBufUtils.readVarInt(buf, 5);
		this.vector = ByteBufUtils.readUTF8String(buf);
		this.dim = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeVarInt(buf, this.entityId, 5);
		ByteBufUtils.writeUTF8String(buf, this.vector);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\network\JediRobesSetElementInArmorInv.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */