package com.parzivail.pswm.network;

import com.parzivail.pswm.handler.EventHandler;
import com.parzivail.util.network.PMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by colby on 12/23/2016.
 */
public class MessageTeleportPlayer extends PMessage<MessageTeleportPlayer>
{
	public int targetDim;
	public EntityPlayer entity;

	public MessageTeleportPlayer()
	{

	}

	public MessageTeleportPlayer(EntityPlayerMP entity, int targetDim)
	{
		this.entity = entity;
		this.targetDim = targetDim;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		EventHandler.queuePlayerDestination((EntityPlayerMP)entity, targetDim);

		return null;
	}
}
