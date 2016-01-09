package com.parzi.starwarsmod.weaponry;

import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class WeaponDSTurret extends WeaponSwivelBase
{
	public float pitch = 0;
	public float pitchLast = 0;
	public float yaw = 0;
	public float yawLast = 0;

	public WeaponDSTurret(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 3.0F);
		this.vehicYOffset = 0.4F;
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
		return "SB-920 Laser Cannon";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.speeder.move";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\weaponry\WeaponDSTurret.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */