package com.parzivail.util.network;

import com.parzivail.util.item.ILeftClickInterceptor;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

/**
 * Created by colby on 12/29/2017.
 */
public class MessageItemLeftClick extends PMessage<MessageItemLeftClick>
{
	public int playerDim;
	public int playerId;

	public MessageItemLeftClick()
	{

	}

	public MessageItemLeftClick(EntityPlayer thePlayer)
	{
		playerDim = thePlayer.dimension;
		playerId = thePlayer.getEntityId();
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		Entity ePlayer = MinecraftServer.getServer().worldServerForDimension(playerDim).getEntityByID(playerId);
		if (!(ePlayer instanceof EntityPlayer))
			return null;

		EntityPlayer player = (EntityPlayer)ePlayer;

		ItemStack heldItem = player.getHeldItem();
		if (heldItem == null || !(heldItem.getItem() instanceof ILeftClickInterceptor))
			return null;

		((ILeftClickInterceptor)heldItem.getItem()).onItemLeftClick(heldItem, player.worldObj, player);

		return null;
	}
}
