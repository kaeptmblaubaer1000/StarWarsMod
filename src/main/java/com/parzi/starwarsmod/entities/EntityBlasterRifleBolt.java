package com.parzi.starwarsmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityBlasterRifleBolt extends EntityThrowable
{
	private EntityPlayer sender;
	private int timeAlive = 0;

	public EntityBlasterRifleBolt(World par1World)
	{
		super(par1World);
	}

	public EntityBlasterRifleBolt(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
		sender = (EntityPlayer)par2EntityLivingBase;
	}

	public EntityBlasterRifleBolt(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer p_70100_1_)
	{
		return;
	}

	@Override
    public void setThrowableHeading(double p_70186_1_, double p_70186_3_, double p_70186_5_, float p_70186_7_, float p_70186_8_)
    {
        float f2 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_3_ * p_70186_3_ + p_70186_5_ * p_70186_5_);
        p_70186_1_ /= (double)f2;
        p_70186_3_ /= (double)f2;
        p_70186_5_ /= (double)f2;
        p_70186_1_ += 0.007499999832361937D * (double)p_70186_8_; // haha, no random
        p_70186_3_ += 0.007499999832361937D * (double)p_70186_8_;
        p_70186_5_ += 0.007499999832361937D * (double)p_70186_8_;
        p_70186_1_ *= (double)p_70186_7_;
        p_70186_3_ *= (double)p_70186_7_;
        p_70186_5_ *= (double)p_70186_7_;
        this.motionX = p_70186_1_;
        this.motionY = p_70186_3_;
        this.motionZ = p_70186_5_;
        float f3 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(p_70186_3_, (double)f3) * 180.0D / Math.PI);
    }

	@Override
	public void onUpdate()
	{
		if (timeAlive++ > 100)
		{
			this.setDead();
		}
		super.onUpdate();
	}

	@Override
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            this.setBeenAttacked();

            if (p_70097_1_.getEntity() != null)
            {
                Vec3 vec3 = p_70097_1_.getEntity().getLookVec();

                if (vec3 != null)
                {
                    this.motionX = vec3.xCoord;
                    this.motionY = vec3.yCoord;
                    this.motionZ = vec3.zCoord;
                }

                return true;
            }
            else
            {
                return false;
            }
        }
    }

	@Override
	protected void onImpact(MovingObjectPosition pos)
	{
		if (pos.typeOfHit == MovingObjectType.ENTITY && pos.entityHit != sender)
		{
			pos.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(sender), 5f);
			pos.entityHit.setFire(8);
		}
		else
		{
			if (worldObj.getBlock(pos.blockX, pos.blockY + 1, pos.blockZ) == Blocks.air)
			{
				worldObj.setBlock(pos.blockX, pos.blockY + 1, pos.blockZ, Blocks.fire);
			}
		}
		this.setDead();
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0f;
	}
}