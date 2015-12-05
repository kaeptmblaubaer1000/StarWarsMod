package com.parzi.starwarsmod.vehicles;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.Lumberjack;

public class VehicleAirBase extends VehicleBase
{
	String[] explosionComponents = { "largesmoke", "flame", "lava", "largeexplode", "snowshovel", "reddust" };

	public float renderPitchLast;

	public VehicleAirBase(World p_i1689_1_)
	{
		super(p_i1689_1_);
		this.renderPitchLast = this.rotationPitch;
	}

	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	public void fall(float p_70069_1_)
	{
		p_70069_1_ = ForgeHooks.onLivingFall(this, p_70069_1_);
		Lumberjack.log(this.motionY);
		if (p_70069_1_ <= 3 || this.motionY > -0.3F) return;
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
			p_70612_2_ = ((EntityLivingBase)this.riddenByEntity).moveForward * (this.moveModifier / 8.0F) * (1 - Math.abs(((EntityPlayer)this.riddenByEntity).rotationPitch / 90F));

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
	public void onDeathUpdate()
	{
		super.onDeathUpdate();
		for (String comp : this.explosionComponents)
			for (int i = 0; i < 20 + this.rand.nextInt(20); i++)
			{
				double motionX = this.rand.nextGaussian() * 0.2D;
				double motionY = this.rand.nextGaussian() * 0.2D;
				double motionZ = this.rand.nextGaussian() * 0.2D;
				this.worldObj.spawnParticle(comp, this.posX + this.rand.nextFloat() * this.width * 2.0F - this.width, this.posY + 0.5D + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0F - this.width, motionX, motionY, motionZ);
			}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if ((int)this.posX != (int)this.prevPosX || (int)this.posY != (int)this.prevPosY || (int)this.posZ != (int)this.prevPosZ) this.playSound(StarWarsMod.MODID + ":" + this.getMovingSound(), 1, 1);
	}
}