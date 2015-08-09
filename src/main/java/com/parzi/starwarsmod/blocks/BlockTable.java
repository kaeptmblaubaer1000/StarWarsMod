package com.parzi.starwarsmod.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.tileentities.TileEntityTable;
import com.parzi.starwarsmod.utils.HarvestLevel;

public class BlockTable extends BlockContainer
{

	public BlockTable()
	{
		super(Material.iron);
		setCreativeTab(StarWarsMod.StarWarsTab);
		setBlockName(StarWarsMod.MODID + "." + "table");
		setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		setHardness(50F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileEntityTable();
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	// This is the icon to use for showing the block in your hand.
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(StarWarsMod.MODID + ":" + "iconTable");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
