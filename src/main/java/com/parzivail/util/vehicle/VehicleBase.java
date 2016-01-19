package com.parzivail.util.vehicle;

import com.parzivail.pswm.Resources;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class VehicleBase extends EntityCreature
{
	public float[] tiltTable = { 0, 0, 0, 0, 0, 0 };
	public float tilt = 0.0F;
	public float tiltMax = 10;
	public float vehicXOffset = 0.0F;
	public float vehicYOffset = 0.0F;
	public float vehicZOffset = 0.0F;
	public float moveModifier = 1.0F;
	public float frame = 0.0F;
	public float rotationLast = 0.0F;
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
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
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
	protected boolean isMovementCeased()
	{
		return true;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		this.moveEntityWithHeading(0.0F, 0.0F);

		this.frame += 0.1F;

		this.setRotation(this.rotationLast, this.rotationPitchLast);

		for (int i = 1; i < this.tiltTable.length; i++)
			this.tiltTable[i - 1] = this.tiltTable[i];

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

	@Override
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
		{
			float offset = this.vehicYOffset;
			if (!(this.riddenByEntity instanceof EntityPlayer))
				offset -= 0.5F;
			this.riddenByEntity.setPosition(this.posX + this.vehicXOffset, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + offset, this.posZ + this.vehicZOffset);
		}
	}
}