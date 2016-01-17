package com.parzi.starwarsmod.jedirobes.powers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.MessageEntityAlterMotion;
import com.parzi.util.entity.EntityUtils;

public class PowerPull extends Power
{
	public PowerPull(int currentLevel)
	{
		super("pull");
		this.costBase = 240;
		this.costMult = 40;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 5 * 40; // 40 ticks/second
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		if (this.recharge == 0)
		{
			Entity e = EntityUtils.rayTrace(this.currentLevel * 3, player, new Entity[0]);

			if (e != null)
			{
				Vec3 lookVec = player.getLookVec();

				float mult = 1 + 0.5f * this.currentLevel;

				lookVec.xCoord *= -mult;
				lookVec.yCoord *= -mult;
				lookVec.zCoord *= -mult;

				StarWarsMod.network.sendToServer(new MessageEntityAlterMotion(e, lookVec));
			}

			return true;
		}
		return false;
	}
}
