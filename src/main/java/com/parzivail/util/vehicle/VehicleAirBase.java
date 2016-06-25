package com.parzivail.util.vehicle;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleAirBase extends VehicleBase
{
	public static int TGTLOCK_DW = 14;
	public float renderPitchLast;
	public float renderRollLast;
	public float gravity = 0.015F;
	public float move = 0f;
	public boolean wasMoving = false;
	public boolean nowMoving = false;
	public List<Entity> nearby = new ArrayList<>();
	private String[] explosionComponents = { "largesmoke", "flame", "lava", "largeexplode", "snowshovel", "reddust" };

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
	public void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(TGTLOCK_DW, Integer.valueOf(0));
		this.dataWatcher.setObjectWatched(TGTLOCK_DW);
	}

	@Override
	public void fall(float distance)
	{
		distance = ForgeHooks.onLivingFall(this, distance);
		// Lumberjack.log(this.motionY);
		if (distance <= 3 || this.motionY > -0.3F)
			return;
		super.fall(distance);
		PotionEffect potioneffect = this.getActivePotionEffect(Potion.jump);
		float f1 = potioneffect != null ? (float)(potioneffect.getAmplifier() + 1) : 0.0F;
		int i = MathHelper.ceiling_float_int(distance - 3.0F - f1);

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

	public boolean getTargetLock()
	{
		return this.dataWatcher.getWatchableObjectInt(TGTLOCK_DW) == 1;
	}

	public void setTargetLock(boolean f)
	{
		this.dataWatcher.updateObject(TGTLOCK_DW, f ? 1 : 0);
		this.dataWatcher.setObjectWatched(TGTLOCK_DW);
	}

	@Override
	public void moveEntityWithHeading(float strafe, float forward)
	{
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer)
		{
			EntityPlayer riddenByPlayer = (EntityPlayer)this.riddenByEntity;

			this.motionY = -(riddenByPlayer.rotationPitch / 180F) * this.move;

			if (this.move != 0)
			{
				this.rotationPitchLast = this.rotationPitch = riddenByPlayer.rotationPitch;
			}
			this.rotationYawLast = this.rotationYaw = this.riddenByEntity.rotationYaw;
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
			this.setRotation(this.rotationYaw, this.rotationPitch);

			strafe = riddenByPlayer.moveStrafing * 0.5F;
			forward = riddenByPlayer.moveForward;

			if (forward > 0)
				this.move += 0.05f;

			if (forward < 0)
				this.move -= 0.05f;

			if (this.move < 0)
				this.move = 0;

			if (this.move > this.moveModifier)
				this.move = this.moveModifier;

			forward = this.move / 8.0F * (1 - Math.abs(riddenByPlayer.rotationPitch / 90F));

			this.gravity = 0.8f * ((this.moveModifier - this.move) / this.moveModifier);

			this.motionY -= this.gravity;

			float f2 = MathHelper.sin((float)(this.rotationYaw * Math.PI / 180.0F));
			float f3 = MathHelper.cos((float)(this.rotationYaw * Math.PI / 180.0F));
			this.motionX += -0.4F * f2 * forward;
			this.motionZ += 0.4F * f3 * forward;

			this.stepHeight = 1.0F;
			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
			if (!this.worldObj.isRemote) // this.setAIMoveSpeed(p_70612_2_);
				super.moveEntityWithHeading(strafe, forward);
		}
		else if (!this.worldObj.isRemote)
			super.moveEntityWithHeading(strafe, forward);
	}

	@Override
	public void onDeath(DamageSource source)
	{
		super.onDeath(source);

		if (this.worldObj.isRemote)
			for (String comp : this.explosionComponents)
				for (int i = 0; i < 20 + this.rand.nextInt(20); i++)
				{
					double motionX = this.rand.nextGaussian() * 0.2D;
					double motionY = this.rand.nextGaussian() * 0.2D;
					double motionZ = this.rand.nextGaussian() * 0.2D;
					this.worldObj.spawnParticle(comp, this.posX + this.rand.nextFloat() * this.width * 2.0F - this.width, this.posY + 0.5D + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0F - this.width, motionX, motionY, motionZ);
				}

		if (source.getDamageType().equals("fall") || source.isProjectile())
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 5, true);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		this.nowMoving = this.posX != this.prevPosX || this.posY != this.prevPosY || this.posZ != this.prevPosZ;

		this.wasMoving = this.nowMoving;

		if (this.ticksExisted % 5 == 0) // update radar
			if (this.worldObj != null && this.boundingBox != null && this.worldObj.getEntitiesWithinAABB(VehicleAirBase.class, this.boundingBox.expand(100, 50, 100)).size() > 0)
			{
				this.nearby.clear();
				this.nearby.addAll(((List<VehicleAirBase>)this.worldObj.getEntitiesWithinAABB(VehicleAirBase.class, this.boundingBox.expand(100, 50, 100))).stream().filter(entity -> entity != this).collect(Collectors.toList()));
				this.nearby.addAll(((List<EntityPlayer>)this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(100, 50, 100))).stream().filter(entity -> !(entity.ridingEntity instanceof VehicleAirBase)).collect(Collectors.toList()));
			}
	}
}