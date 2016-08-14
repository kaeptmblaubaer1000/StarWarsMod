package com.parzivail.pswm.network;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSpawnClientParticle extends PMessage<MessageSpawnClientParticle>
{
	public String particle;
	public double x;
	public double y;
	public double z;
	public double motionX;
	public double motionY;
	public double motionZ;

	public MessageSpawnClientParticle()
	{
	}

	public MessageSpawnClientParticle(String particle, double x, double y, double z, double motionX, double motionY, double motionZ)
	{
		this.particle = particle;
		this.x = x;
		this.y = y;
		this.z = z;
		this.motionX = motionX;
		this.motionY = motionY;
		this.motionZ = motionZ;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		StarWarsMod.mc.theWorld.spawnParticle(particle, x, y, z, motionX, motionY, motionZ);
		return null;
	}
}
