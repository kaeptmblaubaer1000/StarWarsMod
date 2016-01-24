package com.parzivail.pswm.jedirobes.powers;

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
		this.rechargeTime = 30 * 40; // 40 ticks/second
		this.rangeBase = 4;
		this.rangeMult = 2;
		this.durationBase = 4 * 40; // 40 ticks/second
		this.durationMult = 4 * 40; // 40 ticks/second
		this.healthBase = 1;
		this.healthMult = 1;
		this.isDurationBased = true;
	}
}
