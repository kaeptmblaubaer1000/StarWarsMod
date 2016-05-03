package com.parzivail.pswm.jedirobes.powers;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageEntityAlterMotion;
import com.parzivail.util.entity.EntityUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

public class PowerPush extends Power
{
	public PowerPush(int currentLevel)
	{
		super("push");
		this.costBase = 40;
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
			Entity e = EntityUtils.rayTrace(this.currentLevel * 2, player, new Entity[0]);

			if (e != null)
			{
				Vec3 lookVec = player.getLookVec();

				float mult = 1 + 0.5f * this.currentLevel;

				lookVec.xCoord *= mult;
				lookVec.yCoord *= mult;
				lookVec.zCoord *= mult;

				StarWarsMod.network.sendToServer(new MessageEntityAlterMotion(e, lookVec));
			}

			return true;
		}
		return false;
	}
}
