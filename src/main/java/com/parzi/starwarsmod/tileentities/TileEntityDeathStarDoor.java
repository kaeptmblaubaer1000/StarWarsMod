package com.parzi.starwarsmod.tileentities;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityDeathStarDoor extends TileEntity
{
	public int progressTicks;
	public int totalTicks;
	public boolean isOpening = false;
	public boolean isClosing = false;
	public boolean isMoving = false;
	private int facing = 2;
	AxisAlignedBB bb;

	public TileEntityDeathStarDoor()
	{
		this.progressTicks = 1;
		this.totalTicks = 25;
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
	public void updateEntity()
	{
		if (this.progressTicks < this.totalTicks && this.isOpening)
		{
			this.progressTicks++;
		}
		else
			this.isOpening = false;

		if (this.progressTicks > 0 && this.isClosing)
		{
			this.progressTicks--;
		}
		else
			this.isClosing = false;

		this.isMoving = this.isOpening || this.isClosing;
	}

	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setShort("facing", (short)this.facing);
		super.writeToNBT(tag);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		if (this.bb == null)
			this.bb = AxisAlignedBB.getBoundingBox(this.xCoord - 3, this.yCoord, this.zCoord - 3, this.xCoord + 3, this.yCoord + 5, this.zCoord + 3);
		return bb;
	}

	@Override
    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
        return 262144;
    }
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\tileentities\TileEntityMV.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */