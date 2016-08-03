package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.util.vehicle.VehicleLandBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class VehicJakkuSpeeder extends VehicleLandBase
{
	public VehicJakkuSpeeder(World par1World)
	{
		super(par1World);
		this.setSize(1.5F, 3F);
		this.vehicYOffset = -0.25F;
		this.moveModifier = 4.5F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	@Override
	public void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(StarWarsItems.spawnJakkuSpeeder, 1);
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return "Swoop Speeder";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.speeder.move";
	}
}
