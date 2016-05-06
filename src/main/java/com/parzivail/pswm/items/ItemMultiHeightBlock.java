package com.parzivail.pswm.items;

import com.parzivail.pswm.StarWarsMod;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Colby on 5/5/2016.
 */
public class ItemMultiHeightBlock extends ItemBlockWithMetadata
{
	public ItemMultiHeightBlock(Block block)
	{
		super(block, block);
	}

	/**
	 * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	 * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float subX, float subY, float subZ)
	{
		if (stack.stackSize == 0)
		{
			return false;
		}
		else if (!player.canPlayerEdit(x, y, z, side, stack))
		{
			return false;
		}
		else
		{
			Block block = world.getBlock(x, y, z);

			if (block == StarWarsMod.blockMultiHeight)
			{
				int i1 = world.getBlockMetadata(x, y, z);
				int j1 = i1 & 15;

				if (j1 < 15 && world.checkNoEntityCollision(this.field_150939_a.getCollisionBoundingBoxFromPool(world, x, y, z)) && world.setBlockMetadataWithNotify(x, y, z, j1 + 1 | i1 & -8, 2))
				{
					world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.field_150939_a.stepSound.func_150496_b(), (this.field_150939_a.stepSound.getVolume() + 1.0F) / 2.0F, this.field_150939_a.stepSound.getPitch() * 0.8F);
					--stack.stackSize;
					return true;
				}
			}

			return super.onItemUse(stack, player, world, x, y, z, side, subX, subY, subZ);
		}
	}
}