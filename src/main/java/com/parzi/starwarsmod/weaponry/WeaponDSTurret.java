package com.parzi.starwarsmod.weaponry;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.vehicles.VehicleLandBase;

public class WeaponDSTurret extends WeaponSwivelBase
{
	public WeaponDSTurret(World par1World)
	{
		super(par1World);
		this.setSize(3, 3);

		this.vehicYOffset = 0.4F;

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.speeder.move";
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
		{
			return this.getCustomNameTag();
		}
		else
		{
			return "SB-920 Laser Cannon";
		}
	}
}
