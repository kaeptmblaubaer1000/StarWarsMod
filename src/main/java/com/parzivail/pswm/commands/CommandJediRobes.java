package com.parzivail.pswm.commands;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.force.Cron;
import com.parzivail.util.ui.LangUtils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;

public class CommandJediRobes extends CommandBase
{
	@Override
	public List addTabCompletionOptions(ICommandSender commandSender, String[] parameters)
	{
		List<String> commands = new ArrayList<>();

		if (parameters.length == 1)
		{
			commands.add("level");
			commands.add("xp");
			commands.add("maxxp");
			commands.add("side");
		}
		return commands;
	}

	@Override
	public String getCommandName()
	{
		return "cron";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/cron <level | xp | maxxp | side> <integer value>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		if (astring.length != 2)
		{
			icommandsender.addChatMessage(new ChatComponentText(LangUtils.translate("invalid.args.usage.0", this.getCommandUsage(icommandsender))));
			return;
		}

		String key = astring[0];
		int value = parseInt(icommandsender, astring[1]);

		EntityPlayerMP player = getCommandSenderAsPlayer(icommandsender);

		if (player != null && Cron.getHolocron(player) != null && (key.equalsIgnoreCase("level") || key.equalsIgnoreCase("side") || key.equalsIgnoreCase("xp") || key.equalsIgnoreCase("maxxp")))
		{
			ItemStack robes = Cron.getHolocron(player);
			Cron.getXP(robes);
			Cron.getMaxXP(robes);

			if (key.equalsIgnoreCase("level"))
				robes.stackTagCompound.setInteger(key, (int)(value * Cron.POINTS_PER_LEVEL));
			else if (key.equalsIgnoreCase("side"))
				switch (value)
				{
					case 0:
						robes.stackTagCompound.setString(Resources.nbtSide, Cron.SIDE_JEDI);
						break;
					case 1:
						robes.stackTagCompound.setString(Resources.nbtSide, Cron.SIDE_SITH);
						break;
				}
			else
				robes.stackTagCompound.setInteger(key, value);
			icommandsender.addChatMessage(new ChatComponentText(LangUtils.translate("holocron.set.0.to.1", key, String.valueOf(value))));

			if (key.equalsIgnoreCase("level"))
			{
				robes.stackTagCompound.setInteger(Resources.nbtMaxXp, (value + 1) * 100);
				icommandsender.addChatMessage(new ChatComponentText(LangUtils.translate("holocron.set.max.xp.to.0", String.valueOf((value + 1) * 100))));
				robes.stackTagCompound.setInteger(Resources.nbtRemainingPts, value);
				icommandsender.addChatMessage(new ChatComponentText(LangUtils.translate("holocron.set.remaining.upgrade.points.to.0", String.valueOf(value))));
			}
		}
		else
		{
			ItemStack robes = Cron.getHolocron(player);
			icommandsender.addChatMessage(new ChatComponentText(LangUtils.translate("holocron.usage.0", this.getCommandUsage(icommandsender))));
			if (player == null)
				icommandsender.addChatMessage(new ChatComponentText(LangUtils.translate("holocron.error.ship.is.null")));
			else if (robes == null)
				icommandsender.addChatMessage(new ChatComponentText(LangUtils.translate("holocron.error.you.must.have.a.holocron")));
			else
				icommandsender.addChatMessage(new ChatComponentText(LangUtils.translate("holocron.unknown.key")));
		}
	}
}
