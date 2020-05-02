package com.parzivail.pswm.force;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nullable;

public abstract class ForcePower
{
	public String name;
	public int maxLevel;
	public int costMultiplier;
	public int costBase;
	public int rechargeTime;
	public boolean isSingleAction = true;

	public String untranslatedName;
	public String untranslatedDescription;
	@Nullable
	public Force.ForceSide side;

	@SideOnly(Side.CLIENT)
	public String translatedName;
	@SideOnly(Side.CLIENT)
	public String translatedDescription;

	public boolean activate(EntityPlayer player, NBTTagCompound data, Entity target)
	{
		final PowerData power = new PowerData(data);
		return power.getRemainingRecharge() == 0 && power.getLevel() > 0;
	}

	public class PowerData
	{
		private final NBTTagCompound compoundTag;

		public PowerData(NBTTagCompound compoundTag)
		{
			this.compoundTag = compoundTag;
		}

		public int getRemainingRecharge()
		{
			return compoundTag.getInteger("recharge");
		}

		public void setRemainingRecharge(int recharge)
		{
			compoundTag.setInteger("recharge", recharge);
		}

		public int getLevel()
		{
			return compoundTag.getInteger("level");
		}

		public void setLevel(int level)
		{
			compoundTag.setInteger("level", level);
		}

		public int getCost()
		{
			return costBase + costMultiplier * getLevel();
		}

		public int getMaxLevel()
		{
			return maxLevel;
		}

		public boolean isRecharging()
		{
			return getRemainingRecharge() > 0;
		}

		public NBTTagCompound getData()
		{
			return compoundTag;
		}
	}
}
