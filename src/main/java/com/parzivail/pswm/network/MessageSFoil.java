package com.parzivail.pswm.network;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import com.parzivail.pswm.entities.EntitySpeederBlasterRifleBolt;
import com.parzivail.pswm.entities.EntityTIEBolt;
import com.parzivail.pswm.entities.EntityXWingBolt;
import com.parzivail.pswm.utils.BlasterBoltType;
import com.parzivail.pswm.vehicles.VehicXWing;
import com.parzivail.util.ui.Lumberjack;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSFoil extends Message<MessageSFoil>
{
	public EntityPlayer player;
	public float foil;

	public MessageSFoil()
	{
	}

	public MessageSFoil(EntityPlayer player, float foil)
	{
		this.player = player;
		this.foil = foil;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (player.ridingEntity instanceof VehicXWing)
			((VehicXWing)player.ridingEntity).setSFoil(foil);
		return null;
	}

}