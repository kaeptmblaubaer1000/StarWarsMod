package com.parzivail.pswm.vehicle;

import com.parzivail.pswm.PSWM;
import com.parzivail.pswm.sound.MovingSoundShip;
import com.parzivail.pswm.sound.PSoundEvents;
import com.parzivail.util.driven.PilotableSFoils;
import com.parzivail.util.lwjgl.Vector3f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by colby on 1/1/2017.
 */
public class VehicXWing extends PilotableSFoils
{
	public static final Vector3f RIGHT_TOP_LASER = new Vector3f(-69, 38, 57);
	public static final Vector3f RIGHT_BOTTOM_LASER = new Vector3f(-69, 24, 57);
	public static final Vector3f LEFT_TOP_LASER = new Vector3f(69, 38, 57);
	public static final Vector3f LEFT_BOTTOM_LASER = new Vector3f(69, 24, 57);

	public VehicXWing(World world)
	{
		super(world, (float)Math.toRadians(10), 20);
	}

	public VehicXWing(World world, double i, double j, double k)
	{
		super(world, i, j, k, (float)Math.toRadians(10), 20);
	}

	@Override
	public void playMovingSound(EntityPlayer player)
	{
		PSWM.mc.getSoundHandler().playSound(new MovingSoundShip(player, this, PSoundEvents.XWING_INTERIOR_LOOP, true, true));
	}
}
