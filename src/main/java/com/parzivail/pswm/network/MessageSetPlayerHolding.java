package com.parzivail.pswm.network;

import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MessageSetPlayerHolding extends PMessage<MessageSetPlayerHolding>
{
	public EntityPlayer player;
	public ItemStack stack;

	public MessageSetPlayerHolding()
	{
	}

	public MessageSetPlayerHolding(EntityPlayer player, ItemStack stack)
	{
		this.player = player;
		this.stack = stack;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		this.player.inventory.mainInventory[this.player.inventory.currentItem] = stack;
		return null;
	}

}