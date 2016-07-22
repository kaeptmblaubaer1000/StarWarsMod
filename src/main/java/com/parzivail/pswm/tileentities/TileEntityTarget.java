package com.parzivail.pswm.tileentities;

import com.parzivail.util.block.TileEntityRotate;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityTarget extends TileEntityRotate
{
	public boolean isHit = false;
	public long hitTime = -1;
	public int hits = 0;

	@Override
	public AxisAlignedBB getRenderBoundingBox()
	{
		return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 2, zCoord + 1);
	}

	@Override
	public void updateEntity()
	{
		super.updateEntity();

		if (this.hitTime != -1 && this.hitTime + 1000 < System.currentTimeMillis() && this.hits == 1)
			this.isHit = false;
	}

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_)
	{
		super.writeToNBT(p_145841_1_);

		p_145841_1_.setBoolean("hit", isHit);
		p_145841_1_.setLong("hitTime", hitTime);
		p_145841_1_.setInteger("hits", hits);
	}

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_)
	{
		super.readFromNBT(p_145839_1_);

		this.isHit = p_145839_1_.getBoolean("hit");
		hitTime = p_145839_1_.getLong("hitTime");
		hits = p_145839_1_.getInteger("hits");
	}
}
