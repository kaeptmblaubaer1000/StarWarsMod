package com.parzivail.pswm.vehicles.npc;

import com.parzivail.util.math.FPoint;
import com.parzivail.util.math.Spline3D;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.vehicle.VehicleLandBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class VehicNpcLandspeeder extends VehicleLandBase
{
	Spline3D path;

	public VehicNpcLandspeeder(World par1World)
	{
		super(par1World);
		this.setSize(2.0F, 2.0F);
		this.vehicYOffset = -0.3F;
		this.moveModifier = 2.5F;
		this.tiltMax = 3;

		path = new Spline3D(new FPoint[] { new FPoint(-5, 5, 7), new FPoint(-7, 5, 24), new FPoint(-27, 5, 29), new FPoint(-46, 8, -1), new FPoint(-26, 6, -26), new FPoint(-5, 5, 7) });
		FPoint p = path.getPoint(0);
		this.setPositionAndUpdate(p.x, p.y, p.z);
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

	@Override
	public void onUpdate()
	{
		FPoint pt = path.getPoint(0.5f);
		FPoint npt = path.getPoint(0.59f);

		// calculate position and angles
		float d0 = npt.x - pt.x;
		float d1 = npt.y - pt.y;
		float d2 = npt.z - pt.z;
		float d3 = MathHelper.sqrt_float(d0 * d0 + d2 * d2);

		float yaw = (float)Math.toDegrees(Math.atan2(d2, d0)) - 90;
		float pitch = -(float)Math.toDegrees(Math.atan2(d1, d3));
		this.setPositionAndRotation(pt.x, pt.y, pt.z, yaw, pitch);

		Lumberjack.log(yaw);

		this.motionX = this.motionY = this.motionZ = 0;

		super.onNormalUpdate();
	}

	@Override
	protected boolean isMovementCeased()
	{
		return false;
	}
}
