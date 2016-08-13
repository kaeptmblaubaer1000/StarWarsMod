package com.parzivail.pswm.force.powers;

import net.minecraft.entity.player.EntityPlayer;

public class PowerDefend extends PowerBase
{
	public PowerDefend(int currentLevel)
	{
		super("defend");
		this.costBase = 550;
		this.costMult = 50;
		this.currentLevel = currentLevel;
		this.maxLevel = 60;
		this.rechargeTime = 60 * 20; // 40 ticks/second
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		if (this.recharge == 0 && !this.isRunning)
		{
			this.isRunning = true;
			this.health = this.currentLevel;
			return true;
		}
		return false;
	}
}
