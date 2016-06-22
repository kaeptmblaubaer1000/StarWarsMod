package com.parzivail.pswm.blocks;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.PBlock;
import com.parzivail.util.world.HarvestLevel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockTatooineSand extends PBlock
{
	private int subtypes = 2;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockTatooineSand()
	{
		super("tatooineSand", Material.sand);
		setCreativeTab(StarWarsMod.StarWarsTabBlocks);
		setHardness(0.5F);
		this.setHarvestLevel("shovel", HarvestLevel.WOOD);
		setStepSound(soundTypeSand);
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (meta < 2)
			return icons[meta];
		return icons[0];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List metaTypes)
	{
		for (int i = 0; i < subtypes; i++)
			metaTypes.add(new ItemStack(item, 1, i));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[subtypes];
		for (int i = 0; i < icons.length; i++)
			icons[i] = par1IconRegister.registerIcon(Resources.MODID + ":" + name + i);
	}
}
