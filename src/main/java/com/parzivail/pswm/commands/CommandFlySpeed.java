package com.parzivail.pswm.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class CommandFlySpeed implements net.minecraft.command.ICommand
{
	private List aliases;

	public CommandFlySpeed()
	{
		this.aliases = new ArrayList();
		this.aliases.add("flyspd");
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
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\commands\CommandFlySpeed.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */