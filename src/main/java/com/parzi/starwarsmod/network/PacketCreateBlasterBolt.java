package com.parzi.starwarsmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import com.parzi.starwarsmod.entities.EntitySpeederBlasterRifleBolt;
import com.parzi.starwarsmod.entities.EntityTIEBolt;
import com.parzi.starwarsmod.entities.EntityXWingBolt;
import com.parzi.starwarsmod.utils.BlasterBoltType;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketCreateBlasterBolt implements IMessage
{
	public static class Handler implements IMessageHandler<PacketCreateBlasterBolt, IMessage>
	{
		@Override
		public IMessage onMessage(PacketCreateBlasterBolt message, MessageContext ctx)
		{
			EntityPlayer player = MinecraftServer.getServer().worldServerForDimension(message.dim).getPlayerEntityByName(message.player);
			World world = player.worldObj;
			if (message.type == BlasterBoltType.SPEEDER)
				world.spawnEntityInWorld(new EntitySpeederBlasterRifleBolt(world, player));
			else if (message.type == BlasterBoltType.XWING)
			{
				EntityXWingBolt bolt1 = new EntityXWingBolt(world, player);
				world.spawnEntityInWorld(bolt1);

				/*
				 * EntityXWingBolt bolt2 = new EntityXWingBolt(world, player);
				 * world.spawnEntityInWorld(bolt2);
				 *
				 * EntityXWingBolt bolt3 = new EntityXWingBolt(world, player);
				 * world.spawnEntityInWorld(bolt3);
				 *
				 * EntityXWingBolt bolt4 = new EntityXWingBolt(world, player);
				 * world.spawnEntityInWorld(bolt4);
				 */
			}
			else if (message.type == BlasterBoltType.TIE)
				world.spawnEntityInWorld(new EntityTIEBolt(world, player));
			return null;
		}
	}

	private String player;
	private int dim;
	private int type;

	public PacketCreateBlasterBolt()
	{
	}

	public PacketCreateBlasterBolt(String player, int dim, int type)
	{
		this.player = player;
		this.dim = dim;
		this.type = type;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.player = ByteBufUtils.readUTF8String(buf);
		this.dim = ByteBufUtils.readVarInt(buf, 5);
		this.type = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.player);
		ByteBufUtils.writeVarInt(buf, this.dim, 5);
		ByteBufUtils.writeVarInt(buf, this.type, 5);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\network\CreateBlasterBoltSpeeder.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */