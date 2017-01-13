package com.parzivail.util.driven;

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
public class PilotableSFoils extends Pilotable
{
	public static final DataParameter<Boolean> S_FOILS_OPEN = EntityDataManager.createKey(PilotableSFoils.class, DataSerializers.BOOLEAN);

	@SideOnly(Side.CLIENT)
	public float sFoilOpenMaxAngle = (float)Math.toRadians(120);
	@SideOnly(Side.CLIENT)
	public float sFoilOpenAngle = 0;
	@SideOnly(Side.CLIENT)
	public float sFoilOpenTicks = 20f;
	@SideOnly(Side.CLIENT)
	public float sFoilDirection = 0;

	public PilotableSFoils(World world, float sFoilOpenMaxAngle, float sFoilOpenTicks)
	{
		super(world);
		this.sFoilOpenMaxAngle = sFoilOpenMaxAngle;
		this.sFoilOpenTicks = sFoilOpenTicks;
	}

	public PilotableSFoils(World world, double i, double j, double k, float sFoilOpenMaxAngle, float sFoilOpenTicks)
	{
		super(world, i, j, k);
		this.sFoilOpenMaxAngle = sFoilOpenMaxAngle;
		this.sFoilOpenTicks = sFoilOpenTicks;
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
		if (this.getDataManager().get(PilotableSFoils.S_FOILS_OPEN) && this.sFoilOpenAngle < sFoilOpenMaxAngle)
		{
			this.sFoilOpenAngle += sFoilOpenMaxAngle / sFoilOpenTicks;
			this.sFoilDirection = 1;
		}
		else if (!this.getDataManager().get(PilotableSFoils.S_FOILS_OPEN) && this.sFoilOpenAngle > 0)
		{
			this.sFoilOpenAngle -= sFoilOpenMaxAngle / sFoilOpenTicks;
			this.sFoilDirection = -1;
		}
		else
			this.sFoilDirection = 0;

		this.sFoilOpenAngle = MathHelper.clamp(this.sFoilOpenAngle, 0, sFoilOpenMaxAngle);
	}
}
