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

public class MessageRobesIntNBT extends Message<MessageRobesIntNBT>
{
	public EntityPlayer player;
	public String key;
	public int value;

	public MessageRobesIntNBT()
	{
	}

	public MessageRobesIntNBT(EntityPlayer player, String key, int value)
	{
		this.player = player;
		this.key = key;
		this.value = value;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		this.player.inventory.armorInventory[2].stackTagCompound.setInteger(key, value);
		return null;
	}

}