package com.parzi.starwarsmod.items.crafting;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemCustomTest extends Item
{
	public String name = "customTest";
	private IIcon[] icons;

	public ItemCustomTest()
	{
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int damage, int renderPass)
	{
		return this.icons[renderPass];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderPasses(int metadata)
	{
		return 2;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.icons = new IIcon[2];
		this.itemIcon = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + "imperialCredit");
		this.icons[0] = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + "containmentField");
		this.icons[1] = par1IconRegister.registerIcon(StarWarsMod.MODID + ":" + "imperialCredit");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\crafting\ItemPlasmaEmitter.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */