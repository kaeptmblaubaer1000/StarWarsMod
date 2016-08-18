package com.parzivail.pswm.vehicles;

import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.util.vehicle.VehicleLandBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class VehicJakkuSpeeder extends VehicleLandBase
{
	public VehicJakkuSpeeder(World par1World)
	{
		super(par1World);
		this.setSize(1.5F, 3F);
		this.vehicYOffset = -0.25F;
		this.moveModifier = 4.5F;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
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
		return "Swoop Speeder";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.speeder.move";
	}
}
