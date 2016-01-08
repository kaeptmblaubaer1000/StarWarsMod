package com.parzi.starwarsmod.jedirobes.powers;

public class PowerDeflect extends Power
{
	public PowerDeflect(int currentLevel)
	{
		super("deflect");
		this.costBase = 1050;
		this.costMult = 50;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 10;
		this.durationBase = 2;
		this.durationMult = 2;
		this.isDurationBased = true;
	}
}
