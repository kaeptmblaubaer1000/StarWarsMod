package com.parzivail.pswm.tileentities;

import com.parzivail.util.vehicle.VehicleAirBase;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class TileEntitySensorEntity extends TileEntitySensor
{
	public Class<? extends Entity> needle;
	private int rX;
	private int rY;
	private int rZ;

	public TileEntitySensorEntity(Class<? extends Entity> needle, int rX, int rY, int rZ)
	{
		this.needle = needle;
		this.rX = rX;
		this.rY = rY;
		this.rZ = rZ;
	}

	@Override
	boolean checkCondition()
	{
		return this.worldObj != null && this.worldObj.getEntitiesWithinAABB(needle, this.bb.expand(rX, rY, rZ)).isEmpty();
	}

	@Override
	void runConditional()
	{
		if (!worldObj.isRemote)
		{
			try
			{
				int l = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);

				Object c = this.needle.getConstructor(World.class).newInstance(this.worldObj);
				Entity entity = this.needle.cast(c);
				entity.setPositionAndRotation(this.xCoord, this.yCoord, this.zCoord, l * 90, 0);
				if (entity instanceof VehicleAirBase)
				{
					VehicleAirBase vehicleBase = (VehicleAirBase)entity;
					vehicleBase.rotationYawLast = l * 90;
					vehicleBase.rotationPitchLast = 0;
				}
				this.worldObj.spawnEntityInWorld(entity);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
