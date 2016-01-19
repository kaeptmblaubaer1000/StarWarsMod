package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.vehicle.VehicleAirBase;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class VehicTIE extends VehicleAirBase
{
	public VehicTIE(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 7.0F);
		this.vehicYOffset = -3F;
		this.moveModifier = 1.75F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsMod.spawnTie, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return "TIE/LN Starfighter";
	}

	@Override
	public String getDeathSound()
	{
		return Resources.MODID + ":" + "vehicle.tie.die";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.tie.move";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\vehicles\VehicSpeederBike.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */