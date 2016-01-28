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

public class MessageTransmute extends Message<MessageTransmute>
{
	public int level;
	public int dim;
	public int x;
	public int y;
	public int z;

	public MessageTransmute()
	{
	}

	public MessageTransmute(int dim, int level, int x, int y, int z)
	{
		this.level = level;
		this.dim = dim;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		Block block = MinecraftServer.getServer().worldServerForDimension(this.dim).getBlock(this.x, this.y, this.z);

		Lumberjack.log(block);

		Block ret = block;
		int metadata = MinecraftServer.getServer().worldServerForDimension(this.dim).getBlockMetadata(this.x, this.y, this.z);

		if (block == Blocks.dirt)
		{
			ret = Blocks.grass;
			metadata = 0;
		}
		else if (block == Blocks.deadbush)
		{
			ret = Blocks.sapling;
			metadata = 0;
		}

		MinecraftServer.getServer().worldServerForDimension(this.dim).setBlock(this.x, this.y, this.z, ret);
		MinecraftServer.getServer().worldServerForDimension(this.dim).setBlockMetadataWithNotify(this.x, this.y, this.z, metadata, 4);
		return null;
	}

}