package com.parzivail.pswm.network;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.Cron;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MessageHolocronUpgradePower extends PMessage<MessageHolocronUpgradePower>
{
	public EntityPlayer player;
	public String power;

	public MessageHolocronUpgradePower()
	{
	}

	public MessageHolocronUpgradePower(EntityPlayer player, String power) {
		this.player = player;
		this.power = power;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		ItemStack holocron;
		int upgradePoints;
		if (this.player == null || this.player.inventory == null || (holocron = Cron.getHolocron(player)) == null)
			return null;
		if ((upgradePoints = holocron.stackTagCompound.getInteger(Resources.nbtRemainingPts)) < 1) {
			return null;
		}
		// TODO: maxlevel check
		holocron.stackTagCompound.setInteger(Resources.nbtRemainingPts, upgradePoints - 1);
		holocron.stackTagCompound.getCompoundTag(Resources.nbtPowers).getCompoundTag(power).setInteger("currentLevel", holocron.stackTagCompound.getCompoundTag(Resources.nbtPowers).getCompoundTag(power).getInteger("currentLevel") + 1);
		StarWarsMod.network.sendToAll(new MessageHolocronRefreshClientPowers(this.player, holocron.stackTagCompound));
		return null;
	}

}