package com.parzi.starwarsmod.vehicles;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class VehicTIEInterceptor extends VehicleAirBase
{
	public VehicTIEInterceptor(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 7.0F);
		this.vehicYOffset = -3F;
		this.moveModifier = 1.75F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsMod.spawnTie, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag()) return this.getCustomNameTag();
		return "TIE/IN Interceptor";
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