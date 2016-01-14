package com.parzi.starwarsmod.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S14PacketEntity.S15PacketEntityRelMove;
import net.minecraft.util.Vec3;

public class MessageEntityGrab extends Message<MessageEntityGrab>
{
	public Entity entity;
	public EntityPlayer grabber;

	public MessageEntityGrab()
	{
	}

	public MessageEntityGrab(Entity entity, EntityPlayer grabber)
	{
		this.entity = entity;
		this.grabber = grabber;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		Vec3 look = grabber.getLookVec();
		look.xCoord *= 3;
		look.yCoord *= 3;
		look.zCoord *= 3;
		look.xCoord += grabber.posX;
		look.yCoord += grabber.posY + 2;
		look.zCoord += grabber.posZ;
		if (this.entity != null)
		{
			this.entity.fallDistance = 0.0f;
			this.entity.onGround = false;
			this.entity.isAirBorne = true;
			this.entity.timeUntilPortal = 5;
			this.entity.setVelocity(0, 0, 0);
			this.entity.setLocationAndAngles(look.xCoord, look.yCoord, look.zCoord, grabber.rotationYaw, grabber.rotationPitch);
		}
		
		return null;
	}

}