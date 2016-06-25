package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityPanelHoth;
import com.parzivail.util.block.PBlockContainer;
import com.parzivail.util.world.HarvestLevel;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockPanelHoth extends PBlockContainer
{
	public BlockPanelHoth()
	{
		super("blockPanelHoth", Material.iron);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setBlockBounds(0, 0, 0, 1, 3f, 1);
		setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityPanelHoth)
		{
			TileEntityPanelHoth te = (TileEntityPanelHoth)tile;
			int l = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
			te.setFacing(l);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityPanelHoth();
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
}
