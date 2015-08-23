package com.parzi.starwarsmod.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.armor.ArmorJediRobes;
import com.parzi.starwarsmod.armor.ArmorLightJediRobes;
import com.parzi.starwarsmod.network.JediRobesSetElementInArmorInv;

public class CommandForcePoints implements ICommand
{
	private List aliases;

	public CommandForcePoints()
	{
		aliases = new ArrayList();
		aliases.add("fcpts");
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
		return "fcpts";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "fcpts";
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
			icommandsender.addChatMessage(new ChatComponentText("Usage: fcpts"));
			return;
		}
		try
		{
			EntityPlayerMP player = (EntityPlayerMP)icommandsender;
			if (player.inventory.armorInventory[2] != null && (player.inventory.armorInventory[2].getItem() instanceof ArmorJediRobes || player.inventory.armorInventory[2].getItem() instanceof ArmorLightJediRobes))
			{
				StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("earth", 10000, player.dimension, player.getCommandSenderName()));
				StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("animals", 10000, player.dimension, player.getCommandSenderName()));
				StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("earth", 10000, player.dimension, player.getCommandSenderName()));
				StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("water", 10000, player.dimension, player.getCommandSenderName()));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
