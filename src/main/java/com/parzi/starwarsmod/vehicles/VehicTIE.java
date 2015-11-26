package com.parzi.starwarsmod.vehicles;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class VehicTIE extends VehicleAirBase
{
	public VehicTIE(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 7.0F);
		this.vehicYOffset = -3F;
		this.moveModifier = 1.75F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
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
		return "TIE/LN Starfighter";
	}
	
	@Override
	public void onDeath(DamageSource source)
	{

		for (int i = 0; i < 50; i++)
		{
			double motionX = rand.nextGaussian() * 0.02D;
			double motionY = rand.nextGaussian() * 0.02D;
			double motionZ = rand.nextGaussian() * 0.02D;
			worldObj.spawnParticle("hugeexplode", posX + rand.nextFloat() * width * 2.0F - width, posY + 0.5D + rand.nextFloat() * height, posZ + rand.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);
		}
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.tie.move";
	}
	
	@Override
	public String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "vehicle.tie.die";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\vehicles\VehicSpeederBike.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */