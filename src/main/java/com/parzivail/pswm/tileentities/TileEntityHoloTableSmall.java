package com.parzivail.pswm.tileentities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

public class TileEntityHoloTableSmall extends TileEntity
{
	AxisAlignedBB bb;
	int[] map;
	int sideLength = 64;
	int offset = 0;
	Vec3 rgb;

	public TileEntityHoloTableSmall()
	{
		this.rgb = Vec3.createVectorHelper(0.8f, 0.8f, 1);
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

	public Vec3 getRGB()
	{
		return this.rgb;
	}
	
	public void setRGB(float r, float g, float b)
	{
		this.rgb = Vec3.createVectorHelper(r, g, b);
	}

	public int getOffset()
	{
		return this.offset;
	}
	
	public void setOffset(int offset)
	{
		this.offset = offset;
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
		
		return this.bb;
	}

	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		this.setOffset(tag.getInteger("offset"));
		float r = tag.getFloat("r");
		float g = tag.getFloat("g");
		float b = tag.getFloat("b");
		this.setRGB(r, g, b);
		this.sideLength = tag.getInteger("sidelength");
		super.readFromNBT(tag);
	}

	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		Vec3 c = this.getRGB();
		tag.setFloat("r", (float)c.xCoord);
		tag.setFloat("g", (float)c.yCoord);
		tag.setFloat("b", (float)c.zCoord);
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