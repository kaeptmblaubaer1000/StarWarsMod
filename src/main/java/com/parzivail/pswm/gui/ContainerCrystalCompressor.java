package com.parzivail.pswm.gui;

import com.parzivail.pswm.tileentities.TileEntityCrystalCompressor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCrystalCompressor extends Container
{
	private TileEntityCrystalCompressor crystalCompressor;

	private int time;

	public ContainerCrystalCompressor(InventoryPlayer p_i1805_1_, TileEntityCrystalCompressor p_i1805_2_)
	{
		this.crystalCompressor = p_i1805_2_;
		this.addSlotToContainer(new SlotCrystal(p_i1805_1_.player, p_i1805_2_, 0, 40, 13));
		this.addSlotToContainer(new SlotCrystal(p_i1805_1_.player, p_i1805_2_, 1, 14, 36));
		this.addSlotToContainer(new SlotCrystal(p_i1805_1_.player, p_i1805_2_, 2, 40, 59));
		this.addSlotToContainer(new SlotCrystalOutput(p_i1805_1_.player, p_i1805_2_, 3, 146, 36));
		int i;

		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(p_i1805_1_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(p_i1805_1_, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting p_75132_1_)
	{
		super.addCraftingToCrafters(p_75132_1_);
		p_75132_1_.sendProgressBarUpdate(this, 0, this.crystalCompressor.getCompressTime());
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (Object crafter : this.crafters)
		{
			ICrafting icrafting = (ICrafting)crafter;

			if (this.time != this.crystalCompressor.getCompressTime())
			{
				icrafting.sendProgressBarUpdate(this, 0, this.crystalCompressor.getCompressTime());
			}
		}

		this.time = this.crystalCompressor.getCompressTime();
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int p_75137_1_, int p_75137_2_)
	{
		if (p_75137_1_ == 0)
		{
			this.crystalCompressor.setCompressTime(p_75137_2_);
		}
	}

	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return this.crystalCompressor.isUseableByPlayer(p_75145_1_);
	}

	/**
	 * Called when a ship shift-clicks on a slot. You must override this or you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if ((p_82846_2_ < 0 || p_82846_2_ > 2) && p_82846_2_ != 3)
			{
				if (SlotCrystal.canHold(itemstack))
				{
					if (!this.mergeItemStack(itemstack1, 0, 3, false))
					{
						return null;
					}
				}
				else if (p_82846_2_ >= 4 && p_82846_2_ < 31)
				{
					if (!this.mergeItemStack(itemstack1, 31, 40, false))
					{
						return null;
					}
				}
				else if (p_82846_2_ >= 31 && p_82846_2_ < 40)
				{
					if (!this.mergeItemStack(itemstack1, 4, 31, false))
					{
						return null;
					}
				}
				else if (!this.mergeItemStack(itemstack1, 4, 40, false))
				{
					return null;
				}
			}
			else
			{
				if (!this.mergeItemStack(itemstack1, 4, 40, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(p_82846_1_, itemstack1);
		}

		return itemstack;
	}
}