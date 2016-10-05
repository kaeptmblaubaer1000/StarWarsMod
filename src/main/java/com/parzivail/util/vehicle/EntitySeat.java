package com.parzivail.util.vehicle;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by colby on 10/4/2016.
 */
public class EntitySeat extends Entity
{
	DrivenBase parent;

	public EntitySeat(World world)
	{
		super(world);
	}

	public EntitySeat(World world, DrivenBase parent)
	{
		super(world);
		this.parent = parent;
	}

	@Override
	public void onUpdate()
	{
		if (this.ridingEntity != null && this.ridingEntity.isDead)
		{
			this.ridingEntity = null;
		}

		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.prevRotationPitch = this.rotationPitch;
		this.prevRotationYaw = this.rotationYaw;
	}

	@Override
	protected void entityInit()
	{

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_)
	{

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_)
	{

	}
}
