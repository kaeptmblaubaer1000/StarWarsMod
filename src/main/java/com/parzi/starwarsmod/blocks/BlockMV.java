package com.parzi.starwarsmod.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.gui.JediGUI;
import com.parzi.starwarsmod.rendering.gui.MVGUI;
import com.parzi.starwarsmod.tileentities.TileEntityMV;
import com.parzi.starwarsmod.utils.HarvestLevel;
import com.parzi.starwarsmod.utils.ItemUtils;

public class BlockMV extends BlockContainer
{

	public BlockMV()
	{
		super(Material.iron);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		setBlockName(StarWarsMod.MODID + "." + "moistureVaporator");
		this.setBlockBounds(0F, 0F, 0F, 1F, 4F, 1F);
		this.setHardness(50F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float e, float f, float g)
	{
		Minecraft.getMinecraft().displayGuiScreen(new MVGUI(x, z));
		return true;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	// This is the icon to use for showing the block in your hand.
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(StarWarsMod.MODID + ":" + "iconMoistureVaporator");
	}
}
