package com.parzi.starwarsmod.weaponry;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class WeaponDSTurret extends WeaponSwivelBase
{
	public WeaponDSTurret(World par1World)
	{
		super(par1World);
		setSize(3, 3);

		vehicYOffset = 0.4F;

		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		dropItem(StarWarsMod.spawnSpeederBike, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (hasCustomNameTag())
		{
			return getCustomNameTag();
		}
		else
		{
			return "SB-920 Laser Cannon";
		}
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.speeder.move";
	}
}
