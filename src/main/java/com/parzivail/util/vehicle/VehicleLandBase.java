package com.parzivail.util.vehicle;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class VehicleLandBase extends VehicleBase
{
	public VehicleLandBase(World p_i1689_1_)
	{
		super(p_i1689_1_);
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
	{
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase)
		{
			this.rotationLast = this.rotationYaw = this.riddenByEntity.rotationYaw;
			this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
			p_70612_1_ = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
			p_70612_2_ = ((EntityLivingBase)this.riddenByEntity).moveForward * (this.moveModifier / 8.0F);

			float f2a = MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F);
			float f3a = MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F);
			this.motionX += -0.4F * f2a * p_70612_2_;
			this.motionZ += 0.4F * f3a * p_70612_2_;

			this.stepHeight = 1.0F;
			if (!this.worldObj.isRemote)
			{
				double d0;
				float f2 = 0.91F;

				if (this.onGround)
					f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;

				float f3 = 0.16277136F / (f2 * f2 * f2);
				float f4;

				if (this.onGround)
					f4 = this.getAIMoveSpeed() * f3;
				else
					f4 = this.jumpMovementFactor;

				this.moveFlying(p_70612_1_, p_70612_2_, f4);
				f2 = 0.91F;

				if (this.onGround)
					f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;

				this.moveEntity(this.motionX, this.motionY, this.motionZ);

				if (this.isCollidedHorizontally && this.isOnLadder())
					this.motionY = 0.2D;

				if (this.worldObj.isRemote && (!this.worldObj.blockExists((int)this.posX, 0, (int)this.posZ) || !this.worldObj.getChunkFromBlockCoords((int)this.posX, (int)this.posZ).isChunkLoaded))
				{
					if (this.posY > 0.0D)
						this.motionY = -0.1D;
					else
						this.motionY = 0.0D;
				}
				else
					this.motionY -= 1D;

				this.motionY *= 0.9800000190734863D;
				this.motionX *= f2;
				this.motionZ *= f2;

				this.prevLimbSwingAmount = this.limbSwingAmount;
				d0 = this.posX - this.prevPosX;
				double d1 = this.posZ - this.prevPosZ;
				float f6 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;

				if (f6 > 1.0F)
					f6 = 1.0F;

				this.limbSwingAmount += (f6 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
			}
		}
	}
}