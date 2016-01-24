package com.parzivail.pswm.jedirobes.powers;

public class PowerGrab extends Power
{
	public PowerGrab(int currentLevel)
	{
		super("grab");
		this.costBase = 1950;
		this.costMult = 75;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 15 * 40; // 40 ticks/second
		this.rangeBase = 2;
		this.rangeMult = 2;
		this.durationBase = 2 * 40; // 40 ticks/second
		this.durationMult = 2 * 40; // 40 ticks/second
		this.isDurationBased = true;
	}
}
