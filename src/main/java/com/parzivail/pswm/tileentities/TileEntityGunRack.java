package com.parzivail.pswm.tileentities;

import com.parzivail.util.block.TileEntityRotate;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityGunRack extends TileEntityRotate
{
	private ItemStack[] guns = new ItemStack[12];

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_)
	{
		super.readFromNBT(p_145839_1_);

		NBTTagList nbttaglist = p_145839_1_.getTagList("guns", 10);

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);

			if (i < guns.length)
				this.guns[i] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
		}
	}

	public ItemStack[] getGuns()
	{
		return guns;
	}

	public void pushGun(ItemStack gun)
	{
		for (int i = 0; i < this.guns.length; i++)
			if (this.guns[i] == null)
			{
				this.guns[i] = gun;
				break;
			}
	}

	public ItemStack popGun()
	{
		ItemStack s = null;
		for (int i = this.guns.length - 1; i >= 0; i--)
			if (this.guns[i] != null)
			{
				s = this.guns[i];
				this.guns[i] = null;
				break;
			}
		return s;
	}

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_)
	{
		super.writeToNBT(p_145841_1_);

		NBTTagList nbttaglist = new NBTTagList();

		for (ItemStack gun : this.guns)
		{
			if (gun == null)
				continue;
			nbttaglist.appendTag(gun.writeToNBT(new NBTTagCompound()));
		}

		p_145841_1_.setTag("guns", nbttaglist);
	}
}
