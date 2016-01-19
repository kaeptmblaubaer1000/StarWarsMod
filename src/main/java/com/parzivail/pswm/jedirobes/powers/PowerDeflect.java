package com.parzivail.pswm.jedirobes.powers;

public class PowerDeflect extends Power
{
	public PowerDeflect(int currentLevel)
	{
		super("deflect");
		this.costBase = 1050;
		this.costMult = 50;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 10 * 40; // 40 ticks/second
		this.durationBase = 2 * 40; // 40 ticks/second
		this.durationMult = 2 * 40; // 40 ticks/second
		this.isDurationBased = true;
	}
}
