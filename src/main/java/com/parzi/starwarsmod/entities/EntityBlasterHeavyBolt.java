package com.parzi.starwarsmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class EntityBlasterHeavyBolt extends EntityThrowable
{
	public EntityPlayer sender;
	private int timeAlive = 0;

	public EntityBlasterHeavyBolt(World par1World)
	{
		super(par1World);
	}

	public EntityBlasterHeavyBolt(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}

	public EntityBlasterHeavyBolt(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
		sender = (EntityPlayer)par2EntityLivingBase;
	}

	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
	{
		if (isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			setBeenAttacked();

			if (p_70097_1_.getEntity() != null)
			{
				Vec3 vec3 = p_70097_1_.getEntity().getLookVec();

				if (vec3 != null)
				{
					motionX = vec3.xCoord;
					motionY = vec3.yCoord;
					motionZ = vec3.zCoord;
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
	protected float getGravityVelocity()
	{
		return 0f;
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer player)
	{
		if (player.getHeldItem() != null && player.getHeldItem().getItem() == StarWarsMod.lightsaber && player.isBlocking())
		{
			Vec3 vec3 = player.getLookVec();

			if (vec3 != null)
			{
				motionX = vec3.xCoord;
				motionY = vec3.yCoord;
				motionZ = vec3.zCoord;
			}

			player.playSound(StarWarsMod.MODID + ":" + "item.lightsaber.deflect", 1f, 1f + (float)MathHelper.getRandomDoubleInRange(rand, -0.2D, 0.2D));
		}
		return;
	}

	@Override
	protected void onImpact(MovingObjectPosition pos)
	{
		if (pos.typeOfHit == MovingObjectType.ENTITY && (pos.entityHit != sender || timeAlive > 2))
		{
			pos.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(sender), 8f);
			pos.entityHit.setFire(8);
		}
		else
		{
			if (worldObj.getBlock(pos.blockX, pos.blockY + 1, pos.blockZ) == Blocks.air)
			{
				worldObj.setBlock(pos.blockX, pos.blockY + 1, pos.blockZ, Blocks.fire);
			}
		}
		setDead();
	}

	@Override
	public void onUpdate()
	{
		if (timeAlive++ > 100)
		{
			setDead();
		}
		super.onUpdate();
	}

	@Override
	public void setThrowableHeading(double p_70186_1_, double p_70186_3_, double p_70186_5_, float p_70186_7_, float p_70186_8_)
	{
		float f2 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_3_ * p_70186_3_ + p_70186_5_ * p_70186_5_);
		p_70186_1_ /= f2;
		p_70186_3_ /= f2;
		p_70186_5_ /= f2;
		p_70186_1_ += 0.007499999832361937D * p_70186_8_; // haha, no
		// random
		p_70186_3_ += 0.007499999832361937D * p_70186_8_;
		p_70186_5_ += 0.007499999832361937D * p_70186_8_;
		p_70186_1_ *= p_70186_7_;
		p_70186_3_ *= p_70186_7_;
		p_70186_5_ *= p_70186_7_;
		motionX = p_70186_1_;
		motionY = p_70186_3_;
		motionZ = p_70186_5_;
		float f3 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
		prevRotationYaw = rotationYaw = (float)(Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / Math.PI);
		prevRotationPitch = rotationPitch = (float)(Math.atan2(p_70186_3_, f3) * 180.0D / Math.PI);
	}
}