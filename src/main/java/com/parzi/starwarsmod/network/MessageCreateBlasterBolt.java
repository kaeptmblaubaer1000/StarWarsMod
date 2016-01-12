package com.parzi.starwarsmod.network;

import com.parzi.starwarsmod.entities.EntitySpeederBlasterRifleBolt;
import com.parzi.starwarsmod.entities.EntityTIEBolt;
import com.parzi.starwarsmod.entities.EntityXWingBolt;
import com.parzi.starwarsmod.utils.BlasterBoltType;
import com.parzi.util.ui.Lumberjack;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MessageCreateBlasterBolt extends Message<MessageCreateBlasterBolt>
{
	public EntityPlayer sender;
	public int type;

	public MessageCreateBlasterBolt()
	{
	}

	public MessageCreateBlasterBolt(EntityPlayer sender, int type)
	{
		this.sender = sender;
		this.type = type;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		World world = this.sender.worldObj;
		if (this.type == BlasterBoltType.SPEEDER)
			world.spawnEntityInWorld(new EntitySpeederBlasterRifleBolt(world, sender));
		else if (this.type == BlasterBoltType.XWING)
		{
			EntityXWingBolt bolt1 = new EntityXWingBolt(world, sender);
			world.spawnEntityInWorld(bolt1);
		}
		else if (this.type == BlasterBoltType.TIE)
			world.spawnEntityInWorld(new EntityTIEBolt(world, sender));
		return null;
	}

}