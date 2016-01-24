package com.parzivail.pswm.network;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageEntityGrab extends Message<MessageEntityGrab>
{
	public Entity entity;
	public EntityPlayer grabber;
	public float distance;

	public MessageEntityGrab()
	{
	}

	public MessageEntityGrab(Entity entity, EntityPlayer grabber, float distance)
	{
		this.entity = entity;
		this.grabber = grabber;
		this.distance = distance;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		try
		{
			Vec3 look = this.grabber.getLookVec();
			look.xCoord *= this.distance;
			look.yCoord *= this.distance;
			look.zCoord *= this.distance;
			look.xCoord += this.grabber.posX;
			look.yCoord += this.grabber.posY + 2;
			look.zCoord += this.grabber.posZ;
			if (this.entity != null)
			{
				this.entity.fallDistance = 0.0f;
				this.entity.onGround = false;
				this.entity.isAirBorne = true;
				this.entity.timeUntilPortal = 5;
				this.entity.setVelocity(0, 0, 0);
				this.entity.setLocationAndAngles(look.xCoord, look.yCoord, look.zCoord, this.grabber.rotationYawHead, this.grabber.rotationPitch);
			}
		}
		catch (Exception e)
		{
		}

		return null;
	}

}