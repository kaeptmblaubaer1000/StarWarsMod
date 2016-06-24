package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.util.vehicle.VehicleLandBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class VehicScootemaround extends VehicleLandBase
{
	public VehicScootemaround(World par1World)
	{
		super(par1World);
		this.setSize(2.0F, 2.0F);
		this.vehicYOffset = -0.3F;
		this.moveModifier = 1.25F;
		this.tiltMax = 0;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.255D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsItems.spawnScootemaround, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return "Rebel Scoot-'Em-Around";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.scootemaround.move";
	}

	@Override
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
		{
			float offset = this.vehicYOffset;
			if (!(this.riddenByEntity instanceof EntityPlayer))
				offset -= 0.5F;

			float mu = 1.3f;
			float ox = MathHelper.cos((float)Math.toRadians(this.rotationYaw + 90)) * mu;
			float oz = MathHelper.sin((float)Math.toRadians(this.rotationYaw + 90)) * mu;
			this.riddenByEntity.setPosition(this.posX + ox, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + offset, this.posZ + oz);
		}
	}
}
