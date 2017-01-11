package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.Pilotable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by colby on 1/1/2017.
 */
public class VehicXWing extends Pilotable
{
	public static final DataParameter<Boolean> S_FOILS_OPEN = EntityDataManager.createKey(VehicXWing.class, DataSerializers.BOOLEAN);

	@SideOnly(Side.CLIENT)
	public float sFoilPercent = 0;
	@SideOnly(Side.CLIENT)
	public float sFoilOpenAngle = 0.21f;

	public VehicXWing(World world)
	{
		super(world);
	}

	public VehicXWing(World world, double i, double j, double k)
	{
		super(world, i, j, k);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(S_FOILS_OPEN, false);
	}
}
