package com.parzivail.pswm.tileentities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class TileEntityHoloTableBase extends TileEntity
{
	private AxisAlignedBB bb;
	private int[] map;
	int sideLength = 64;
	private int offsetY = 0;
	private int offsetX = 0;
	private int offsetZ = 0;
	private Color rgb;
	private int ticksUntilRefresh = 80;
	private int displayList = -1;

	public TileEntityHoloTableBase()
	{
		this.setRGB(0.4f, 0.4f, 1);
	}

	public int getDisplayList()
	{
		return this.displayList;
	}

	protected void regenDisplayList()
	{
		if (displayList == -1)
			displayList = GL11.glGenLists(1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);

		GL11.glLineWidth(4);

		for (int i = 0; i < this.getMap().length; i++)
		{
			int nx = i % this.getSideLength();
			int nz = (int)Math.floor(i / this.getSideLength());

			float o = this.getOffsetY() / 16f;

			int s = this.getSideLength() / 2;

			GL11.glBegin(GL11.GL_LINE_LOOP);
			GL11.glVertex3d(nx - s - 1, this.getMap()[i] - this.yCoord + o, nz - s - 1);
			GL11.glVertex3d(nx - s, this.getMap()[i] - this.yCoord + o, nz - s);
			GL11.glEnd();
			GL11.glBegin(GL11.GL_LINE_LOOP);
			GL11.glVertex3d(nx - s - 1, this.getMap()[i] - this.yCoord + o, nz - s);
			GL11.glVertex3d(nx - s, this.getMap()[i] - this.yCoord + o, nz - s - 1);
			GL11.glEnd();
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

	public int getOffsetY()
	{
		return this.offsetY;
	}

	public int getOffsetX()
	{
		return this.offsetX;
	}

	public int getOffsetZ()
	{
		return this.offsetZ;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		if (this.bb == null)
			this.bb = AxisAlignedBB.getBoundingBox(this.xCoord - 3, this.yCoord, this.zCoord - 3, this.xCoord + 3, this.yCoord + 2, this.zCoord + 3);

		this.bb.maxY = this.yCoord + (int)Math.ceil(this.getOffsetY() / 16f) + 2;
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
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		this.setOffsetY(tag.getInteger("offsetY"));
		this.setOffsetX(tag.getInteger("offsetX"));
		this.setOffsetZ(tag.getInteger("offsetZ"));
		this.setRGB(tag.getInteger("color"));
		this.sideLength = tag.getInteger("sidelength");
	}

	public void setOffsetY(int offsetY)
	{
		this.offsetY = offsetY;
	}

	public void setOffsetX(int offsetX)
	{
		this.offsetX = offsetX;
	}

	public void setOffsetZ(int offsetZ)
	{
		this.offsetZ = offsetZ;
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
		super.updateEntity();
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
		super.writeToNBT(tag);
		tag.setInteger("color", this.getRGB().getRGB());
		tag.setInteger("offsetY", this.getOffsetY());
		tag.setInteger("offsetX", this.getOffsetX());
		tag.setInteger("offsetZ", this.getOffsetZ());
		tag.setInteger("sidelength", this.sideLength);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\tileentities\TileEntityMV.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */