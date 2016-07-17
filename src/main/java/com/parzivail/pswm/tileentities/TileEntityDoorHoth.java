package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.Resources;
import com.parzivail.util.block.TileEntityRotate;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityDoorHoth extends TileEntityRotate
{
	public int progressTicks;
	public int totalTicks;
	public boolean isOpening = false;
	public boolean isClosing = false;
	public boolean isMoving = false;
	AxisAlignedBB bb;

	public TileEntityDoorHoth()
	{
		this.progressTicks = 1;
		this.totalTicks = 25;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()
	{
		return 262144;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		if (this.bb == null)
			this.bb = AxisAlignedBB.getBoundingBox(this.xCoord - 3, this.yCoord, this.zCoord - 3, this.xCoord + 3, this.yCoord + 5, this.zCoord + 3);
		return this.bb;
	}

	@Override
	public void updateEntity()
	{
		this.totalTicks = 15;
		if (this.progressTicks < this.totalTicks && this.isOpening)
			this.progressTicks++;
		else
			this.isOpening = false;

		if (this.progressTicks > 0 && this.isClosing)
			this.progressTicks--;
		else
			this.isClosing = false;

		boolean wasMoving = isMoving;
		this.isMoving = this.isOpening || this.isClosing;

		if (isMoving && !wasMoving)
			this.getWorldObj().playSound(this.xCoord, this.yCoord, this.zCoord, Resources.MODID + ":" + "blastdoor.pressure", 1, 1, true);
	}
}
