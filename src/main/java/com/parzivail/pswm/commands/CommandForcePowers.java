package com.parzivail.pswm.commands;

import com.parzivail.pswm.force.Force;
import com.parzivail.pswm.force.ForceUser;
import com.parzivail.pswm.force.exceptions.NotAForceUserException;
import com.parzivail.util.common.PendingRename;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CommandForcePowers extends CommandBase
{
	@Override
	@PendingRename(PendingRename.Kind.FORCE_XP) // inside the strings
	public List<String> addTabCompletionOptions(ICommandSender commandSender, String[] parameters)
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
		return "forcePowers";
	}

	@Override
	@PendingRename(PendingRename.Kind.FORCE_XP) // inside the string
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/forcePowers <level | xp | maxxp | side> <integer value>";
	}

	@PendingRename(PendingRename.Kind.FORCE_XP) // inside the strings
	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		if (astring.length != 2)
		{
			icommandsender.addChatMessage(new ChatComponentText(String.format("Invalid args! Usage: %s", this.getCommandUsage(icommandsender))));
			return;
		}

		String key = astring[0];
		String value = astring[1];
		int intValue = 0;

		EntityPlayer player = getCommandSenderAsPlayer(icommandsender);

		if (key.equalsIgnoreCase("level") || key.equalsIgnoreCase("side") || key.equalsIgnoreCase("xp") || key.equalsIgnoreCase("maxxp"))
		{
			ForceUser forceUser;
			try
			{
				forceUser = new ForceUser(player);
			}
			catch (NotAForceUserException e)
			{
				icommandsender.addChatMessage(new ChatComponentText("You need a Holocron to use this command."));
				return;
			}

			switch (key.toLowerCase(Locale.ROOT))
			{
				case "level":
					forceUser.setLevel(parseInt(icommandsender, value));
					icommandsender.addChatMessage(new ChatComponentText(String.format("[Holocron] Set level to %s", value)));
					//robes.stackTagCompound.setInteger(Resources.nbtMaxXp, (intValue + 1) * 100);
					//icommandsender.addChatMessage(new ChatComponentText(String.format("[Holocron] Set Max XP to %s", (intValue + 1) * 100)));
					forceUser.setUpgradePoints(forceUser.getUpgradePoints() + 10 * intValue);
					icommandsender.addChatMessage(new ChatComponentText(String.format("[Holocron] Set remaining Upgrade Points to %s", value)));
					break;
				case "side":
					switch (value.toLowerCase())
					{
						case "jedi":
						case "0":
							forceUser.setSide(Force.ForceSide.JEDI);
							break;
						case "1":
						case "sith":
							forceUser.setSide(Force.ForceSide.SITH);
							break;
					}
					icommandsender.addChatMessage(new ChatComponentText(String.format("[Holocron] Set side to %s", value)));
					break;
				case "xp":
					forceUser.setXp(parseInt(icommandsender, value));
					icommandsender.addChatMessage(new ChatComponentText(String.format("[Holocron] Set xp to %s", value)));
					break;
				case "maxxp":
					// FIXME
					//icommandsender.addChatMessage(new ChatComponentText(String.format("[Holocron] Set %s to %s", key, value)));
					break;
			}
			icommandsender.addChatMessage(new ChatComponentText(String.format("[Holocron] Set %s to %s", key, value)));

			forceUser.sync();
		}
		else
		{
			icommandsender.addChatMessage(new ChatComponentText(String.format("[Holocron] Usage: %s", this.getCommandUsage(icommandsender))));
			icommandsender.addChatMessage(new ChatComponentText("[Holocron] Error! Unknown key."));
		}
	}
}
