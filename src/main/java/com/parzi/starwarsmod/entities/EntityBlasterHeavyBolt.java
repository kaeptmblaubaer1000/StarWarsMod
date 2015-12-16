package com.parzi.starwarsmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
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
		this.sender = (EntityPlayer)par2EntityLivingBase;
	}

	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
	{
		if (this.isEntityInvulnerable())
			return false;
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
		return false;
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0.0F;
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer player)
	{
		if (player.getHeldItem() != null && (player.getHeldItem().getItem() == StarWarsMod.lightsaber || player.getHeldItem().getItem() == StarWarsMod.sequelLightsaber) && player.isBlocking())
		{
			Vec3 vec3 = player.getLookVec();
			if (vec3 != null)
			{
				this.motionX = vec3.xCoord;
				this.motionY = vec3.yCoord;
				this.motionZ = vec3.zCoord;
			}
			player.playSound(StarWarsMod.MODID + ":" + "item.lightsaber.deflect", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(this.rand, -0.2D, 0.2D));
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition pos)
	{
		if (pos.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY && (pos.entityHit != this.sender || this.timeAlive > 2))
		{
			pos.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(this.sender), 8.0F);
			pos.entityHit.setFire(8);
		}
		else if (this.worldObj.getBlock(pos.blockX, pos.blockY + 1, pos.blockZ) == Blocks.air && StarWarsMod.enableBlasterFire)
			this.worldObj.setBlock(pos.blockX, pos.blockY + 1, pos.blockZ, Blocks.fire);
		this.setDead();
	}

	@Override
	public void onUpdate()
	{
		if (this.timeAlive++ > 100)
			this.setDead();
		super.onUpdate();
	}

	@Override
	public void setThrowableHeading(double p_70186_1_, double p_70186_3_, double p_70186_5_, float p_70186_7_, float p_70186_8_)
	{
		float f2 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_3_ * p_70186_3_ + p_70186_5_ * p_70186_5_);
		p_70186_1_ /= f2;
		p_70186_3_ /= f2;
		p_70186_5_ /= f2;
		p_70186_1_ += 0.007499999832361937D * p_70186_8_;
		p_70186_3_ += 0.007499999832361937D * p_70186_8_;
		p_70186_5_ += 0.007499999832361937D * p_70186_8_;
		p_70186_1_ *= p_70186_7_;
		p_70186_3_ *= p_70186_7_;
		p_70186_5_ *= p_70186_7_;
		this.motionX = p_70186_1_;
		this.motionY = p_70186_3_;
		this.motionZ = p_70186_5_;
		float f3 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
		this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / 3.141592653589793D);
		this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(p_70186_3_, f3) * 180.0D / 3.141592653589793D);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\entities\EntityBlasterHeavyBolt.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */