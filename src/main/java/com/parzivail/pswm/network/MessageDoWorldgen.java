package com.parzivail.pswm.network;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.world.gen.WorldGenTest;
import com.parzivail.util.network.PMessage;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.server.MinecraftServer;

public class MessageDoWorldgen extends PMessage<MessageDoWorldgen>
{
	public int dim;
	public int x;
	public int y;
	public int z;

	public MessageDoWorldgen()
	{
	}

	public MessageDoWorldgen(int dim, int x, int y, int z)
	{
		this.dim = dim;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		new WorldGenTest().generate(MinecraftServer.getServer().worldServerForDimension(this.dim), StarWarsMod.rngGeneral, x, y, z);
		return null;
	}

}