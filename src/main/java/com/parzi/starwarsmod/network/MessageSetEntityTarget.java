package com.parzi.starwarsmod.network;

import com.parzi.starwarsmod.entities.EntitySpeederBlasterRifleBolt;
import com.parzi.starwarsmod.entities.EntityTIEBolt;
import com.parzi.starwarsmod.entities.EntityXWingBolt;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;
import com.parzi.starwarsmod.utils.BlasterBoltType;
import com.parzi.util.ui.Lumberjack;

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