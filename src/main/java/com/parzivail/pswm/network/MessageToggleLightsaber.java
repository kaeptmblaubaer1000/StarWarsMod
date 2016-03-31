package com.parzivail.pswm.network;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.network.PMessage;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MessageToggleLightsaber extends PMessage<MessageToggleLightsaber>
{
	public EntityPlayer player;

	public MessageToggleLightsaber()
	{
	}

	public MessageToggleLightsaber(EntityPlayer player)
	{
		this.player = player;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		ItemStack cur = player.inventory.getCurrentItem();
		if (cur.getTagCompound() != null && cur.getTagCompound().hasKey("timeout") && cur.getTagCompound().getInteger("timeout") == 0)
		{
			Item n = cur.getItem() == StarWarsMod.lightsaber ? StarWarsMod.lightsaberOff : StarWarsMod.lightsaber;
			player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(n, 1, cur.getItemDamage()));
		}
		return null;
	}

}