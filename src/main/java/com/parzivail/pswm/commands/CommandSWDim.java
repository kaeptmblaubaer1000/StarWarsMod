package com.parzivail.pswm.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

import com.parzivail.pswm.world.TransferDim;

public class CommandSWDim implements ICommand
{
	private List aliases;

	public CommandSWDim()
	{
		this.aliases = new ArrayList();
		this.aliases.add("sw-dim");
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
		return "sw-dim";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "sw-dim <dim>";
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
				new TransferDim(MinecraftServer.getServer().worldServerForDimension(dim)).teleport(player);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\commands\CommandSWDim.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */