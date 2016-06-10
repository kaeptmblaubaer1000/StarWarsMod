package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityHyperdrive;
import com.parzivail.util.IDebugProvider;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

public class BlockHyperdrive extends BlockContainer implements IDebugProvider
{
	public BlockHyperdrive()
	{
		super(Material.iron);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setBlockName(Resources.MODID + "." + "hyperdriveBlock");
		setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityHyperdrive();
	}

	@Override
	public List<String> getDebugText(List<String> list, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityHyperdrive)
		{
			TileEntityHyperdrive vap = (TileEntityHyperdrive)tile;
			list.add(String.valueOf(vap.getTicks()) + " ticks");
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
		blockIcon = icon.registerIcon(Resources.MODID + ":" + "blank");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		if (world.isRemote)
			player.openGui(StarWarsMod.instance, Resources.GUI_HYPERDRIVE, world, x, y, z);
		return true;
	}
}
