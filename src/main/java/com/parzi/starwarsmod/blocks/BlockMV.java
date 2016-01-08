package com.parzi.starwarsmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsEnum;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.tileentities.TileEntityMV;
import com.parzi.util.world.HarvestLevel;

public class BlockMV extends BlockContainer
{
	public BlockMV()
	{
		super(Material.iron);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setBlockName(Resources.MODID + "." + "moistureVaporator");
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F);
		this.setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int wut)
	{
		TileEntityMV moistureVap = (TileEntityMV)world.getTileEntity(x, y, z);
		if (moistureVap != null)
		{
			ItemStack itemstack = moistureVap.getStackInSlot(0);
			if (itemstack != null)
			{
				EntityItem entityitem = new EntityItem(world, x, y, z, itemstack);
				if (itemstack.hasTagCompound())
					entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
				world.spawnEntityInWorld(entityitem);
			}
			world.func_147453_f(x, y, z, block);
		}
		super.breakBlock(world, x, y, z, block, wut);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileEntityMV();
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
		if (!world.isRemote)
			player.openGui(StarWarsMod.instance, StarWarsEnum.GUI_MV, world, x, y, z);
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityMV)
		{
			TileEntityMV vap = (TileEntityMV)tile;
			int l = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
			vap.setFacing(l);
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(Resources.MODID + ":" + "iconMoistureVaporator");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z)
	{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockMV.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */