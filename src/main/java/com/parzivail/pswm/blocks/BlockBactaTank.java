package com.parzivail.pswm.blocks;

import java.util.List;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityBactaTank;
import com.parzivail.util.IDebugProvider;
import com.parzivail.util.world.HarvestLevel;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBactaTank extends BlockContainer implements IDebugProvider
{
	public BlockBactaTank()
	{
		super(Material.iron);
		setCreativeTab(StarWarsMod.StarWarsTab);
		setBlockName(Resources.MODID + "." + "bactaTank");
		setBlockBounds(0, 0, 0, 1, 0.83f, 1);
		setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityBactaTank();
	}

	@Override
	public List<String> getDebugText(List<String> list, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityBactaTank)
		{
			TileEntityBactaTank t = (TileEntityBactaTank)tile;
			if (t.getPlayerInside() != null)
			{
				list.add(t.getPlayerInside().getCommandSenderName() + " inside");
				list.add(String.valueOf(t.getTicksInside()) + " ticks inside");
			}
			else
				list.add("No player inside");
		}

		return list;
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
		blockIcon = icon.registerIcon(Resources.MODID + ":" + "iconBactaTank");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z)
	{
		setBlockBounds(0, 0, 0, 1, 0.83f, 1);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockTable.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */