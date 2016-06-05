package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.tileentities.TileEntityMovingLightSource;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockMovingLightSource extends Block implements ITileEntityProvider
{
	public BlockMovingLightSource()
	{
		super(Material.air);
		setBlockName(Resources.MODID + ":" + "movingLightSource");
		setTickRandomly(false);
		setLightLevel(0.5F);
		setBlockBounds(0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return null;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
	{
		return true;
	}

	@Override
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
	{
	}

	@Override
	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
	{
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		setLightLevel(0.75f);
		return new TileEntityMovingLightSource();
	}
}
