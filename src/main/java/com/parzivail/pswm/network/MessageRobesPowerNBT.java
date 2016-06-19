package com.parzivail.pswm.network;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.force.CronUtils;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

public class MessageRobesPowerNBT extends PMessage<MessageRobesPowerNBT>
{
	public EntityPlayer player;
	public String key;
	public int value;

	public MessageRobesPowerNBT()
	{
	}

	public MessageRobesPowerNBT(EntityPlayer player, String key, int value)
	{
		this.player = player;
		this.key = key;
		this.value = value;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.player == null || this.player.inventory == null)
			return null;
		if (CronUtils.getHolocron(player) != null && CronUtils.getHolocron(player).hasTagCompound())
			CronUtils.getHolocron(player).stackTagCompound.getCompoundTag(Resources.nbtPowers).setInteger(this.key, this.value);
		return null;
	}

}