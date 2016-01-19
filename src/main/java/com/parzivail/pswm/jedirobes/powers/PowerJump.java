package com.parzivail.pswm.jedirobes.powers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public class PowerJump extends Power
{
	public PowerJump(int currentLevel)
	{
		super("jump");
		this.costBase = 25;
		this.costMult = 25;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 3 * 40; // 40 ticks/second
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		if (this.recharge == 0)
		{
			player.motionY = 0.41999998688697815D;

			player.motionY += (this.currentLevel + 1) * 0.11F;

			if (player.isSprinting())
			{
				float f = player.rotationYaw * 0.017453292F;
				player.motionX -= MathHelper.sin(f) * 0.2F;
				player.motionZ += MathHelper.cos(f) * 0.2F;
			}

			player.isAirBorne = true;
			player.fallDistance = 0.0f;

			return true;
		}
		return false;
	}
}
