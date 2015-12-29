package com.parzi.starwarsmod.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.tileentities.TileEntityBasket;
import com.parzi.starwarsmod.tileentities.TileEntityHangingCauldron;
import com.parzi.starwarsmod.utils.HarvestLevel;

public class BlockBasket extends BlockContainer
{
	public BlockBasket()
	{
		super(Material.iron);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setBlockName(StarWarsMod.MODID + "." + "basket");
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.5F, 0.8F);
		this.setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	@Override
    public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z)
    {
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.5F, 0.8F);
    }

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileEntityBasket();
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

	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(StarWarsMod.MODID + ":" + "iconBasket");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockTable.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */