package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.vehicle.VehicleLandBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class VehicJakkuSpeeder extends VehicleLandBase
{
	public VehicJakkuSpeeder(World par1World)
	{
		super(par1World);
		this.setSize(1.5F, 3F);
		this.vehicYOffset = -0.25F;
		this.moveModifier = 4.5F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsMod.spawnJakkuSpeeder, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return "Jakku Speeder";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.speeder.move";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\vehicles\VehicSpeederBike.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */