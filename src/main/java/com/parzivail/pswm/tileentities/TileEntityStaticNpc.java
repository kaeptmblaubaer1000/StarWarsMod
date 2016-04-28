package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.mobs.trooper.MobDefaultBiped;
import com.parzivail.util.ui.Lumberjack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;

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
		getInternalEntity().ticksExisted++;
		EntityPlayer e = getClosestPlayer();
		if (e != null)
			getInternalEntity().getLookHelper().setLookPosition(e.posX, e.posY, e.posZ, 0, 0);
		super.updateEntity();
	}

	public EntityPlayer getClosestPlayer()
	{
		return this.worldObj.getClosestPlayer(this.xCoord, this.yCoord, this.zCoord, 10);
	}

	public float getAngleToClosestPlayer()
	{
		EntityPlayer e = getClosestPlayer();
		if (e == null)
			return 0;
		return (float)Math.toDegrees(Math.atan2(e.posX - (float)this.xCoord, e.posZ - (float)this.zCoord));
	}

	public MobDefaultBiped getInternalEntity()
	{
		if (internalBiped == null)
			internalBiped = new MobDefaultBiped(this.worldObj);
		return internalBiped;
	}
}