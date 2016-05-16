package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.vehicle.VehicleLandBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class VehicSpeederBike extends VehicleLandBase
{
	public VehicSpeederBike(World par1World)
	{
		super(par1World);
		this.setSize(1.0F, 2.0F);
		this.vehicYOffset = -0.4F;
		this.moveModifier = 3.0F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsMod.spawnSpeederBike, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return "74-Z Speeder Bike";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.speeder.move";
	}
}
