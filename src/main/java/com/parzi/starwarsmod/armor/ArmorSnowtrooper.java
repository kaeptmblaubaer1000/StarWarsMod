package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorSnowtrooper extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorSnowtrooper(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + "snowtrooper" + this.names[par4]);
		this.setTextureName(StarWarsMod.MODID + ":" + "snowtrooper" + this.names[par4]);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.snowtrooperHelmet || stack.getItem() == StarWarsMod.snowtrooperChest || stack.getItem() == StarWarsMod.snowtrooperBoots)
			return StarWarsMod.MODID + ":" + "textures/models/snowtrooperArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.snowtrooperLegs)
			return StarWarsMod.MODID + ":" + "textures/models/snowtrooperArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorSnowtrooper.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */