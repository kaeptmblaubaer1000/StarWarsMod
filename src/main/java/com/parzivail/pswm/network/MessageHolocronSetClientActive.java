package com.parzivail.pswm.network;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.force.Cron;
import com.parzivail.pswm.rendering.force.RenderSithLightning;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHolocronSetClientActive extends PMessage<MessageHolocronSetClientActive>
{
	public EntityPlayer player;
	public String power;

	public MessageHolocronSetClientActive()
	{
	}

	public MessageHolocronSetClientActive(EntityPlayer player, String power)
	{
		this.player = player;
		this.power = power;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		if (this.player == null)
			return null;

		RenderSithLightning.playerPowers.put(player.getCommandSenderName(), power);

		if (this.player.inventory == null || Cron.getHolocron(player) == null)
			return null;
		Cron.getHolocron(player).stackTagCompound.setString(Resources.nbtWield, power);
		return null;
	}

}