package com.parzi.starwarsmod.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.parzi.starwarsmod.StarWarsMod;

public class TileEntityMV extends TileEntity implements IInventory
{
	public int frame;
	public int progressTicks;
	public int totalTicks;
	private int facing = 2;
	private ItemStack waterDroplets;

	public TileEntityMV()
	{
		frame = 0;
		progressTicks = 1;
		totalTicks = 600;
		waterDroplets = null;
	}

	@Override
	public void closeInventory()
	{
	}

	@Override
	public ItemStack decrStackSize(int slot, int decrement)
	{
		if (waterDroplets == null)
		{
			return null;
		}
		else
		{
			if (decrement < waterDroplets.stackSize)
			{
				ItemStack take = waterDroplets.splitStack(decrement);
				if (waterDroplets.stackSize <= 0)
				{
					waterDroplets = null;
				}
				return take;
			}
			else
			{
				ItemStack take = waterDroplets;
				waterDroplets = null;
				return take;
			}
		}
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, -999, tag);
	}

	public int getFacing()
	{
		return facing;
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
	public ItemStack getStackInSlot(int p_70301_1_)
	{
		return waterDroplets;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_)
	{
		if (waterDroplets == null) { return null; }
		ItemStack take = waterDroplets;
		waterDroplets = null;
		return take;
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
	{
		return false;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
	{
		super.onDataPacket(net, packet);
		readFromNBT(packet.func_148857_g());
	}

	@Override
	public void openInventory()
	{
	}

	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		waterDroplets = ItemStack.loadItemStackFromNBT(tag.getCompoundTag("droplets"));
		progressTicks = tag.getInteger("progress");
		facing = tag.getShort("facing");
		super.readFromNBT(tag);
	}

	public void setFacing(int dir)
	{
		facing = dir;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		waterDroplets = stack;
	}

	@Override
	public void updateEntity()
	{
		// if (++this.frame > 180) this.frame = 0;

		if (progressTicks < totalTicks)
		{
			progressTicks++;
		}
		else
		{
			progressTicks = 1;
			if (waterDroplets == null)
			{
				waterDroplets = new ItemStack(StarWarsMod.waterDroplet, 1);
			}
			else
			{
				if (waterDroplets.stackSize < 64)
				{
					waterDroplets.stackSize++;
				}
			}
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setInteger("progress", progressTicks);
		tag.setShort("facing", (short)facing);
		if (waterDroplets != null)
		{
			NBTTagCompound produce = new NBTTagCompound();
			produce = waterDroplets.writeToNBT(produce);
			tag.setTag("droplets", produce);
		}
		super.writeToNBT(tag);
	}
}