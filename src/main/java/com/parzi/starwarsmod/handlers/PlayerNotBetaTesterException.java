package com.parzi.starwarsmod.handlers;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerNotBetaTesterException extends Exception
{
	public PlayerNotBetaTesterException()
	{
		super();
	}

	public PlayerNotBetaTesterException(EntityPlayer player)
	{
		super("Player \"" + player.getCommandSenderName() + "\" is not a registered Beta tester!");
	}
}
