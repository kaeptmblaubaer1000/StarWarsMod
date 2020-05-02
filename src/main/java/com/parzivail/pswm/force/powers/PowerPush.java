package com.parzivail.pswm.force.powers;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.ForcePower;
import com.parzivail.pswm.network.MessageEntityAlterMotion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;

public class PowerPush extends ForcePower
{
	public static PowerPush INSTANCE = new PowerPush();
	private PowerPush()
	{
		this.name = "push";
		this.maxLevel = 5;
		this.costBase = 40;
		this.costMultiplier = 40;
		this.rechargeTime = 5 * 20; // 20 ticks/second
		this.side = null;
	}

	@Override
	public boolean activate(EntityPlayer player, NBTTagCompound data, Entity target)
	{

		if (!super.activate(player, data, target) || target == null)
			return false;
		final PowerData power = new PowerData(data);
		if (player.getDistanceToEntity(target) <= power.getMaxDistance())
		{
			Vec3 lookVec = player.getLookVec();

			float mult = 1 + 0.5f * power.getLevel();

			target.motionX += lookVec.xCoord * mult;
			target.motionY += lookVec.yCoord * mult;
			target.motionZ += lookVec.zCoord * mult;
			target.isAirBorne = true;

			if (target instanceof EntityPlayer)
				((EntityPlayer)target).velocityChanged = true;

			StarWarsMod.network.sendToServer(new MessageEntityAlterMotion(target, lookVec));

			player.worldObj.playSound(player.posX, player.posY, player.posZ, Resources.MODID + ":" + "force.push", 1, 1, true);
		}

		return true;
	}

	private final class PowerData extends ForcePower.PowerData
	{
		public PowerData(NBTTagCompound compoundTag)
		{
			super(compoundTag);
		}

		public int getMaxDistance()
		{
			return getLevel() * 2;
		}
	}
}
