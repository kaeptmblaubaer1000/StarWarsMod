package com.parzivail.pswm.force.powers;

public class PowerDeflect extends PowerBase
{
	public PowerDeflect(int currentLevel)
	{
		super("deflect");
		this.costBase = 1050;
		this.costMult = 50;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 30 * 20; // 40 ticks/second
		this.durationBase = 2 * 20; // 40 ticks/second
		this.durationMult = 2 * 20; // 40 ticks/second
		this.isDurationBased = true;
	}
}
