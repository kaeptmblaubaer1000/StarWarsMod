package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorSequelStormtrooper extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorSequelStormtrooper(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + "stormtrooper" + this.names[par4] + "_new");
		this.setTextureName(StarWarsMod.MODID + ":" + "stormtrooper" + this.names[par4] + "_new");
		this.setCreativeTab(StarWarsMod.SequelStarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.stormtrooperNewHelmet || stack.getItem() == StarWarsMod.stormtrooperNewChest || stack.getItem() == StarWarsMod.stormtrooperNewBoots) return StarWarsMod.MODID + ":" + "textures/models/sequelStormtrooperArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.stormtrooperNewLegs) return StarWarsMod.MODID + ":" + "textures/models/sequelStormtrooperArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorStormtrooper.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */