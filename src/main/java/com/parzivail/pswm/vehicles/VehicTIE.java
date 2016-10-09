package com.parzivail.pswm.vehicles;

import com.parzivail.util.driven.Seat;
import com.parzivail.util.driven.Starship;
import net.minecraft.world.World;

public class VehicTIE extends Starship
{
	public VehicTIE(World par1World)
	{
		super(par1World);
		this.setSize(3.0F, 7.0F);
	}

	/*@Override
	public boolean interact(EntityPlayer p_70085_1_)
	{
		return QuestUtils.canRideInShip(p_70085_1_, this.getClass()) && super.interact(p_70085_1_);
	}*/

	@Override
	public String getCommandSenderName()
	{
		return "TIE/LN Starfighter";
	}

	/*@Override
	public String getDeathSound()
	{
		return Resources.MODID + ":" + "vehicle.tie.die";
	}

	@Override
	public String getMovingSound()
	{
		return "vehicle.tie.move";
	}*/

	@Override
	public Seat getSeatData(int id)
	{
		switch (id)
		{
			case 0:
				return new Seat(-15, 0, 0);
			default:
				return super.getSeatData(id);
		}
	}
}
