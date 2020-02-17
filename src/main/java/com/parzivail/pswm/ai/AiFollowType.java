package com.parzivail.pswm.ai;

import com.parzivail.util.world.WorldUtils;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

import java.util.List;

public class AiFollowType extends EntityAIBase
{
	private EntityLiving theEntity;
	private Class<? extends EntityLiving> targetEntityClass;
	private EntityLiving targetEntity;
	private double speed;
	private float range;
	private int ticksUntilPathUpdate;

	public AiFollowType(EntityLiving thisEntity, Class<? extends EntityLiving> target, double speed, float range)
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

		List<? extends EntityLiving> list = WorldUtils.getEntitiesWithinAABB(this.theEntity.worldObj, targetEntityClass, this.theEntity.boundingBox.expand(range, range, range));
		EntityLiving entityAnimal = null;

		for (EntityLiving aList : list)
			entityAnimal = aList;

		if (entityAnimal == null)
		{
			return false;
		}
		else
		{
			this.targetEntity = entityAnimal;
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