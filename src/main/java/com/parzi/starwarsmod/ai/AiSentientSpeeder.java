package com.parzi.starwarsmod.ai;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class AiSentientSpeeder extends EntityAIBase
{
	private EntityLiving entity;
	private double xPosition;
	private double yPosition;
	private double zPosition;
	private double speed;
	private int maxDistance = 10;

	public AiSentientSpeeder(EntityLiving p_i1648_1_, double speed, int maxDist)
	{
		this.entity = p_i1648_1_;
		this.speed = speed;
		this.maxDistance = maxDist;
		this.setMutexBits(1);
	}

	@Override
	public boolean continueExecuting()
	{
		return !this.entity.getNavigator().noPath();
	}

	public void findRandomTarget(EntityLiving entity, int maxDistanceX, int maxDistanceY)
	{
		Random random = entity.getRNG();
		int x, y, z;
		xPosition = random.nextInt(2 * maxDistanceX) - maxDistanceX;
		yPosition = random.nextInt(2 * maxDistanceY) - maxDistanceY;
		zPosition = random.nextInt(2 * maxDistanceX) - maxDistanceX;
		xPosition += MathHelper.floor_double(entity.posX);
		yPosition += MathHelper.floor_double(entity.posY);
		zPosition += MathHelper.floor_double(entity.posZ);
	}

	@Override
	public boolean shouldExecute()
	{
		return true;
	}

	@Override
	public void startExecuting()
	{
		this.findRandomTarget(this.entity, this.maxDistance, this.maxDistance);
		this.entity.getNavigator().tryMoveToXYZ(xPosition, yPosition, zPosition, this.speed);
	}
}