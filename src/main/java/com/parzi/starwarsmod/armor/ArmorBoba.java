package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorBoba extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorBoba(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName("starwarsmod.boba" + this.names[par4]);
		this.setTextureName(StarWarsMod.MODID + ":" + "boba" + this.names[par4]);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.bobaHelmet || stack.getItem() == StarWarsMod.bobaChest || stack.getItem() == StarWarsMod.bobaBoots) return StarWarsMod.MODID + ":" + "textures/models/bobaArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.bobaLegs || stack.getItem() == StarWarsMod.bobaJetpackChest) return StarWarsMod.MODID + ":" + "textures/models/bobaArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorBoba.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */