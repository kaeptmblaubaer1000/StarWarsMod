package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.ItemHydrospanner;
import com.parzivail.pswm.rendering.AnimationAntennaOpen;
import com.parzivail.pswm.tileentities.TileEntityAntenna;
import com.parzivail.util.IDebugProvider;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class BlockAntenna extends BlockContainer implements IDebugProvider
{
	public BlockAntenna()
	{
		super(Material.iron);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setBlockName(Resources.MODID + "." + "antenna");
		setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityAntenna();
	}

	@Override
	public List<String> getDebugText(List<String> list, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityAntenna)
		{
			TileEntityAntenna tile1 = (TileEntityAntenna)tile;
			list.add(String.format("Facing: %s", tile1.getFacing()));
			list.add(String.format("On: %s", tile1.getOn()));
			list.add(String.format("Fixed: %s", tile1.getFixed()));
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float e, float f, float g)
	{
		if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemHydrospanner)
		{
			TileEntity tile = world.getTileEntity(x, y, z);
			if (tile instanceof TileEntityAntenna)
			{
				TileEntityAntenna tile1 = (TileEntityAntenna)tile;

				if (tile1.getFixed())
					tile1.setOn(!tile1.getOn());
				else
				{
					tile1.setFixed(true);
					new AnimationAntennaOpen(tile1).start();
				}
			}
		}
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityAntenna)
		{
			TileEntityAntenna vap = (TileEntityAntenna)tile;
			int l = MathHelper.floor_double(player.rotationYaw * 8.0F / 360.0F + 0.5D) & 0x3;
			vap.setFacing(l);
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(Resources.MODID + ":" + "iconAntenna");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockMV.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */