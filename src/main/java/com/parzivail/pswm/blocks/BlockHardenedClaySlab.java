package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.world.HarvestLevel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockHardenedClaySlab extends BlockSlab
{
	public BlockHardenedClaySlab(boolean p_i45437_1_)
	{
		super(p_i45437_1_, Material.wood);
		this.setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.setBlockName(Resources.MODID + "." + "hardenedClaySlab");
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		return Blocks.hardened_clay.getIcon(p_149691_1_, p_149691_2_ & 7);
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return Item.getItemFromBlock(StarWarsMod.blockHardenedClaySlab);
	}

	/**
	 * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
	 * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
	 */
	protected ItemStack createStackedBlock(int p_149644_1_)
	{
		return new ItemStack(Item.getItemFromBlock(StarWarsMod.blockHardenedClayDoubleSlab), 2, p_149644_1_ & 7);
	}

	public String func_150002_b(int p_150002_1_)
	{
		return super.getUnlocalizedName();
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
	}
}
