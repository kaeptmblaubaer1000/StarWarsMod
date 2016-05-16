package com.parzivail.pswm.entities;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityDestruction extends EntityThrowable
{
	public EntityPlayer sender;
	private int timeAlive = 0;
	private int radius = 1;

	public EntityDestruction(World par1World)
	{
		super(par1World);
	}

	public EntityDestruction(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}

	public EntityDestruction(World par1World, EntityLivingBase par2EntityLivingBase, int radius)
	{
		super(par1World, par2EntityLivingBase);
		Vec3 vec3 = par2EntityLivingBase.getLookVec();
		double dx = vec3.xCoord * 3;
		double dy = vec3.yCoord * 3;
		double dz = vec3.zCoord * 3;

		this.posX += dx;
		this.posY += dy;
		this.posZ += dz;

		this.sender = (EntityPlayer)par2EntityLivingBase;

		this.radius = radius;
	}

	public EntityDestruction(World par1World, EntityLivingBase par2EntityLivingBase, Vec3 vector)
	{
		super(par1World, par2EntityLivingBase);
		Vec3 vec3 = vector;
		double dx = vec3.xCoord * 3;
		double dy = vec3.yCoord * 3;
		double dz = vec3.zCoord * 3;

		this.posX += dx;
		this.posY += dy;
		this.posZ += dz;

		this.sender = (EntityPlayer)par2EntityLivingBase;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if (this.isEntityInvulnerable())
			return false;
		this.setBeenAttacked();
		if (source.getEntity() != null)
		{
			Vec3 vec3 = source.getEntity().getLookVec();
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

	@SuppressWarnings("unused")
	@Override
	public void onCollideWithPlayer(EntityPlayer player)
	{
		if (true)
			return;
		if (player.getHeldItem() != null && (player.getHeldItem().getItem() == StarWarsMod.lightsaber) && player.isBlocking())
		{
			Vec3 vec3 = player.getLookVec();
			if (vec3 != null)
			{
				this.motionX = vec3.xCoord;
				this.motionY = vec3.yCoord;
				this.motionZ = vec3.zCoord;
			}
			player.playSound(Resources.MODID + ":" + "item.lightsaber.deflect", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(this.rand, -0.2D, 0.2D));
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition pos)
	{
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.radius, true);
		this.setDead();
	}

	@Override
	public void onUpdate()
	{
		if (this.timeAlive++ > 100)
			this.setDead();
		super.onUpdate();

		for (int i = 0; i < 50; i++)
		{
			double motionX = this.rand.nextGaussian() * 0.02D;
			double motionY = this.rand.nextGaussian() * 0.02D;
			double motionZ = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle("explode", this.posX + this.rand.nextFloat() * this.width * 2.0F - this.width, this.posY + 0.5D + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0F - this.width, motionX, motionY, motionZ);
		}
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
		this.motionX = p_70186_1_ * 2;
		this.motionY = p_70186_3_ * 2;
		this.motionZ = p_70186_5_ * 2;
		float f3 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
		this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / 3.141592653589793D);
		this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(p_70186_3_, f3) * 180.0D / 3.141592653589793D);
	}
}
