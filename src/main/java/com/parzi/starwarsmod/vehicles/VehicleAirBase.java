package com.parzi.starwarsmod.vehicles;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import com.parzi.starwarsmod.StarWarsMod;

public class VehicleAirBase extends VehicleBase
{
	String[] explosionComponents = { "largesmoke", "flame", "lava", "largeexplode", "snowshovel", "reddust" };

	public float renderPitchLast;
	public float renderRollLast;

	public float gravity = 0.015F;

	public float accel = 0.1f;

	public List<Entity> nearby = new ArrayList<Entity>();

	public VehicleAirBase(World p_i1689_1_)
	{
		super(p_i1689_1_);
		this.renderPitchLast = this.rotationPitch;
		this.renderRollLast = 0;
	}

	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	protected void collideWithNearbyEntities()
	{
		// do nothing
	}

	@Override
	public void fall(float p_70069_1_)
	{
		p_70069_1_ = ForgeHooks.onLivingFall(this, p_70069_1_);
		// Lumberjack.log(this.motionY);
		if (p_70069_1_ <= 3 || this.motionY > -0.3F)
			return;
		super.fall(p_70069_1_);
		PotionEffect potioneffect = this.getActivePotionEffect(Potion.jump);
		float f1 = potioneffect != null ? (float)(potioneffect.getAmplifier() + 1) : 0.0F;
		int i = MathHelper.ceiling_float_int(p_70069_1_ - 3.0F - f1);

		if (i > 0)
		{
			this.playSound(this.func_146067_o(i), 1.0F, 1.0F);
			this.attackEntityFrom(DamageSource.fall, i);
			int j = MathHelper.floor_double(this.posX);
			int k = MathHelper.floor_double(this.posY - 0.20000000298023224D - this.yOffset);
			int l = MathHelper.floor_double(this.posZ);
			Block block = this.worldObj.getBlock(j, k, l);

			if (block.getMaterial() != Material.air)
			{
				Block.SoundType soundtype = block.stepSound;
				this.playSound(soundtype.getStepResourcePath(), soundtype.getVolume() * 0.5F, soundtype.getPitch() * 0.75F);
			}
		}
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
	{
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer)
		{
			this.motionY = -(((EntityPlayer)this.riddenByEntity).rotationPitch / 180F) * ((EntityLivingBase)this.riddenByEntity).moveForward * this.moveModifier;

			this.rotationLast = this.rotationYaw += this.riddenByEntity.rotationYaw - this.rotationLast;
			this.rotationPitchLast = this.rotationPitch += ((EntityPlayer)this.riddenByEntity).rotationPitch - this.rotationPitchLast;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
			p_70612_1_ = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
			p_70612_2_ = ((EntityLivingBase)this.riddenByEntity).moveForward;

			if (this.accel < 1 && p_70612_2_ != 0)
				this.accel += 1 / 100f;

			if (this.accel > 0.1f && p_70612_2_ == 0)
				this.accel -= 1 / 100f;

			if (this.accel < 0.1f)
				this.accel = 0.1f;

			p_70612_2_ = this.moveModifier / 8.0F * (1 - Math.abs(((EntityPlayer)this.riddenByEntity).rotationPitch / 90F)) * (this.accel - 0.1f);

			if (this.accel < 0.5f)
				this.gravity += 0.015F * (1 - this.accel);
			else
				this.gravity = 0.015F;

			this.motionY -= this.gravity;

			float f2 = MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F);
			float f3 = MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F);
			this.motionX += -0.4F * f2 * p_70612_2_;
			this.motionZ += 0.4F * f3 * p_70612_2_;

			this.stepHeight = 1.0F;
			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
			if (!this.worldObj.isRemote) // this.setAIMoveSpeed(p_70612_2_);
				super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
		}
		else
			super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
	}

	@Override
	public void onDeath(DamageSource source)
	{
		super.onDeath(source);
		if (source.getDamageType() != "fall" && source.getDamageType() != "bolt")
			return;
		for (String comp : this.explosionComponents)
			for (int i = 0; i < 20 + this.rand.nextInt(20); i++)
			{
				double motionX = this.rand.nextGaussian() * 0.2D;
				double motionY = this.rand.nextGaussian() * 0.2D;
				double motionZ = this.rand.nextGaussian() * 0.2D;
				this.worldObj.spawnParticle(comp, this.posX + this.rand.nextFloat() * this.width * 2.0F - this.width, this.posY + 0.5D + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0F - this.width, motionX, motionY, motionZ);
			}
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 5, true);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if (this.riddenByEntity == null)
			this.renderPitchLast = (float)(this.newRotationPitch = this.rotationPitchLast = this.rotationPitch = 0);
		if ((int)this.posX != (int)this.prevPosX || (int)this.posY != (int)this.prevPosY || (int)this.posZ != (int)this.prevPosZ)
			this.playSound(StarWarsMod.MODID + ":" + this.getMovingSound(), 1, 1);


		if (this.ticksExisted % 5 == 0) // update radar
			if (this.worldObj != null && this.boundingBox != null && this.worldObj.getEntitiesWithinAABB(VehicXWing.class, this.boundingBox.expand(100, 50, 100)).size() > 0)
			{
				this.nearby.clear();
				for (VehicleAirBase entity : (List<VehicleAirBase>)this.worldObj.getEntitiesWithinAABB(VehicleAirBase.class, this.boundingBox.expand(100, 50, 100)))
					if (entity != this)
						this.nearby.add(entity);
				for (EntityPlayer entity : (List<EntityPlayer>)this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(100, 50, 100)))
					if (!(entity.ridingEntity instanceof VehicleAirBase))
						this.nearby.add(entity);
			}
	}
}