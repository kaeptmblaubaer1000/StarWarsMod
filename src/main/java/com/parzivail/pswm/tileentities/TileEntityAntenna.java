package com.parzivail.pswm.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAntenna extends TileEntity
{
	private int facing = 2;
	private boolean fixed = false;
	private boolean on = false;
	private int openFrame;

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
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
	{
		super.onDataPacket(net, packet);
		this.readFromNBT(packet.func_148857_g());
	}

	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		this.facing = tag.getShort("facing");
		this.on = tag.getBoolean("on");
		this.fixed = tag.getBoolean("fixed");
		super.readFromNBT(tag);
	}

	public void setFacing(int dir)
	{
		this.facing = dir;
	}

	public boolean getOn()
	{
		return this.on;
	}

	public void setOn(boolean on)
	{
		this.on = on;
	}

	public boolean getFixed()
	{
		return this.fixed;
	}

	public void setFixed(boolean fixed)
	{
		this.fixed = fixed;
	}

	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setShort("facing", (short)this.facing);
		tag.setBoolean("on", this.on);
		tag.setBoolean("fixed", this.fixed);
		super.writeToNBT(tag);
	}

	public void setOpenFrame(int tick)
	{
		this.openFrame = tick;
	}

	public int getOpenFrame()
	{
		return openFrame;
	}
}
