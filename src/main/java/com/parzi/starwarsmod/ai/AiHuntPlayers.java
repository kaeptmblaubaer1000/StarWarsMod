package com.parzi.starwarsmod.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;

public class AiHuntPlayers extends EntityAIBase
{
	private final EntityLiving entityHost;
	private final IRangedAttackMob rangedAttackEntityHost;
	private EntityLivingBase attackTarget;
	private int rangedAttackTime;
	private double entityMoveSpeed;
	private int field_75318_f;
	private int field_96561_g;
	private int maxRangedAttackTime;
	private float field_96562_i;
	private float field_82642_h;

	public AiHuntPlayers(IRangedAttackMob p_i1649_1_, double p_i1649_2_, int p_i1649_4_, float p_i1649_5_)
	{
		this(p_i1649_1_, p_i1649_2_, p_i1649_4_, p_i1649_4_, p_i1649_5_);
	}

	public AiHuntPlayers(IRangedAttackMob p_i1650_1_, double p_i1650_2_, int p_i1650_4_, int p_i1650_5_, float p_i1650_6_)
	{
		this.rangedAttackTime = -1;
		if (!(p_i1650_1_ instanceof EntityLivingBase))
			throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
		this.rangedAttackEntityHost = p_i1650_1_;
		this.entityHost = (EntityLiving)p_i1650_1_;
		this.entityMoveSpeed = p_i1650_2_;
		this.field_96561_g = p_i1650_4_;
		this.maxRangedAttackTime = p_i1650_5_;
		this.field_96562_i = p_i1650_6_;
		this.field_82642_h = p_i1650_6_ * p_i1650_6_;
		this.setMutexBits(3);
	}

	@Override
	public boolean continueExecuting()
	{
		return false;
	}

	@Override
	public void resetTask()
	{
		this.attackTarget = null;
		this.field_75318_f = 0;
		this.rangedAttackTime = -1;
	}

	@Override
	public boolean shouldExecute()
	{
		EntityLivingBase entitylivingbase = this.entityHost.getAttackTarget();
		if (entitylivingbase == null)
			return false;
		this.attackTarget = entitylivingbase;
		return true;
	}

	@Override
	public void updateTask()
	{
		double d0 = this.entityHost.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ);
		boolean flag = this.entityHost.getEntitySenses().canSee(this.attackTarget);
		if (flag)
			this.field_75318_f += 1;
		else
			this.field_75318_f = 0;
		this.entityHost.getNavigator().tryMoveToEntityLiving(this.attackTarget, this.entityMoveSpeed);
		this.entityHost.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30.0F, 30.0F);
		if (--this.rangedAttackTime == 0)
		{
			if (d0 > this.field_82642_h || !flag)
				return;
			float f = MathHelper.sqrt_double(d0) / this.field_96562_i;
			float f1 = f;
			if (f < 0.1F)
				f1 = 0.1F;
			if (f1 > 1.0F)
				f1 = 1.0F;
			this.rangedAttackEntityHost.attackEntityWithRangedAttack(this.attackTarget, f1);
			this.rangedAttackTime = MathHelper.floor_float(f * (this.maxRangedAttackTime - this.field_96561_g) + this.field_96561_g);
		}
		else if (this.rangedAttackTime < 0)
		{
			float f = MathHelper.sqrt_double(d0) / this.field_96562_i;
			this.rangedAttackTime = MathHelper.floor_float(f * (this.maxRangedAttackTime - this.field_96561_g) + this.field_96561_g);
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\ai\AiHuntPlayers.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */