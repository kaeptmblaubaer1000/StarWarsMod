package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityShipwright;
import com.parzivail.util.IDebugProvider;
import com.parzivail.util.block.PBlockContainer;
import com.parzivail.util.driven.EntityCamera;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

public class BlockShipwright extends PBlockContainer implements IDebugProvider
{
	public BlockShipwright()
	{
		super("shipwright", Material.iron);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(50.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityShipwright();
	}

	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(Resources.MODID + ":" + "blank");
	}

	@Override
	public List<String> getDebugText(List<String> list, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		//		if (tile instanceof TileEntityAntenna)
		//		{
		//			TileEntityAntenna tile1 = (TileEntityAntenna)tile;
		//			list.add(String.format(LangUtils.translate("facing") + ": %s", tile1.getFacing()));
		//			list.add(String.format(LangUtils.translate("on") + ": %s", tile1.getOn()));
		//			list.add(String.format(LangUtils.translate("fixed") + ": %s", tile1.getFixed()));
		//		}

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
		if (world.isRemote)
		{
			player.openGui(StarWarsMod.instance, Resources.GUI_SHIPWRIGHT, world, x, y, z);
			EntityCamera camera = new EntityCamera(world);
			world.spawnEntityInWorld(camera);
			camera.copyLocationAndAnglesFrom(player);
			StarWarsMod.mc.renderViewEntity = camera;
		}
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityShipwright)
		{
			TileEntityShipwright tile1 = (TileEntityShipwright)tile;
			// do things
		}
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
