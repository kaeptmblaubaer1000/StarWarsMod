package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.util.vehicle.VehicleAirBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class VehicSnowspeeder extends VehicleAirBase
{
	public VehicSnowspeeder(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 3F);
		this.vehicYOffset = -2F;
		this.moveModifier = 1.75F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50);
		this.setHealth((float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue());
	}

	@Override
	public boolean interact(EntityPlayer p_70085_1_)
	{
		return QuestUtils.canRideInShip(p_70085_1_, this.getClass()) && super.interact(p_70085_1_);
	}

	@Override
	public String getCommandSenderName()
	{
		return "T-47 Snowspeeder";
	}

	@Override
	public String getDeathSound()
	{
		return Resources.MODID + ":" + "vehicle.snowspeeder.die";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.snowspeeder.move";
	}
}
