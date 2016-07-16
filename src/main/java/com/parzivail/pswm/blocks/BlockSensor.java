package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntitySensor;
import com.parzivail.util.block.PBlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSensor extends PBlockContainer
{
	public BlockSensor(String name)
	{
		super("sensor-" + name, Material.iron);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setBlockTextureName(Resources.MODID + ":" + name);
		this.setBlockUnbreakable();
		this.setResistance(6000000.0F);
		this.setStepSound(soundTypePiston);
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
	public void registerBlockIcons(IIconRegister icon)
	{
		blockIcon = icon.registerIcon(Resources.MODID + ":" + "blank");
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		super.updateTick(world, x, y, z, random);

		//this.blockIcon = world.getBlock(x + 1, y, z).getIcon(world, x, y, z, world.getBlockMetadata(x + 1, y, z));
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
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack stack)
	{
		int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}
}
