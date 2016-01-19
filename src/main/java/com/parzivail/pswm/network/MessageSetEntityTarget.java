package com.parzivail.pswm.network;

import com.parzivail.pswm.entities.EntitySpeederBlasterRifleBolt;
import com.parzivail.pswm.entities.EntityTIEBolt;
import com.parzivail.pswm.entities.EntityXWingBolt;
import com.parzivail.pswm.jedirobes.ArmorJediRobes;
import com.parzivail.pswm.utils.BlasterBoltType;
import com.parzivail.util.ui.Lumberjack;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class MessageSetEntityTarget extends Message<MessageSetEntityTarget>
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
		{
			ArmorJediRobes.setEntityTarget(this.sender, this.targetId);
		}
		return null;
	}

}