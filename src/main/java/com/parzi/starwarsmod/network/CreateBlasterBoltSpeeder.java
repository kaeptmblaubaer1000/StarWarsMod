package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import com.parzi.starwarsmod.entities.EntitySpeederBlasterRifleBolt;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class CreateBlasterBoltSpeeder implements IMessage
{

	public static class Handler implements IMessageHandler<CreateBlasterBoltSpeeder, IMessage>
	{

		@Override
		public IMessage onMessage(CreateBlasterBoltSpeeder message, MessageContext ctx)
		{
			EntityPlayer player = MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player);
			World world = player.worldObj;

			world.spawnEntityInWorld(new EntitySpeederBlasterRifleBolt(world, player));

			return null; // no response in this case
		}
	}

	private String player;

	private int dim;

	public CreateBlasterBoltSpeeder()
	{
	}

	public CreateBlasterBoltSpeeder(String player, int dim)
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
