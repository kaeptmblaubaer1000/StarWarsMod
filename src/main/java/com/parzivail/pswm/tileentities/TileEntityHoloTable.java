package com.parzivail.pswm.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityHoloTable extends TileEntity
{
	AxisAlignedBB bb;
	int[] map;
	int sideLength = 128;

	public TileEntityHoloTable()
	{
	}

	public int[] getMap()
	{
		if (map == null)
			setupMap();
		return this.map;
	}

	public int getSideLength()
	{
		return this.sideLength;
	}

	public boolean isMapSetup()
	{
		return map != null;
	}

	public void setupMap()
	{
		map = new int[sideLength * sideLength];

		for (int i = 0; i < map.length; i++)
		{
			int x = i % sideLength;
			int z = (int)Math.floor(i / sideLength);

			map[i] = this.worldObj.getHeightValue(this.xCoord + x - (sideLength / 2), this.zCoord + z - (sideLength / 2));
		}
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 64537, tag);
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
			this.bb = AxisAlignedBB.getBoundingBox(this.xCoord - 3, this.yCoord, this.zCoord - 3, this.xCoord + 3, this.yCoord + 2, this.zCoord + 3);
		return this.bb;
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
	{
		super.onDataPacket(net, packet);
		this.readFromNBT(packet.func_148857_g());
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\tileentities\TileEntityMV.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */