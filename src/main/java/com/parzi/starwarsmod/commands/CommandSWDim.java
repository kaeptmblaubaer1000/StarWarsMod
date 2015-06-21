package com.parzi.starwarsmod.commands;

import java.util.ArrayList;
import java.util.List;

import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;

public class CommandSWDim implements ICommand
{
	private List aliases;

	public CommandSWDim()
	{
		this.aliases = new ArrayList();
		this.aliases.add("sw-dim");
	}

	@Override
	public String getCommandName()
	{
		return "sw-dim";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "sw-dim <dim>";
	}

	@Override
	public List getCommandAliases()
	{
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		if (astring.length == 0)
		{
			icommandsender.addChatMessage(new ChatComponentText("Usage: sw-dim <dim>"));
			return;
		}
		try
		{
			EntityPlayerMP player = (EntityPlayerMP)icommandsender;
			int dim = Integer.parseInt(astring[0]);
			if (player.dimension != dim)
			{
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, dim);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
	{
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i)
	{
		return false;
	}

	@Override
	public int compareTo(Object o)
	{
		return 0;
	}
}
