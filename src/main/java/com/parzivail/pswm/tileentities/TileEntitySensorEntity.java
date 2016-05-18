package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageSpawn;
import net.minecraft.entity.Entity;

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
		if (worldObj.isRemote)
		{
			int l = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
			StarWarsMod.network.sendToServer(new MessageSpawn(this.worldObj, needle, this.xCoord + 0.5f, this.yCoord + 1, this.zCoord + 0.5f, 0, l * 90));
		}
	}
}
