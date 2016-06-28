package com.parzivail.util.vehicle;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class VehicleBase extends EntityLiving
{
	private float[] tiltTable = { 0, 0, 0, 0, 0, 0 };
	public float tilt = 0.0F;
	public float tiltMax = 10;
	public float vehicYOffset = 0.0F;
	public float moveModifier = 1.0F;
	public float frame = 0.0F;
	public float rotationYawLast = 0.0F;
	public float rotationPitchLast = 0.0F;

	public VehicleBase(World p_i1689_1_)
	{
		super(p_i1689_1_);
		this.setSize(1F, 1F);
		this.isImmuneToFire = true;
	}

	@Override
	protected boolean canDespawn()
	{
		return false;
	}

	@Override
	public boolean canRenderOnFire()
	{
		return false;
	}

	@Override
	public void fall(float p1)
	{
	}

	@Override
	protected void collideWithEntity(Entity entity)
	{
		if (this.motionX > 0.01f || this.motionY > 0.01f || this.motionZ > 0.01f)
			entity.attackEntityFrom(StarWarsMod.roadkillDamageSource, MathHelper.sqrt_float(Math.max(4, 4 * (float)(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ))));
	}

	@Override
	protected void func_145780_a(int x, int y, int z, Block blockIn)
	{
		this.playSound(Resources.MODID + ":" + this.getMovingSound(), 0.15F, 1.0F);
	}

	public String getMovingSound()
	{
		return "vehicle.default.move";
	}

	@Override
	public boolean interact(EntityPlayer p_70085_1_)
	{
		if (!this.worldObj.isRemote && this.riddenByEntity == null)
		{
			p_70085_1_.mountEntity(this);
			return true;
		}
		return false;
	}

	@Override
	protected boolean isAIEnabled()
	{
		return false;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		this.moveEntityWithHeading(0.0F, 0.0F);

		this.frame += 0.1F;

		this.setRotation(this.rotationYawLast, this.rotationPitchLast);

		if (worldObj.isAirBlock((int)posX, (int)posY - 1, (int)posZ))
		{
			System.arraycopy(this.tiltTable, 1, this.tiltTable, 0, this.tiltTable.length - 1);

			float t = this.rotationYaw - this.prevRotationYaw;

			if (t > this.tiltMax)
				t = this.tiltMax;
			if (t < -this.tiltMax)
				t = -this.tiltMax;

			this.tiltTable[this.tiltTable.length - 1] = t;

			for (float i : this.tiltTable)
				this.tilt += i;

			this.tilt /= this.tiltTable.length;
		}
	}

	@Override
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
		{
			float offset = this.vehicYOffset;
			if (!(this.riddenByEntity instanceof EntityPlayer))
				offset -= 0.5F;
			this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + offset, this.posZ);
		}
	}
}