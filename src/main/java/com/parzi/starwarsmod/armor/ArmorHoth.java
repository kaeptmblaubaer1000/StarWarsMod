package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorHoth extends ItemArmor
{
	private String[] names = new String[] { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorHoth(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + "hoth" + names[par4]);
		setTextureName(StarWarsMod.MODID + ":" + "hoth" + names[par4]);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.hothHelmet || stack.getItem() == StarWarsMod.hothChest || stack.getItem() == StarWarsMod.hothBoots)
		{
			return StarWarsMod.MODID + ":" + "textures/models/hothArmorLayer1.png";
		}
		else if (stack.getItem() == StarWarsMod.hothLegs) { return StarWarsMod.MODID + ":" + "textures/models/hothArmorLayer2.png"; }
		return "";
	}
}