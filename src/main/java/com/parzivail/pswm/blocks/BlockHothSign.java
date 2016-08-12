package com.parzivail.pswm.blocks;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.tileentities.TileEntityHothSign;
import com.parzivail.util.world.HarvestLevel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSign;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class BlockHothSign extends BlockSign
{
	public BlockHothSign(boolean standing)
	{
		super(TileEntityHothSign.class, standing);
		setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return StarWarsItems.hothSign;
	}

	/**
	 * Gets an item for the block being called on. Args: world, x, y, z
	 */
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
	{
		return StarWarsItems.hothSign;
	}

	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
	{
	}
}
