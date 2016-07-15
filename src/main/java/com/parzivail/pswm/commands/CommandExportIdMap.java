package com.parzivail.pswm.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;

public class CommandExportIdMap implements ICommand
{
	private List aliases;

	public CommandExportIdMap()
	{
		this.aliases = new ArrayList();
		this.aliases.add("sw-expmap");
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
	{
		return null;
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
		return true;
	}

	@Override
	public int compareTo(Object o)
	{
		return 0;
	}

	@Override
	public List getCommandAliases()
	{
		return this.aliases;
	}

	@Override
	public String getCommandName()
	{
		return "sw-expmap";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "sw-expmap";
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i)
	{
		return false;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		if (astring.length != 0)
		{
			icommandsender.addChatMessage(new ChatComponentText("Usage: sw-expmap"));
			return;
		}
		try
		{

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
