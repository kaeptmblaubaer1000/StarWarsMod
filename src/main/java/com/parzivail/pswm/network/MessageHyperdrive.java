package com.parzivail.pswm.network;

import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.pswm.world.TransferDim;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

public class MessageHyperdrive extends PMessage<MessageHyperdrive>
{
	public EntityPlayer player;
	public int destDim;

	public MessageHyperdrive()
	{
	}

	public MessageHyperdrive(EntityPlayer player, int destDim)
	{
		this.player = player;
		this.destDim = destDim;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		ItemStack qlog = ItemQuestContainer.getQuestContainer(player);
		if (qlog != null)
		{
			ItemQuestContainer.setInHyperspace(qlog, true);
		}
		new TransferDim(MinecraftServer.getServer().worldServerForDimension(this.destDim)).teleport(this.player);
		this.player.setSneaking(false);
		return null;
	}
}
