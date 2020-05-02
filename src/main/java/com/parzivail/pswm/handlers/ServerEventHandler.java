package com.parzivail.pswm.handlers;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.Cron;
import com.parzivail.pswm.force.Force;
import com.parzivail.pswm.force.ForceUser;
import com.parzivail.pswm.force.exceptions.NotAForceUserException;
import com.parzivail.util.ui.TextEffects;
import com.parzivail.util.ui.TextUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;

public class ServerEventHandler
{
	// this event only occurs on server-side in multiplayer
	@SubscribeEvent
	public void onXpPickup(PlayerPickupXpEvent event)
	{
		final ForceUser forceUser;
		final EntityPlayer player = event.entityPlayer;
		try
		{
			forceUser = new ForceUser(player);
		}
		catch (NotAForceUserException e)
		{
			return;
		}
		ItemStack holocron = forceUser.getItemStack();
		int currentLevel = Cron.getLevel(holocron);
		if (StarWarsMod.rngGeneral.nextInt(100) <= Cron.getPercentForLevel(currentLevel))
		{
			if (forceUser.addXpAndCheckLevelUp())
			{
				forceUser.setUpgradePoints(forceUser.getUpgradePoints() + 1);
				forceUser.sync();
				player.addChatMessage(new ChatComponentText("[Holocron] Level up! You gained an upgrade point."));
				player.addChatMessage(new ChatComponentText(String.format("[Holocron] You are now level %d and have %d upgrade points.", forceUser.getLevel(), forceUser.getUpgradePoints())));
				if (forceUser.getLevel() >= 35 && !Force.getAskedJediSith(forceUser.getItemStack()))
				{
					player.addChatMessage(new ChatComponentText(String.format("[Holocron] %s", TextUtils.makeItalic(TextUtils.addEffect("You hear a dark whisper. Do you answer?", TextEffects.COLOR_DARK_GRAY)))));
					player.openGui(StarWarsMod.instance, Resources.GUI_JEDI_SITH, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
				}
			}
		}
	}
}
