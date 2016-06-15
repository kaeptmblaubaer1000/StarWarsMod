package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import com.parzivail.util.world.ItemUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MessagePlayerRemoveItems extends PMessage<MessagePlayerRemoveItems>
{
	public EntityPlayer player;
	public ItemStack[] stacks;

	public MessagePlayerRemoveItems()
	{
	}

	public MessagePlayerRemoveItems(EntityPlayer player, ItemStack[] stack)
	{
		this.player = player;
		this.stacks = stack;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		for (ItemStack stack : stacks)
			ItemUtils.removePlayerItem(player, stack);
		return null;
	}

}