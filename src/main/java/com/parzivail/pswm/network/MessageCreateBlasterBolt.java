package com.parzivail.pswm.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.parzivail.pswm.entities.EntitySpeederBlasterRifleBolt;
import com.parzivail.pswm.entities.EntityTIEBolt;
import com.parzivail.pswm.entities.EntityXWingBolt;
import com.parzivail.pswm.utils.BlasterBoltType;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

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
			world.spawnEntityInWorld(new EntitySpeederBlasterRifleBolt(world, this.sender));
		else if (this.type == BlasterBoltType.XWING)
		{
			EntityXWingBolt bolt1 = new EntityXWingBolt(world, this.sender);
			world.spawnEntityInWorld(bolt1);
		}
		else if (this.type == BlasterBoltType.TIE)
			world.spawnEntityInWorld(new EntityTIEBolt(world, this.sender));
		return null;
	}

}