package com.parzivail.pswm.force.powers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PowerDefend extends PowerBase
{
	public int health = 0;

	public PowerDefend(int currentLevel)
	{
		super("defend");
		this.costBase = 550;
		this.costMult = 50;
		this.currentLevel = currentLevel;
		this.maxLevel = 60;
		this.rechargeTime = 60 * 40; // 40 ticks/second
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

	@Override
	public NBTTagCompound serialize()
	{
		NBTTagCompound compound = super.serialize();
		compound.setInteger("health", health);
		return compound;
	}

	@Override
	public PowerDefend deserialize(NBTTagCompound compound)
	{
		super.deserialize(compound);
		this.health = compound.getInteger("health");
		return this;
	}
}
