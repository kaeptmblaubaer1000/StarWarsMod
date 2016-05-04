package com.parzivail.pswm.tileentities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class TileEntityHoloTableBase extends TileEntity
{
	AxisAlignedBB bb;
	int[] map;
	int sideLength = 64;
	int offset = 0;
	Color rgb;
	int ticksUntilRefresh = 80;
	int displayList = -1;

	public TileEntityHoloTableBase()
	{
		this.setRGB(0.4f, 0.4f, 1);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 64537, tag);
	}

	public int getDisplayList()
	{
		return this.displayList;
	}

	public void regenDisplayList()
	{
		if (displayList == -1)
			displayList = GL11.glGenLists(1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);

		GL11.glLineWidth(4);

		boolean solid = false;

		for (int i = 0; i < this.getMap().length; i++)
		{
			int nx = i % this.getSideLength();
			int nz = (int)Math.floor(i / this.getSideLength());

			float o = this.getOffset() / 16f;

			int s = this.getSideLength() / 2;

			if (solid)
			{
				GL11.glBegin(GL11.GL_TRIANGLE_FAN);
				GL11.glVertex3f(nx - s, this.getMap()[i] - this.yCoord + o, nz - s);
				GL11.glVertex3f(nx - s + 1, this.getMap()[i] - this.yCoord + o, nz - s);
				GL11.glVertex3f(nx - s, this.getMap()[i] - this.yCoord + o, nz - s + 1);
				GL11.glEnd();
				GL11.glBegin(GL11.GL_TRIANGLE_FAN);
				GL11.glVertex3f(nx - s + 1, this.getMap()[i] - this.yCoord + o, nz - s + 1);
				GL11.glVertex3f(nx - s + 1, this.getMap()[i] - this.yCoord + o, nz - s);
				GL11.glVertex3f(nx - s, this.getMap()[i] - this.yCoord + o, nz - s + 1);
				GL11.glEnd();
			}
			else
			{
				GL11.glBegin(GL11.GL_LINE_LOOP);
				GL11.glVertex3d(nx - s - 1, this.getMap()[i] - this.yCoord + o, nz - s - 1);
				GL11.glVertex3d(nx - s, this.getMap()[i] - this.yCoord + o, nz - s);
				GL11.glEnd();
				GL11.glBegin(GL11.GL_LINE_LOOP);
				GL11.glVertex3d(nx - s - 1, this.getMap()[i] - this.yCoord + o, nz - s);
				GL11.glVertex3d(nx - s, this.getMap()[i] - this.yCoord + o, nz - s - 1);
				GL11.glEnd();
			}
		}
		GL11.glEndList();
	}

	public int[] getMap()
	{
		if (this.map == null)
			this.setupMap();
		return this.map;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()
	{
		return 262144;
	}

	public int getOffset()
	{
		return this.offset;
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

	public Color getRGB()
	{
		return this.rgb;
	}

	public int getSideLength()
	{
		return this.sideLength;
	}

	public boolean isMapSetup()
	{
		return this.map != null;
	}

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
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
		this.setOffset(tag.getInteger("offset"));
		this.setRGB(tag.getInteger("color"));
		this.sideLength = tag.getInteger("sidelength");
		super.readFromNBT(tag);
	}

	public void setOffset(int offset)
	{
		this.offset = offset;
	}

	public void setRGB(float r, float g, float b)
	{
		this.rgb = new Color(r, g, b);
	}

	public void setRGB(int color)
	{
		this.rgb = new Color(color);
	}

	public void setupMap()
	{
		this.map = new int[this.sideLength * this.sideLength];

		for (int i = 0; i < this.map.length; i++)
		{
			int x = i % this.sideLength;
			int z = (int)Math.floor(i / this.sideLength);

			this.map[i] = this.worldObj.getHeightValue(this.xCoord + x - this.sideLength / 2, this.zCoord + z - this.sideLength / 2);
		}

		if (this.worldObj.isRemote)
			this.regenDisplayList();
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
		if (this.ticksUntilRefresh % 80 == 0)
			this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setInteger("color", this.getRGB().getRGB());
		tag.setInteger("offset", this.getOffset());
		tag.setInteger("sidelength", this.sideLength);
		super.writeToNBT(tag);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\tileentities\TileEntityMV.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */