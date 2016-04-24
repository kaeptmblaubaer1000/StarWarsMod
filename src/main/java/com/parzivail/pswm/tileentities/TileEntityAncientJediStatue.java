package com.parzivail.pswm.tileentities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityAncientJediStatue extends TileEntity
{
	private int facing = 2;
	AxisAlignedBB bb;

	public TileEntityAncientJediStatue()
	{
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 64537, tag);
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
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		if (this.bb == null)
			this.bb = AxisAlignedBB.getBoundingBox(this.xCoord - 10, this.yCoord, this.zCoord - 10, this.xCoord + 10, this.yCoord + 50, this.zCoord + 10);
		return this.bb;
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
	{
		super.onDataPacket(net, packet);
		this.readFromNBT(packet.func_148857_g());
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

	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setShort("facing", (short)this.facing);
		super.writeToNBT(tag);
	}
}