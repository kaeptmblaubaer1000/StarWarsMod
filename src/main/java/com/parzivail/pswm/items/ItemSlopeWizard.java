package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemSlopeWizard extends Item
{
	public String name = "slopeWizard";

	public ItemSlopeWizard()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float sX, float sY, float sZ)
	{
		if (!world.isRemote)
		{
			if (stack.stackTagCompound == null)
				stack.stackTagCompound = new NBTTagCompound();

			if (stack.stackTagCompound.getIntArray("firstPos").length == 0)
			{
				stack.stackTagCompound.setIntArray("firstPos", new int[] { x, y, z });

				player.addChatComponentMessage(new ChatComponentText(String.format("Set first position: %s,%s,%s", x, y, z)));
			}
			else
			{
				int[] posA = stack.stackTagCompound.getIntArray("firstPos");
				int aX = posA[0];
				int aY = posA[1];
				int aZ = posA[2];

				if (aX == x)
				{
					//going in z direction
					double rise = y - aY;
					double run = z - aZ;
					double slope = rise / run;

					if (z > aZ)
					{
						int t = z;
						z = aZ;
						aZ = t;
					}
					for (int nZ = 0; nZ <= (aZ - z); nZ++)
					{
						world.setBlock(x, getBaseBlockY(slope, nZ) + y, z + nZ, StarWarsMod.blockTempleStone);
						world.setBlock(x, getBaseBlockY(slope, nZ) + y + 1, z + nZ, StarWarsMod.blockTempleStoneMH, getVarHeightY(slope, nZ), 1 | 2);
						world.setBlockMetadataWithNotify(x, getBaseBlockY(slope, nZ) + y + 1, z + nZ, getVarHeightY(slope, nZ), 1 | 2);

						player.addChatComponentMessage(new ChatComponentText(String.format("Created block at %s,%s,%s", x, getBaseBlockY(slope, nZ), nZ)));
					}

					player.addChatComponentMessage(new ChatComponentText(String.format("Created Z-dir slope from Y=%s to Y=%s (M=%s)", y, aY, slope)));
				}
				else if (aZ == z)
				{
					// going in x direction
					double rise = y - aY;
					double run = x - aX;
					double slope = rise / run;

					if (x > aX)
					{
						int t = x;
						x = aX;
						aX = t;
					}
					for (int nX = 0; nX <= (aX - x); nX++)
					{
						world.setBlock(x + nX, getBaseBlockY(slope, nX) + aY, z, StarWarsMod.blockTempleStone);
						world.setBlock(x + nX, getBaseBlockY(slope, nX) + aY + 1, z, StarWarsMod.blockTempleStoneMH, getVarHeightY(slope, nX), 1 | 2);
						world.setBlockMetadataWithNotify(x + nX, getBaseBlockY(slope, nX) + aY + 1, z, getVarHeightY(slope, nX), 1 | 2);

						player.addChatComponentMessage(new ChatComponentText(String.format("Created block at %s,%s,%s", x + nX, getBaseBlockY(slope, nX) + aY, z)));
					}

					player.addChatComponentMessage(new ChatComponentText(String.format("Created X-dir slope from Y=%s to Y=%s (M=%s)", y, aY, slope)));
				}
				else
				{
					player.addChatComponentMessage(new ChatComponentText("Cannot create diagonal slopes!"));
				}
				stack.stackTagCompound.setIntArray("firstPos", new int[0]);
			}
		}

		return super.onItemUse(stack, player, world, x, y, z, side, sX, sY, sZ);
	}

	private int getBaseBlockY(double slope, double x)
	{
		return (int)Math.floor((Math.floor(16 * slope * Math.floor(x))) / 16);
	}

	private int getVarHeightY(double slope, double x)
	{
		return (int)((Math.floor(16 * slope * Math.floor(x))) / 16);
	}
}