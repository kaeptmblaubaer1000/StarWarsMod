package com.parzivail.pswm.force.powers;

import com.parzivail.util.entity.EntityUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PowerGrab extends PowerBase implements ICanHaveEntityTarget
{
	public int targetId = -1;

	public PowerGrab(int currentLevel)
	{
		super("grab");
		this.costBase = 1950;
		this.costMult = 75;
		this.currentLevel = currentLevel;
		this.maxLevel = 5;
		this.rechargeTime = 15 * 40; // 40 ticks/second
		this.rangeBase = 2;
		this.rangeMult = 2;
		this.durationBase = 2 * 40; // 40 ticks/second
		this.durationMult = 2 * 40; // 40 ticks/second
		this.isDurationBased = true;
	}

	@Override
	public boolean run(EntityPlayer player)
	{
		Entity e = EntityUtils.rayTrace(this.getRange(), player, new Entity[0]);

		if (e != null)
		{
			setEntityTargetId(e.getEntityId());
			this.isRunning = true;
			this.duration = 0;

			return true;
		}

		return super.run(player);
	}

	@Override
	public NBTTagCompound serialize()
	{
		NBTTagCompound compound = super.serialize();
		compound.setInteger("targetId", targetId);
		return compound;
	}

	@Override
	public PowerBase deserialize(NBTTagCompound compound)
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
