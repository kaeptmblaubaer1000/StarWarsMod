package com.parzi.starwarsmod.vehicles;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class VehicLandspeeder extends VehicleLandBase
{
	public VehicLandspeeder(World par1World)
	{
		this(par1World, false);
	}

	public VehicLandspeeder(World par1World, boolean isSentient)
	{
		super(par1World, isSentient, Blocks.grass);
		this.setSize(2.0F, 2.0F);
		this.vehicYOffset = -0.3F;
		this.moveModifier = 2.5F;
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
		this.dropItem(StarWarsMod.spawnLandspeeder, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag()) return this.getCustomNameTag();
		return "X-34 Landspeeder";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.landspeeder.move";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\vehicles\VehicLandspeeder.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */