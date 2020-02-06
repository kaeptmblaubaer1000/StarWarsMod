package com.parzivail.pswm.network;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.Cron;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MessageHolocronSetActive extends PMessage<MessageHolocronSetActive>
{
	public EntityPlayer player;
	public String power;

	public MessageHolocronSetActive()
	{
	}

	public MessageHolocronSetActive(EntityPlayer player, String power) {
		this.player = player;
		this.power = power;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		ItemStack holocron;
		if (this.player == null || this.player.inventory == null || (holocron = Cron.getHolocron(player)) == null)
			return null;
		if (!power.isEmpty() && (!holocron.stackTagCompound.getCompoundTag(Resources.nbtPowers).hasKey(power) || holocron.stackTagCompound.getCompoundTag(Resources.nbtPowers).getCompoundTag(power).getInteger("currentLevel") < 1)) {
			// TODO: the message sender is a hacker
			return null;
		}
		holocron.stackTagCompound.setString(Resources.nbtWield, power);
		StarWarsMod.network.sendToAll(new MessageHolocronSetClientActive(this.player, power));
		return null;
	}

}