package com.parzi.starwarsmod.vehicles;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.network.PacketXwingSfoil;

public class VehicXWing extends VehicleAirBase
{
	public static int SFOIL_DW = 13;
	public boolean isOpening = false;
	public boolean isClosing = false;

	public VehicXWing(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 6.0F);
		this.vehicYOffset = -3F;
		this.moveModifier = 1.75F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsMod.spawnXwing, 1);
	}

	@Override
	public void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(SFOIL_DW, Float.valueOf(0));
		this.dataWatcher.setObjectWatched(SFOIL_DW);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return "T-65B X-Wing Starfighter";
	}

	@Override
	public String getDeathSound()
	{
		return StarWarsMod.MODID + ":" + "vehicle.xwing.die";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.xwing.move";
	}

	public float getSFoil()
	{
		return this.dataWatcher.getWatchableObjectFloat(SFOIL_DW);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (this.isOpening)
		{
			this.setSFoil(this.getSFoil() + 1 / 30f);
			this.isOpening = this.getSFoil() < 0.8f;
			if (this.riddenByEntity != null)
				StarWarsMod.network.sendToServer(new PacketXwingSfoil(this.riddenByEntity.getCommandSenderName(), this.getSFoil(), this.worldObj.provider.dimensionId));
		}

		if (this.isClosing)
		{
			this.setSFoil(this.getSFoil() - 1 / 30f);
			this.isClosing = this.getSFoil() > 0;
			if (this.riddenByEntity != null)
				StarWarsMod.network.sendToServer(new PacketXwingSfoil(this.riddenByEntity.getCommandSenderName(), this.getSFoil(), this.worldObj.provider.dimensionId));
		}
	}

	public void setSFoil(float f)
	{
		this.dataWatcher.updateObject(SFOIL_DW, f);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\vehicles\VehicSpeederBike.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */