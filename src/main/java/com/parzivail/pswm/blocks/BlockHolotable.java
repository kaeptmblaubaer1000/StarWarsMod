package com.parzivail.pswm.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityHoloTable;
import com.parzivail.util.world.HarvestLevel;

public class BlockHolotable extends BlockContainer
{
	public BlockHolotable()
	{
		super(Material.iron);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setBlockName(Resources.MODID + "." + "holoTable");
		this.setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileEntityHoloTable();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float e, float f, float g)
	{
		if (!world.isRemote)
			player.openGui(StarWarsMod.instance, Resources.GUI_HOLOTABLE, world, x, y, z);
		return true;
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
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(Resources.MODID + ":" + "iconHoloTable");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}