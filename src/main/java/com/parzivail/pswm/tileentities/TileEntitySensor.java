package com.parzivail.pswm.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntitySensor extends TileEntity
{
	public AxisAlignedBB bb;

	public boolean checkCondition()
	{
		return false;
	}

	@Override
	public void updateEntity()
	{
		if (this.bb == null)
			this.bb = AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1, this.yCoord + 1, this.zCoord + 1);

		if (checkCondition())
			runConditional();
	}

	public void runConditional()
	{
	}
}
