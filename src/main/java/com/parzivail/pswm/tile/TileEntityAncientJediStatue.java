package com.parzivail.pswm.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityAncientJediStatue extends TileEntity
{
	private int facing = 2;
	AxisAlignedBB bb;

	public TileEntityAncientJediStatue()
	{
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		if (this.bb == null)
			this.bb = new AxisAlignedBB(this.pos.getX() - 10, this.pos.getY(), this.pos.getZ() - 10, this.pos.getX() + 10, this.pos.getY() + 50, this.pos.getZ() + 10);
		return this.bb;
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
	{
		super.onDataPacket(net, pkt);
		this.readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		compound.setShort("facing", (short)this.facing);
		return super.writeToNBT(compound);
	}

	public int getFacing()
	{
		return this.facing;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()
	{
		return 262144;
	}

	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		this.facing = tag.getShort("facing");
		super.readFromNBT(tag);
	}

	public void setFacing(int dir)
	{
		this.facing = dir;
	}
}