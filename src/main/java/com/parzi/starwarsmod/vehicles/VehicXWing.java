package com.parzi.starwarsmod.vehicles;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;

public class VehicXWing extends VehicleAirBase
{
	public static int SFOIL_DW = 13;
	public List<Entity> nearby = new ArrayList<Entity>();
	public boolean isOpening = false;
	public boolean isClosing = false;

	public VehicXWing(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 6.0F);
		this.vehicYOffset = -3F;
		this.moveModifier = 1.3F;
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
			this.setSFoil(this.getSFoil() + 1 / 40f);
			this.isOpening = this.getSFoil() < 0.8f;
		}

		if (this.isClosing)
		{
			this.setSFoil(this.getSFoil() - 1 / 40f);
			this.isClosing = this.getSFoil() > 0;
		}

		if (this.ticksExisted % 5 == 0) // update radar
			if (this.worldObj != null && this.boundingBox != null && this.worldObj.getEntitiesWithinAABB(VehicXWing.class, this.boundingBox.expand(100, 50, 100)).size() > 0)
			{
				this.nearby.clear();
				for (VehicleAirBase entity : (List<VehicleAirBase>)this.worldObj.getEntitiesWithinAABB(VehicleAirBase.class, this.boundingBox.expand(100, 50, 100)))
					if (entity != this)
						this.nearby.add(entity);
				for (EntityPlayer entity : (List<EntityPlayer>)this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(100, 50, 100)))
					if (!(entity.ridingEntity instanceof VehicleAirBase))
						this.nearby.add(entity);
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