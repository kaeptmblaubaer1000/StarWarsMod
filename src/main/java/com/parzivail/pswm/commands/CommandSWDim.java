package com.parzivail.pswm.commands;

import com.parzivail.pswm.handler.EventHandler;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CommandSWDim implements ICommand
{
	private List<String> aliases;

	@Override
	public String getName()
	{
		return "swdim";
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		return "swdim <dimension ID>";
	}

	@Override
	public List<String> getAliases()
	{
		if (aliases == null)
		{
			aliases = new ArrayList<>();
			aliases.add("swdim");
		}
		return aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (sender.getCommandSenderEntity() instanceof EntityPlayerMP)
		{
			try
			{
				int targetDim = Integer.parseInt(args[0]);
				EventHandler.queuePlayerDestination((EntityPlayerMP)sender.getCommandSenderEntity(), targetDim);
			}
			catch (NumberFormatException e)
			{
				throw new CommandException("First argument must be an integer (the target dimension!)");
			}
		}
		else
		{
			throw new CommandException("ICommandSender#getCommandSenderEntity did not return EntityPlayerMP");
		}
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender)
	{
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
	{
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index)
	{
		return false;
	}

	@Override
	public int compareTo(ICommand o)
	{
		return 0;
	}
}