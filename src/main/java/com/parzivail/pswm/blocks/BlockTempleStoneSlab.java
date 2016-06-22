package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlockSlab;
import com.parzivail.util.world.HarvestLevel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockTempleStoneSlab extends PBlockSlab
{
	public static final String[] names = new String[] { "templeStone", "templeStoneBrick", "templeStoneBrickFancy", "templeStoneSlab" };
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockTempleStoneSlab(boolean p_i45431_1_, boolean lit)
	{
		super("templeStoneSlab" + (lit ? "Lit" : ""), p_i45431_1_, Material.rock);
		if (lit)
			this.setLightLevel(1);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		setStepSound(soundTypeMetal);
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		if (p_149691_2_ % names.length == 3 && p_149691_1_ < 2)
			return icons[names.length];
		return icons[p_149691_2_ % names.length];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		this.icons = new IIcon[names.length + 1];
		for (int i = 0; i < names.length; i++)
		{
			icons[i] = p_149651_1_.registerIcon(Resources.MODID + ":" + names[i]);
		}

		icons[names.length] = p_149651_1_.registerIcon(Resources.MODID + ":" + "templeStoneSlabTopDark");
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return Item.getItemFromBlock(StarWarsMod.blockTempleStoneSlab);
	}

	/**
	 * Returns an item stack containing a single instance of the current block
	 * type. 'i' is the block's subtype/damage and is ignored for blocks which
	 * do not support subtypes. Blocks which cannot be harvested should return
	 * null.
	 */
	protected ItemStack createStackedBlock(int p_149644_1_)
	{
		return new ItemStack(Item.getItemFromBlock(StarWarsMod.blockTempleStoneSlab), 2, p_149644_1_);
	}

	public String func_150002_b(int p_150002_1_)
	{
		if (p_150002_1_ < 0 || p_150002_1_ >= names.length)
		{
			p_150002_1_ = 0;
		}

		return super.getUnlocalizedName() + "." + names[p_150002_1_];
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}

	public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_)
	{
		return this.damageDropped(p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_));
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
	{
		return Item.getItemFromBlock(this);
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
	{
		for (int i = 0; i < names.length; ++i)
		{
			p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
		}
	}
}