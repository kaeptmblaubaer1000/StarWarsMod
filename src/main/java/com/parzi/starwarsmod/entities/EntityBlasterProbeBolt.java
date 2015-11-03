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

public class EntityBlasterProbeBolt extends EntityThrowable
{
	private EntityLivingBase sender;
	private int timeAlive = 0;

	public EntityBlasterProbeBolt(World par1World)
	{
		super(par1World);
	}

	public EntityBlasterProbeBolt(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}

	public EntityBlasterProbeBolt(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
		this.sender = par2EntityLivingBase;
	}

	public EntityBlasterProbeBolt(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		this(par1World, par2EntityLivingBase);
		this.renderDistanceWeight = 10.0D;
		this.posY = par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight() - 0.10000000149011612D;
		double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
		double d1 = par3EntityLivingBase.boundingBox.minY + par3EntityLivingBase.height / 3.0F - this.posY;
		double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
		double d3 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);
		if (d3 >= 1.0E-7D)
		{
			float f2 = (float)(Math.atan2(d2, d0) * 180.0D / 3.141592653589793D) - 90.0F;
			float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / 3.141592653589793D);
			double d4 = d0 / d3;
			double d5 = d2 / d3;
			this.setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY, par2EntityLivingBase.posZ + d5, f2, f3);
			this.yOffset = 0.0F;
			this.setThrowableHeading(d0, d1, d2, 1.0F, 1.0F);
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
	{
		if (this.isEntityInvulnerable()) return false;
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
		if (player.getHeldItem() != null && player.getHeldItem().getItem() == StarWarsMod.lightsaber && player.isBlocking())
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
		if (pos.typeOfHit == net.minecraft.util.MovingObjectPosition.MovingObjectType.ENTITY && (pos.entityHit != this.sender || this.timeAlive > 2))
		{
			if (this.sender instanceof EntityPlayer)
				pos.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.sender), 5.0F);
			else
				pos.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.sender), 5.0F);
			pos.entityHit.setFire(8);
		}
		else if (this.worldObj.getBlock(pos.blockX, pos.blockY + 1, pos.blockZ) == Blocks.air && StarWarsMod.enableBlasterFire) this.worldObj.setBlock(pos.blockX, pos.blockY + 1, pos.blockZ, Blocks.fire);
		this.setDead();
	}

	@Override
	public void onUpdate()
	{
		if (this.timeAlive++ > 100) this.setDead();
		super.onUpdate();
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\entities\EntityBlasterProbeBolt.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */