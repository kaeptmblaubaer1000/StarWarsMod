package com.parzivail.pswm.network;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.force.Cron;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

// TODO: get rid of this completely
public class MessageHolocronSetXp extends PMessage<MessageHolocronSetXp>
{
	public EntityPlayer player;
	public int value;

	public MessageHolocronSetXp()
	{
	}

	public MessageHolocronSetXp(EntityPlayer player, int value)
	{
		this.player = player;
		this.value = value;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.player == null || this.player.inventory == null || Cron.getHolocron(this.player) == null)
			return null;
		Cron.getHolocron(this.player).stackTagCompound.setInteger(Resources.nbtXp, this.value);
		return null;
	}

}