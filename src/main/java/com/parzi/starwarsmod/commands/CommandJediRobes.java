package com.parzi.starwarsmod.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;

public class CommandJediRobes extends CommandBase
{
	@Override
	public List addTabCompletionOptions(ICommandSender commandSender, String[] parameters)
	{
		List<String> commands = new ArrayList<String>();

		if (parameters.length == 1)
		{
			commands.add("level");
			commands.add("xp");
			commands.add("maxxp");
		}
		return commands;
	}

	@Override
	public String getCommandName()
	{
		return "robes";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "robes <level|xp|maxxp> <int:value>";
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		if (astring.length != 2)
		{
			icommandsender.addChatMessage(new ChatComponentText("Invalid args! Usage: " + this.getCommandUsage(icommandsender)));
			return;
		}

		String key = astring[0];
		int value = 0;

		value = parseInt(icommandsender, astring[1]);

		EntityPlayerMP player = getCommandSenderAsPlayer(icommandsender);

		if (player != null && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes && (key.equalsIgnoreCase("level") || key.equalsIgnoreCase("xp") || key.equalsIgnoreCase("maxxp")))
		{
			ItemStack robes = player.inventory.armorItemInSlot(2);
			ArmorJediRobes.getXP(robes);
			ArmorJediRobes.getMaxXP(robes);

			player.inventory.armorItemInSlot(2).stackTagCompound.setInteger(key, value);
			icommandsender.addChatMessage(new ChatComponentText("[Robes] Set " + key + " to " + String.valueOf(value) + "."));

			if (key.equalsIgnoreCase("level"))
			{
				player.inventory.armorItemInSlot(2).stackTagCompound.setInteger(Resources.nbtMaxXp, (value + 1) * 100);
				icommandsender.addChatMessage(new ChatComponentText("[Robes] Set Max XP to " + String.valueOf((value + 1) * 100) + "."));
				player.inventory.armorItemInSlot(2).stackTagCompound.setInteger(Resources.nbtRemainingPts, value);
				icommandsender.addChatMessage(new ChatComponentText("[Robes] Set Remaining Upgrade Points to " + String.valueOf(value) + "."));
			}
		}
		else
		{
			icommandsender.addChatMessage(new ChatComponentText("Usage: " + this.getCommandUsage(icommandsender)));
			if (player == null)
				icommandsender.addChatMessage(new ChatComponentText("Error: player is null!"));
			else if (player.inventory.armorItemInSlot(2) == null)
				icommandsender.addChatMessage(new ChatComponentText("Note: You must be wearing robes!"));
			else if (player.inventory.armorItemInSlot(2).getItem() != StarWarsMod.jediRobes)
				icommandsender.addChatMessage(new ChatComponentText("Note: You must be wearing robes!"));
			else
				icommandsender.addChatMessage(new ChatComponentText("Unknown key!"));
			return;
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\commands\CommandFlySpeed.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */