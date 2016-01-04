package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.PacketEntityAlterMotion;
import com.parzi.starwarsmod.utils.EntityUtils;

public class PowerDefend extends Power
{
	public int health = 0;
	public boolean isRunning = false;

	public PowerDefend(int currentLevel)
	{
		super("defend");
		this.costBase = 550;
		this.costMult = 50;
		this.currentLevel = currentLevel;
		this.maxLevel = 60;
		this.rechargeTime = 10;
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
