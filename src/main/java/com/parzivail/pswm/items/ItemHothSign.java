package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSign;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemHothSign extends ItemSign
{
	public String name = "hothSign";

	public ItemHothSign()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTabBlocks);
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int blockSide, float sX, float sY, float sZ)
	{
		if (blockSide == 0)
		{
			return false;
		}
		else if (!world.getBlock(x, y, z).getMaterial().isSolid())
		{
			return false;
		}
		else
		{
			if (blockSide == 1)
			{
				++y;
			}

			if (blockSide == 2)
			{
				--z;
			}

			if (blockSide == 3)
			{
				++z;
			}

			if (blockSide == 4)
			{
				--x;
			}

			if (blockSide == 5)
			{
				++x;
			}

			if (!player.canPlayerEdit(x, y, z, blockSide, stack))
			{
				return false;
			}
			else if (!StarWarsMod.blockHothSignStanding.canPlaceBlockAt(world, x, y, z))
			{
				return false;
			}
			else if (world.isRemote)
			{
				return true;
			}
			else
			{
				if (blockSide == 1)
				{
					int i1 = MathHelper.floor_double((double)((player.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
					world.setBlock(x, y, z, StarWarsMod.blockHothSignStanding, i1, 3);
				}
				else
				{
					world.setBlock(x, y, z, StarWarsMod.blockHothSign, blockSide, 3);
				}

				--stack.stackSize;
				TileEntitySign tileentitysign = (TileEntitySign)world.getTileEntity(x, y, z);

				if (tileentitysign != null)
				{
					player.func_146100_a(tileentitysign);
				}

				return true;
			}
		}
	}
}
