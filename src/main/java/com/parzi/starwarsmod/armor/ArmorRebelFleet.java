package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorRebelFleet extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorRebelFleet(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + "rebelTrooper" + this.names[par4]);
		this.setTextureName(StarWarsMod.MODID + ":" + "rebelTrooper" + this.names[par4]);
		//this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.fleetHelmet || stack.getItem() == StarWarsMod.fleetChest || stack.getItem() == StarWarsMod.fleetBoots) return StarWarsMod.MODID + ":" + "textures/models/fleetArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.fleetLegs) return StarWarsMod.MODID + ":" + "textures/models/fleetArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\Armorfleet.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */