package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.entity.Entity;

public class PowerLightning extends Power
{
	Entity target = null;

	public PowerLightning(int currentLevel)
	{
		super("lightning");
		this.costBase = 3680;
		this.costMult = 80;
		this.currentLevel = currentLevel;
		this.maxLevel = 6;
		this.rechargeTime = 3;
		this.rangeBase = 4;
		this.rangeMult = 2;
		this.durationBase = 4;
		this.durationMult = 4;
		this.healthBase = 1;
		this.healthMult = 1;
		this.isDurationBased = true;
	}
}
