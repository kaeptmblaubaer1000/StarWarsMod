package com.parzivail.pswm.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAntenna extends TileEntity
{
	private int facing = 2;
	private boolean fixed = false;
	private boolean on = false;
	private int openFrame;

	public int getFacing()
	{
		return this.facing;
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
	{
		super.onDataPacket(net, packet);
		this.readFromNBT(packet.getNbtCompound());
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
	public NBTTagCompound writeToNBT(NBTTagCompound tag)
	{
		tag.setShort("facing", (short)this.facing);
		tag.setBoolean("on", this.on);
		tag.setBoolean("fixed", this.fixed);
		return super.writeToNBT(tag);
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
