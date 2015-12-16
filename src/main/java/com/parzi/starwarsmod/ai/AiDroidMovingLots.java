package com.parzi.starwarsmod.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class AiDroidMovingLots extends net.minecraft.entity.ai.EntityAIBase
{
	private EntityCreature entity;
	private double xPosition;
	private double yPosition;
	private double zPosition;
	private double speed;
	private int freq;

	public AiDroidMovingLots(EntityCreature p_i1648_1_, double p_i1648_2_, int freq)
	{
		this.entity = p_i1648_1_;
		this.speed = p_i1648_2_;
		this.freq = freq;
		this.setMutexBits(1);
	}

	@Override
	public boolean continueExecuting()
	{
		return !this.entity.getNavigator().noPath();
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.entity.getAge() >= 100)
			return false;
		if (this.entity.getRNG().nextInt(this.freq) != 0)
			return false;
		Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);
		if (vec3 == null)
			return false;
		this.xPosition = vec3.xCoord;
		this.yPosition = vec3.yCoord;
		this.zPosition = vec3.zCoord;
		return true;
	}

	@Override
	public void startExecuting()
	{
		this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\ai\AiDroidMovingLots.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */