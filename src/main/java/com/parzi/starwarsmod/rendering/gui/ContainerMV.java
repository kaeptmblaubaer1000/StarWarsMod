package com.parzi.starwarsmod.rendering.gui;

import com.parzi.starwarsmod.tileentities.TileEntityMV;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerMV extends Container
{
	private TileEntityMV tileMV;

	public ContainerMV(InventoryPlayer player, TileEntityMV vap)
	{
		this.tileMV = vap;
		this.addSlotToContainer(new SlotFurnace(player.player, vap, 2, 80, 35));
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 9; j++)
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
		for (int i = 0; i < 9; i++)
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.tileMV.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(slotNumber);
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (slotNumber == 0)
			{
				if (!this.mergeItemStack(itemstack1, 1, 37, true))
					return null;
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (slotNumber != 1 && slotNumber != 0)
			{
				if (slotNumber >= 3 && slotNumber < 30)
				{
					if (!this.mergeItemStack(itemstack1, 28, 37, false))
						return null;
				}
				else if (slotNumber >= 28 && slotNumber < 37 && !this.mergeItemStack(itemstack1, 3, 30, false))
					return null;
			}
			else if (!this.mergeItemStack(itemstack1, 1, 37, false))
				return null;
			if (itemstack1.stackSize == 0)
				slot.putStack((ItemStack)null);
			else
				slot.onSlotChanged();
			if (itemstack1.stackSize == itemstack.stackSize)
				return null;
			slot.onPickupFromSlot(player, itemstack1);
		}
		return itemstack;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\gui\ContainerMV.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */