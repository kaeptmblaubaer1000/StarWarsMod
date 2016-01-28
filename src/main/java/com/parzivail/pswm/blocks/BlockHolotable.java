package com.parzivail.pswm.blocks;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;
import com.parzivail.pswm.tileentities.TileEntityHoloTableLarge;
import com.parzivail.pswm.tileentities.TileEntityHoloTableMedium;
import com.parzivail.pswm.tileentities.TileEntityHoloTableWar;
import com.parzivail.util.world.HarvestLevel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHolotable extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	public IIcon topIcon;

	public BlockHolotable()
	{
		super(Material.iron);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setBlockName(Resources.MODID + "." + "holoTable");
		this.setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		if (meta == 1)
			return new TileEntityHoloTableMedium();
		else if (meta == 2)
			return new TileEntityHoloTableLarge();
		else if (meta == 3)
			return new TileEntityHoloTableWar();
		return new TileEntityHoloTableBase();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float e, float f, float g)
	{
		if (!world.isRemote && player.inventory.getCurrentItem() == null)
			player.openGui(StarWarsMod.instance, Resources.GUI_HOLOTABLE, world, x, y, z);
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		if (p_149691_1_ == 1)
			return this.topIcon;
		return this.blockIcon;
	}

	@Override
	public int getRenderType()
	{
		return 0;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List metaTypes)
	{
		metaTypes.add(new ItemStack(item, 1, 0)); // small
		metaTypes.add(new ItemStack(item, 1, 1)); // medium
		metaTypes.add(new ItemStack(item, 1, 2)); // large
		metaTypes.add(new ItemStack(item, 1, 3)); // war
	}

	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(Resources.MODID + ":" + "holoTable");
		this.topIcon = icon.registerIcon(Resources.MODID + ":" + "holoTable_Top");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}