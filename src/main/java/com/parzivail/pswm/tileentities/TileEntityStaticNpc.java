package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.mobs.trooper.MobDefaultBiped;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityStaticNpc extends TileEntity
{
	AxisAlignedBB bb;
	MobDefaultBiped internalBiped;

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
			this.bb = AxisAlignedBB.getBoundingBox(this.xCoord + 0.1f, this.yCoord, this.zCoord + 0.1f, this.xCoord + 0.9f, this.yCoord + 1.8f, this.zCoord + 0.9f);
		return this.bb;
	}

	@Override
	public void updateEntity()
	{
		// List<Entity> entities =
		// this.worldObj.getEntitiesWithinAABB(EntityPlayer.class,
		// this.getRenderBoundingBox());
		// for (Entity e : entities)
		super.updateEntity();
	}

	public MobDefaultBiped getInternalEntity()
	{
		if (internalBiped == null)
			internalBiped = new MobDefaultBiped(this.worldObj);
		return internalBiped;
	}
}