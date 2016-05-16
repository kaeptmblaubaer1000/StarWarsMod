package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.StarWarsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMV extends TileEntity implements IInventory
{
	public int frame;
	public int progressTicks;
	public int totalTicks;
	private int facing = 2;
	private ItemStack waterDroplets;

	public TileEntityMV()
	{
		this.frame = 0;
		this.progressTicks = 1;
		this.totalTicks = 600;
		this.waterDroplets = null;
	}

	@Override
	public void closeInventory()
	{
	}

	@Override
	public ItemStack decrStackSize(int slot, int decrement)
	{
		if (this.waterDroplets == null)
			return null;
		if (decrement < this.waterDroplets.stackSize)
		{
			ItemStack take = this.waterDroplets.splitStack(decrement);
			if (this.waterDroplets.stackSize <= 0)
				this.waterDroplets = null;
			return take;
		}
		ItemStack take = this.waterDroplets;
		this.waterDroplets = null;
		return take;
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
	public String getInventoryName()
	{
		return "Moisture Vaporator";
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public int getSizeInventory()
	{
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int slotIn)
	{
		return this.waterDroplets;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index)
	{
		if (this.waterDroplets == null)
			return null;
		ItemStack take = this.waterDroplets;
		this.waterDroplets = null;
		return take;
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInventoryNameLocalized()
	{
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		return false;
	}

	@Override
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
	public void openInventory()
	{
	}

	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		this.waterDroplets = ItemStack.loadItemStackFromNBT(tag.getCompoundTag("droplets"));
		this.progressTicks = tag.getInteger("progress");
		this.facing = tag.getShort("facing");
		super.readFromNBT(tag);
	}

	public void setFacing(int dir)
	{
		this.facing = dir;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		this.waterDroplets = stack;
	}

	@Override
	public void updateEntity()
	{
		if (this.progressTicks < this.totalTicks)
			this.progressTicks += 1;
		else
		{
			this.progressTicks = 1;
			if (this.waterDroplets == null)
				this.waterDroplets = new ItemStack(StarWarsMod.waterDroplet, 1);
			else if (this.waterDroplets.stackSize < 64)
				this.waterDroplets.stackSize += 1;
			this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setInteger("progress", this.progressTicks);
		tag.setShort("facing", (short)this.facing);
		if (this.waterDroplets != null)
		{
			NBTTagCompound produce = new NBTTagCompound();
			produce = this.waterDroplets.writeToNBT(produce);
			tag.setTag("droplets", produce);
		}
		super.writeToNBT(tag);
	}
}
