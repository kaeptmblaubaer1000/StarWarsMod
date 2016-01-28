package com.parzivail.pswm.tileentities;

import java.awt.Color;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityHoloTableBase extends TileEntity
{
	AxisAlignedBB bb;
	int[] map;
	int sideLength = 64;
	int offset = 0;
	Color rgb;
	int ticksUntilRefresh = 80;

	public TileEntityHoloTableBase()
	{
		this.rgb = new Color(200, 200, 255);
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

	public Color getRGB()
	{
		return this.rgb;
	}

	public void setRGB(float r, float g, float b)
	{
		this.rgb = new Color(r, g, b);
	}

	public void setRGB(int color)
	{
		this.rgb = new Color(color);
	}

	public int getOffset()
	{
		return this.offset;
	}

	public void setOffset(int offset)
	{
		this.offset = offset;
	}

	@Override
	public void updateEntity()
	{
		this.ticksUntilRefresh--;
		if (this.ticksUntilRefresh <= 0)
		{
			this.setupMap();
			this.ticksUntilRefresh = 2400;
		}
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

		this.bb.maxY = this.yCoord + (int)Math.ceil(this.getOffset() / 16f) + 2;
		this.bb.minX = this.xCoord - (int)Math.ceil(this.getSideLength() / 8f);
		this.bb.maxX = this.xCoord + (int)Math.ceil(this.getSideLength() / 8f);
		this.bb.minZ = this.zCoord - (int)Math.ceil(this.getSideLength() / 8f);
		this.bb.maxZ = this.zCoord + (int)Math.ceil(this.getSideLength() / 8f);

		return this.bb;
	}

	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		this.setOffset(tag.getInteger("offset"));
		this.setRGB(tag.getInteger("color"));
		this.sideLength = tag.getInteger("sidelength");
		super.readFromNBT(tag);
	}

	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setInteger("color", this.getRGB().getRGB());
		tag.setInteger("offset", this.getOffset());
		tag.setInteger("sidelength", this.sideLength);
		super.writeToNBT(tag);
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