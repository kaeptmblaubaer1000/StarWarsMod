package com.parzivail.util.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.world.HarvestLevel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLitMultiTexture extends BlockMultiTexture
{
	public BlockLitMultiTexture(String base, String[] postfixes, float light, Material material)
	{
		super(base, postfixes, material);
		this.setLightLevel(light);
	}
}