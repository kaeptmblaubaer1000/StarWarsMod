package com.parzi.starwarsmod.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class CommandFlySpeed implements ICommand
{
	private List aliases;

	public CommandFlySpeed()
	{
		aliases = new ArrayList();
		aliases.add("flyspd");
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
		return aliases;
	}

	@Override
	public String getCommandName()
	{
		return "flyspd";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "flyspd <speed>";
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i)
	{
		return false;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		if (astring.length == 0)
		{
			icommandsender.addChatMessage(new ChatComponentText("Usage: flyspd <speed>"));
			return;
		}

		String oldspd = String.valueOf(Minecraft.getMinecraft().thePlayer.capabilities.getFlySpeed());
		Minecraft.getMinecraft().thePlayer.capabilities.setFlySpeed(Float.parseFloat(astring[0]));
		icommandsender.addChatMessage(new ChatComponentText("Changed flight speed from " + oldspd + " to " + astring[0] + "."));

	}
}
