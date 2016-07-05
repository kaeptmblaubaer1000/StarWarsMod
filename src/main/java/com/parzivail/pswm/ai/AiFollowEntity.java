package com.parzivail.pswm.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

import java.util.List;

public class AiFollowEntity extends EntityAIBase
{
	private EntityLiving theEntity;
	private Class<? extends EntityLiving> targetEntityClass;
	private EntityLiving targetEntity;
	private double speed;
	private float range;
	private int ticksUntilPathUpdate;

	public AiFollowEntity(EntityLiving thisEntity, Class<? extends EntityLiving> target, double speed, float range)
	{
		this.theEntity = thisEntity;
		this.targetEntityClass = target;
		this.speed = speed;
		this.range = range;
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
		if (this.theEntity == null || this.targetEntityClass == null)
			return false;

		List list = this.theEntity.worldObj.getEntitiesWithinAABB(targetEntityClass, this.theEntity.boundingBox.expand(range, range, range));
		EntityLiving entityanimal = null;

		for (Object aList : list)
			entityanimal = (EntityLiving)aList;

		if (entityanimal == null)
		{
			return false;
		}
		else
		{
			this.targetEntity = entityanimal;
			return true;
		}
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean continueExecuting()
	{
		return !(this.theEntity == null || this.targetEntity == null) && this.targetEntity.isEntityAlive();
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting()
	{
		this.ticksUntilPathUpdate = 0;
	}

	/**
	 * Resets the task
	 */
	public void resetTask()
	{
		this.targetEntityClass = null;
	}

	/**
	 * Updates the task
	 */
	public void updateTask()
	{
		if (--this.ticksUntilPathUpdate <= 0)
		{
			this.ticksUntilPathUpdate = 10;
			this.theEntity.getNavigator().tryMoveToEntityLiving(this.targetEntity, this.speed);
		}
	}
}