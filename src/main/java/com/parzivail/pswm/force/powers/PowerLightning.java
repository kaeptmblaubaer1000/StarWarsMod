package com.parzivail.pswm.force.powers;

import net.minecraft.nbt.NBTTagCompound;

public class PowerLightning extends PowerBase implements ICanHaveEntityTarget
{
	public int targetId = -1;

	public PowerLightning(int currentLevel)
	{
		super("lightning");
		this.costBase = 3680;
		this.costMult = 80;
		this.currentLevel = currentLevel;
		this.maxLevel = 6;
		this.rechargeTime = 30 * 20; // 40 ticks/second
		this.rangeBase = 4;
		this.rangeMult = 2;
		this.durationBase = 2 * 20; // 20 ticks/second
		this.durationMult = 2 * 20; // 20 ticks/second
		this.healthBase = 1;
		this.healthMult = 1;
		this.isDurationBased = true;
	}

	@Override
	public NBTTagCompound serialize()
	{
		NBTTagCompound compound = super.serialize();
		compound.setInteger("targetId", targetId);
		return compound;
	}

	@Override
	public PowerLightning deserialize(NBTTagCompound compound)
	{
		super.deserialize(compound);
		this.targetId = compound.getInteger("targetId");
		return this;
	}

	@Override
	public int getEntityTargetId()
	{
		return this.targetId;
	}

	@Override
	public void setEntityTargetId(int id)
	{
		this.targetId = id;
	}

	@Override
	public boolean hasEntityTarget()
	{
		return this.targetId != -1;
	}
}
