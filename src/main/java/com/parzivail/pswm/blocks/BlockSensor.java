package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntitySensor;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensor extends BlockContainer
{
	public BlockSensor(String name)
	{
		super(Material.iron);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setBlockName(Resources.MODID + "." + "sensor." + name);
		setBlockTextureName(Resources.MODID + "." + "sensor");
		setBlockUnbreakable();
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensor();
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
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
