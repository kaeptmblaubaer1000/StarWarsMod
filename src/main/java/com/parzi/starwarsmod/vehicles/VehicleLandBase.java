package com.parzi.starwarsmod.vehicles;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.ai.AiFreqMove;

public class VehicleLandBase extends EntityCreature
{
	public static int[] mouseDxOverAFewTicks = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static float mouseDX = 0.0F;
	public static float mouseDY = 0.0F;
	public float vehicXOffset = 0.0F;
	public float vehicYOffset = 0.0F;
	public float vehicZOffset = 0.0F;
	public float moveModifier = 1.0F;
	public float frame = 0.0F;

	private float lastPersonRotX = 0;
	private float lastPersonRotY = 0;

	public VehicleLandBase(World p_i1689_1_)
	{
		super(p_i1689_1_);
		this.setSize(0.9F, 0.9F);
		this.stepHeight = 1.0F;
		this.isImmuneToFire = true;
		this.tasks.taskEntries.clear();
		this.targetTasks.taskEntries.clear();
	}

	@Override
    protected boolean isMovementCeased()
    {
        return true;
    }

	@Override
    public boolean canBeSteered()
    {
        return true;
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
		this.playSound(StarWarsMod.MODID + ":" + this.getMovingSound(), 0.15F, 1.0F);
	}

	public String getMovingSound()
	{
		return "vehicle.default.move";
	}

	@Override
	public boolean interact(EntityPlayer p_70085_1_)
	{
		if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == p_70085_1_))
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

	public void move()
	{
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase)
		{
			EntityLivingBase rider = ((EntityLivingBase)this.riddenByEntity);

			this.lastPersonRotX = this.rotationYaw = rider.rotationYaw;

			if (this.onGround)
			{
				float f2 = MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F);
				float f3 = MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F);
				this.motionX += -0.4F * f2 * rider.moveForward;
				this.motionZ += 0.4F * f3 * rider.moveForward;
			}
		}
		else
		{
			this.setRotation(this.lastPersonRotX, 0);
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		this.frame = (float)(this.frame + 0.1D);

		this.move();

	}

	@Override
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
		{
			float offset = this.vehicYOffset;
			if (!(this.riddenByEntity instanceof EntityPlayer)) offset -= 0.5F;
			this.riddenByEntity.setPosition(this.posX + this.vehicXOffset, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + offset, this.posZ + this.vehicZOffset);
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\vehicles\VehicleLandBase.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */