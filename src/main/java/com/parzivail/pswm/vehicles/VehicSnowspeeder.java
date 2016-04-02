package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.vehicle.VehicleAirBase;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class VehicSnowspeeder extends VehicleAirBase
{
	public VehicSnowspeeder(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 3F);
		this.vehicYOffset = -2F;
		this.moveModifier = 1.75F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsMod.spawnSnowspeeder, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return "T-47 Snowspeeder";
	}

	@Override
	public String getDeathSound()
	{
		return Resources.MODID + ":" + "vehicle.snowspeeder.die";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.snowspeeder.move";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\vehicles\VehicSpeederBike.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */