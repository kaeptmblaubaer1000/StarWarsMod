package com.parzivail.pswm.network;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.Cron;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MessageHolocronRefreshPowers extends PMessage<MessageHolocronRefreshPowers>
{
	public EntityPlayer player;
	public NBTTagCompound compound;

	public MessageHolocronRefreshPowers()
	{
	}

	public MessageHolocronRefreshPowers(EntityPlayer player)
	{
		this.player = player;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		ItemStack holocron;
		if (this.player == null || this.player.inventory == null || (holocron = Cron.getHolocron(player)) == null || holocron.stackTagCompound == null)
			return null;
		StarWarsMod.network.sendToAll(new MessageHolocronRefreshClientPowers(this.player, holocron.stackTagCompound.getCompoundTag("powers")));
		return null;
	}

}