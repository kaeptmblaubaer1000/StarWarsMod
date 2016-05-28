package com.parzivail.pswm.vehicles.npc;

import com.parzivail.pswm.ai.AiFreqMove;
import com.parzivail.util.vehicle.VehicleLandBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class VehicNpcLandspeeder extends VehicleLandBase
{
	public VehicNpcLandspeeder(World par1World)
	{
		super(par1World);
		this.setSize(2.0F, 2.0F);
		this.vehicYOffset = -0.3F;
		this.moveModifier = 2.5F;
		this.tiltMax = 3;

		this.tasks.addTask(0, new AiFreqMove(this, 1, 1));
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
		// nothing
	}

	@Override
	public String getCommandSenderName()
	{
		if (this.hasCustomNameTag())
			return this.getCustomNameTag();
		return "Piloted X-34 Landspeeder";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.landspeeder.move";
	}
}
