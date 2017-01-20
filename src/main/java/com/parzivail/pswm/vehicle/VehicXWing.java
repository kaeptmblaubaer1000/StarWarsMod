package com.parzivail.pswm.vehicle;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.sound.MovingSoundShip;
import com.parzivail.pswm.sound.PSoundEvents;
import com.parzivail.util.driven.PilotableSFoils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by colby on 1/1/2017.
 */
public class VehicXWing extends PilotableSFoils
{
	public VehicXWing(World world)
	{
		super(world, (float)Math.toRadians(10), 20);
	}

	public VehicXWing(World world, double i, double j, double k)
	{
		super(world, i, j, k, (float)Math.toRadians(10), 20);
	}

	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand)
	{
		if (this.world.isRemote)
		{
			PSWM.mc.getSoundHandler().playSound(new MovingSoundShip(player, this, PSoundEvents.XWING_INTERIOR_LOOP, true, true));
		}
		return super.processInitialInteract(player, hand);
	}
}
