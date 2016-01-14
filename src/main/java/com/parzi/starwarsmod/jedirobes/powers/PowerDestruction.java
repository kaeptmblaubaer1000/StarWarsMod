package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.entity.player.EntityPlayer;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.MessageCreateDestructionBolt;

public class PowerDestruction extends Power
{
	public PowerDestruction(int currentLevel)
	{
		super("destruction");
		this.costBase = 4590;
		this.costMult = 90;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 6;
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		if (this.recharge == 0)
		{
			StarWarsMod.network.sendToServer(new MessageCreateDestructionBolt(player, 2 + 2 * this.currentLevel));

			return true;
		}
		return false;
	}
}
