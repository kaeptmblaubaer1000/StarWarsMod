package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.PacketEntityAlterMotion;
import com.parzi.starwarsmod.utils.EntityUtils;

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
		this.rechargeTime = 30;
		this.rangeBase = 4;
		this.rangeMult = 2;
		this.durationBase = 4;
		this.durationMult = 4;
		this.healthBase = 1;
		this.healthMult = 1;
		this.isDurationBased = true;
	}

	public void setTarget(Entity e)
	{
		this.target = e;
	}

	public Entity getTarget()
	{
		return this.target;
	}
}
