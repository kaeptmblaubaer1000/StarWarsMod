package com.parzivail.pswm.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.jedirobes.ArmorJediRobes;

public class EntityBlasterBoltBase extends EntityThrowable
{
	private EntityLivingBase sender;
	private int timeAlive = 0;
	protected float damage = 5.0f;
	protected float speed = 3;

	public EntityBlasterBoltBase(World par1World, double par2, double par4, double par6, float damage)
	{
		super(par1World, par2, par4, par6);
		this.damage = damage;
	}

	public EntityBlasterBoltBase(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float damage)
	{
		this(par1World, par2EntityLivingBase, damage);
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

	public EntityBlasterBoltBase(World par1World, EntityLivingBase par2EntityLivingBase, float damage)
	{
		super(par1World, par2EntityLivingBase);
		this.sender = par2EntityLivingBase;
		this.damage = damage;
		this.setThrowableHeading(par2EntityLivingBase.getLookVec().xCoord, par2EntityLivingBase.getLookVec().yCoord, par2EntityLivingBase.getLookVec().zCoord, 1.0F, 1.0F);
	}

	public EntityBlasterBoltBase(World par1World, float damage)
	{
		super(par1World);
		this.damage = damage;
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
		if (player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
		{
			ItemStack stack = player.inventory.armorItemInSlot(2);

			if (ArmorJediRobes.getActive(stack).equalsIgnoreCase("deflect") && ArmorJediRobes.getUsingDuration(stack))
			{
				Vec3 vec3 = player.getLookVec();
				if (vec3 != null)
				{
					this.motionX = vec3.xCoord;
					this.motionY = vec3.yCoord;
					this.motionZ = vec3.zCoord;
				}
			}
		}
		else if (player.getHeldItem() != null && (player.getHeldItem().getItem() == StarWarsMod.lightsaber || player.getHeldItem().getItem() == StarWarsMod.sequelLightsaber) && player.isBlocking())
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
		if (pos.typeOfHit == MovingObjectType.ENTITY && (pos.entityHit != this.sender || this.timeAlive > 2))
		{
			pos.entityHit.attackEntityFrom(StarWarsMod.blasterDamageSource, this.damage);
			pos.entityHit.setFire(8);
		}
		else if (!this.worldObj.isRemote && this.worldObj.getBlock(pos.blockX, pos.blockY + 1, pos.blockZ) == Blocks.air && Resources.enableBlasterFire)
			this.worldObj.setBlock(pos.blockX, pos.blockY + 1, pos.blockZ, Blocks.fire);
		this.setDead();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if (this.timeAlive++ > 100)
			this.setDead();
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
		this.motionX = p_70186_1_ * this.speed;
		this.motionY = p_70186_3_ * this.speed;
		this.motionZ = p_70186_5_ * this.speed;
		float f3 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
		this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / 3.141592653589793D);
		this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(p_70186_3_, f3) * 180.0D / 3.141592653589793D);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\entities\EntityBlasterRifleBolt.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */