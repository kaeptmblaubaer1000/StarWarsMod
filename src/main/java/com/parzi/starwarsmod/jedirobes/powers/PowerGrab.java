package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.entity.Entity;

public class PowerGrab extends Power
{
	public PowerGrab(int currentLevel)
	{
		super("grab");
		this.costBase = 1950;
		this.costMult = 75;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 3;
		this.rangeBase = 2;
		this.rangeMult = 2;
		this.durationBase = 2;
		this.durationMult = 2;
		this.isDurationBased = true;
	}
}
