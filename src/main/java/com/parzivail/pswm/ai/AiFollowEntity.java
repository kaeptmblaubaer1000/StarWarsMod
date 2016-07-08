package com.parzivail.pswm.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class AiFollowEntity extends EntityAIBase
{
	private EntityLiving theEntity;
	private Entity targetEntity;
	private double speed;
	private int ticksUntilPathUpdate;

	public AiFollowEntity(EntityLiving thisEntity, Entity target, double speed)
	{
		this.theEntity = thisEntity;
		this.targetEntity = target;
		this.speed = speed;
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
		return !(this.theEntity == null || this.targetEntity == null) && this.targetEntity.isEntityAlive();

	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean continueExecuting()
	{
		return shouldExecute();
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
		this.targetEntity = null;
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