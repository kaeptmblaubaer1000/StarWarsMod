package com.parzi.starwarsmod.jedirobes.powers;

import com.parzi.starwarsmod.utils.PotionList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;

public class PowerJump extends Power
{
	public PowerJump(int currentLevel)
	{
		super("jump");
		this.baseCost = 25;
		this.costMult = 25;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 3;
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		if (this.recharge == 0)
		{
			player.motionY = 0.41999998688697815D;

			player.motionY += (double)((float)(this.currentLevel + 1) * 0.11F);

			if (player.isSprinting())
			{
				float f = player.rotationYaw * 0.017453292F;
				player.motionX -= (double)(MathHelper.sin(f) * 0.2F);
				player.motionZ += (double)(MathHelper.cos(f) * 0.2F);
			}

			player.isAirBorne = true;

			return true;
		}
		return false;
	}
}
