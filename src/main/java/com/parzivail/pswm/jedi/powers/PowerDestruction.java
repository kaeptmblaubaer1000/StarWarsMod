package com.parzivail.pswm.jedi.powers;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageCreateDestructionBolt;
import net.minecraft.entity.player.EntityPlayer;

public class PowerDestruction extends Power
{
	public PowerDestruction(int currentLevel)
	{
		super("destruction");
		this.costBase = 4590;
		this.costMult = 90;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 60 * 40; // 40 ticks/second
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
