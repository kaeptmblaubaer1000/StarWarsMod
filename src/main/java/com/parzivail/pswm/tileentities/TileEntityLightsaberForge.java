package com.parzivail.pswm.tileentities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityLightsaberForge extends TileEntity
{
	AxisAlignedBB bb;

	int facing = 0;

	public TileEntityLightsaberForge()
	{
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 64537, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
	{
		super.onDataPacket(net, packet);
		this.readFromNBT(packet.func_148857_g());
	}

	public int getFacing()
	{
		return facing;
	}

	public void setFacing(int facing)
	{
		this.facing = facing;
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
			this.bb = AxisAlignedBB.getBoundingBox(this.xCoord - 2, this.yCoord, this.zCoord - 2, this.xCoord + 2, this.yCoord + 1, this.zCoord + 2);
		return this.bb;
	}

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_)
	{
		super.readFromNBT(p_145839_1_);
		this.setFacing(p_145839_1_.getInteger("facing"));
	}

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_)
	{
		super.writeToNBT(p_145841_1_);
		p_145841_1_.setInteger("facing", getFacing());
	}
}
