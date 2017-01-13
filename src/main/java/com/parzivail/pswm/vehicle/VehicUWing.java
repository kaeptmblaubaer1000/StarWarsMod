package com.parzivail.pswm.vehicle;

import com.parzivail.util.driven.Pilotable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by colby on 1/1/2017.
 */
public class VehicUWing extends Pilotable
{
	public static final DataParameter<Boolean> S_FOILS_OPEN = EntityDataManager.createKey(VehicUWing.class, DataSerializers.BOOLEAN);

	@SideOnly(Side.CLIENT)
	public float sFoilOpenAngle = (float)Math.toRadians(120);

	public VehicUWing(World world)
	{
		super(world);
	}

	public VehicUWing(World world, double i, double j, double k)
	{
		super(world, i, j, k);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(S_FOILS_OPEN, false);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (world.isRemote)
			handleSFoils();
	}

	private void handleSFoils()
	{
		if (this.getDataManager().get(VehicUWing.S_FOILS_OPEN) && this.sFoilOpenAngle < sFoilOpenAngle)
			this.sFoilOpenAngle += sFoilOpenAngle / 20f;
		if (!this.getDataManager().get(VehicUWing.S_FOILS_OPEN) && this.sFoilOpenAngle > 0)
			this.sFoilOpenAngle -= sFoilOpenAngle / 20f;

		this.sFoilOpenAngle = MathHelper.clamp(this.sFoilOpenAngle, 0, sFoilOpenAngle);
	}
}
