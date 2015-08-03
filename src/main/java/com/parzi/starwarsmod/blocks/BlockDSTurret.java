package com.parzi.starwarsmod.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.tileentities.TileEntityDSTurret;
import com.parzi.starwarsmod.utils.HarvestLevel;

public class BlockDSTurret extends BlockContainer
{

	public BlockDSTurret()
	{
		super(Material.iron);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		setBlockName(StarWarsMod.MODID + "." + "dsTurret");
		this.setBlockBounds(0F, 0F, 0F, 2.5F, 2.5F, 2.5F);
		this.setHarvestLevel("pickaxe", HarvestLevel.DIAMOND);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileEntityDSTurret();
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float e, float f, float g)
	{
		return true;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	// This is the icon to use for showing the block in your hand.
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(StarWarsMod.MODID + ":" + "iconDSTurret");
	}
}
