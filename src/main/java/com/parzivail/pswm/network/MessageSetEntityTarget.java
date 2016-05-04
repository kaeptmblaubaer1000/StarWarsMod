package com.parzivail.pswm.network;

import com.parzivail.pswm.jedirobes.ArmorJediRobes;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

public class MessageSetEntityTarget extends PMessage<MessageSetEntityTarget>
{
	public EntityPlayer sender;
	public int targetId;

	public MessageSetEntityTarget()
	{
	}

	public MessageSetEntityTarget(EntityPlayer sender, int targetId)
	{
		this.sender = sender;
		this.targetId = targetId;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.sender != null)
			ArmorJediRobes.setEntityTarget(this.sender, this.targetId);
		return null;
	}

}