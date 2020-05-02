package com.parzivail.pswm.force.powers_old;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageEntityAlterMotion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

public class PowerPush extends PowerBase
{
	public PowerPush(int currentLevel)
	{
		super("push");
		this.costBase = 40;
		this.costMult = 40;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 5 * 20; // 40 ticks/second
		this.recharge = 0;
	}

	@Override
	public boolean run(EntityPlayer player, Entity target)
	{
		if (this.recharge == 0)
		{
			if (target != null)
			{
				if (player.getDistanceToEntity(target) <= this.currentLevel * 2)
				{
					Vec3 lookVec = player.getLookVec();

					float mult = 1 + 0.5f * this.currentLevel;

					lookVec.xCoord *= mult;
					lookVec.yCoord *= mult;
					lookVec.zCoord *= mult;

					target.motionX += lookVec.xCoord;
					target.motionY += lookVec.yCoord;
					target.motionZ += lookVec.zCoord;
					target.isAirBorne = true;

					if (target instanceof EntityPlayer)
						((EntityPlayer)target).velocityChanged = true;

					StarWarsMod.network.sendToServer(new MessageEntityAlterMotion(target, lookVec));

					player.worldObj.playSound(player.posX, player.posY, player.posZ, Resources.MODID + ":" + "force.push", 1, 1, true);
				}
			}

			return true;
		}
		return false;
	}
}
