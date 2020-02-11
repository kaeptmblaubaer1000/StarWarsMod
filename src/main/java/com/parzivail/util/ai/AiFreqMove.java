package com.parzivail.util.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

import java.util.Random;

public class AiFreqMove extends EntityAIBase
{
	private EntityLiving entity;
	private double xPosition;
	private double yPosition;
	private double zPosition;
	private double speed;
	private int freq;
	private int maxDistance = 10;
	private Block preferredBlock = Blocks.grass;

	public AiFreqMove(EntityLiving entity, double speed, int freq)
	{
		this.entity = entity;
		this.speed = speed;
		this.freq = freq;
		this.setMutexBits(1);
	}

	public AiFreqMove(EntityLiving entity, double speed, int freq, int maxDist, Block preferredBlock)
	{
		this.entity = entity;
		this.speed = speed;
		this.freq = freq;
		this.maxDistance = maxDist;
		this.preferredBlock = preferredBlock;
		this.setMutexBits(1);
	}

	@Override
	public boolean continueExecuting()
	{
		return !this.entity.getNavigator().noPath();
	}

	private Vec3 findRandomTarget(EntityLiving entity, int maxDistanceX, int maxDistanceY)
	{
		Random random = entity.getRNG();
		boolean flag = false;
		int k = 0;
		int l = 0;
		int i1 = 0;
		float f = -99999.0F;
		for (int l1 = 0; l1 < 10; l1++)
		{
			int j1 = random.nextInt(2 * maxDistanceX) - maxDistanceX;
			int i2 = random.nextInt(2 * maxDistanceY) - maxDistanceY;
			int k1 = random.nextInt(2 * maxDistanceX) - maxDistanceX;
			j1 += MathHelper.floor_double(entity.posX);
			i2 += MathHelper.floor_double(entity.posY);
			k1 += MathHelper.floor_double(entity.posZ);
			float f1 = this.getBlockPathWeight(entity, j1, i2, k1);
			if (f1 > f)
			{
				f = f1;
				k = j1;
				l = i2;
				i1 = k1;
				flag = true;
			}
		}
		if (flag)
			return Vec3.createVectorHelper(k, l, i1);
		return null;
	}

	private float getBlockPathWeight(EntityLiving entity, int p_70783_1_, int p_70783_2_, int p_70783_3_)
	{
		return entity.worldObj.getBlock(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == this.preferredBlock ? 0.0F : entity.worldObj.getLightBrightness(p_70783_1_, p_70783_2_, p_70783_3_) - 0.5F;
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.freq == 0 || this.entity.getRNG().nextInt(this.freq) == 0)
		{
			Vec3 vec3 = this.findRandomTarget(this.entity, this.maxDistance, this.maxDistance);
			if (vec3 == null)
				return false;
			this.xPosition = vec3.xCoord;
			this.yPosition = vec3.yCoord;
			this.zPosition = vec3.zCoord;
			return true;
		}
		return false;
	}

	@Override
	public void startExecuting()
	{
		this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
	}
}
