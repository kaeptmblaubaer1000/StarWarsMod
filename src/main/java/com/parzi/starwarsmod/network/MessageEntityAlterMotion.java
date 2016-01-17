package com.parzi.starwarsmod.network;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageEntityAlterMotion extends Message<MessageEntityAlterMotion>
{
	public Entity entity;
	public Vec3 motion;

	public MessageEntityAlterMotion()
	{
	}

	public MessageEntityAlterMotion(Entity entity, Vec3 motion)
	{
		this.entity = entity;
		this.motion = motion;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.entity != null)
		{
			this.entity.motionX += motion.xCoord;
			this.entity.motionY += motion.yCoord;
			this.entity.motionZ += motion.zCoord;
		}
		return null;
	}
}
