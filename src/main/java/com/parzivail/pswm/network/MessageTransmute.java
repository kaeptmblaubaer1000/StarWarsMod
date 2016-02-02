package com.parzivail.pswm.network;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.network.PMessage;
import com.parzivail.util.ui.Lumberjack;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageTransmute extends PMessage<MessageTransmute>
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

		if (this.level > 1)
			if (block == Blocks.sand)
			{
				ret = Blocks.clay;
				metadata = 0;
			}
			else if (block == Blocks.pumpkin)
			{
				ret = Blocks.melon_block;
				metadata = 0;
			}

		if (this.level > 2)
			if (block == Blocks.cobblestone)
			{
				ret = Blocks.mossy_cobblestone;
				metadata = 0;
			}
			else if (block == Blocks.gravel)
			{
				ret = Blocks.sand;
				metadata = 0;
			}

		if (this.level > 3)
			if (block == Blocks.ice)
			{
				ret = Blocks.snow;
				metadata = 0;
			}
			else if (block == Blocks.netherrack)
			{
				ret = Blocks.nether_brick;
				metadata = 0;
			}

		if (this.level > 4)
			if (block == Blocks.snow)
			{
				ret = Blocks.ice;
				metadata = 0;
			}
			else if (block == Blocks.stonebrick)
			{
				ret = Blocks.brick_block;
				metadata = 0;
			}

		if (this.level > 5)
			if (block == Blocks.grass)
			{
				ret = Blocks.mycelium;
				metadata = 0;
			}
			else if (block == Blocks.fence)
				ret = Blocks.nether_brick_fence;

		if (this.level > 6)
			if (block == Blocks.redstone_block)
			{
				ret = Blocks.tnt;
				metadata = 0;
			}
			else if (block == Blocks.quartz_block)
			{
				ret = Blocks.cake;
				metadata = 0;
			}

		if (this.level > 7)
			if (block == Blocks.tnt)
			{
				ret = Blocks.redstone_block;
				metadata = 0;
			}
			else if (block == Blocks.noteblock)
			{
				ret = Blocks.jukebox;
				metadata = 0;
			}

		if (this.level > 8)
			if (block == Blocks.web)
			{
				ret = Blocks.wool;
				metadata = 0;
			}
			else if (block == Blocks.iron_ore)
			{
				ret = Blocks.lapis_ore;
				metadata = 0;
			}

		if (this.level > 9)
			if (block == Blocks.quartz_ore)
			{
				ret = Blocks.quartz_block;
				metadata = 0;
			}
			else if (block == Blocks.lapis_ore)
			{
				ret = Blocks.gold_ore;
				metadata = 0;
			}

		if (this.level > 10)
			if (block == Blocks.gold_ore)
			{
				ret = StarWarsMod.blockTitaniumOre;
				metadata = 0;
			}
			else if (block == Blocks.coal_ore)
			{
				ret = Blocks.diamond_ore;
				metadata = 0;
			}

		if (this.level > 11)
			if (block == Blocks.diamond_ore)
			{
				ret = Blocks.emerald_ore;
				metadata = 0;
			}
			else if (block == Blocks.emerald_ore)
			{
				ret = StarWarsMod.blockChromiumOre;
				metadata = 0;
			}
			else if (block == Blocks.sandstone)
			{
				ret = Blocks.end_stone;
				metadata = 0;
			}

		MinecraftServer.getServer().worldServerForDimension(this.dim).setBlock(this.x, this.y, this.z, ret);
		MinecraftServer.getServer().worldServerForDimension(this.dim).setBlockMetadataWithNotify(this.x, this.y, this.z, metadata, 4);
		return null;
	}

}