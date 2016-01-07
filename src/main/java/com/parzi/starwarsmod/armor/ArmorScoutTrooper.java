package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;

public class ArmorScoutTrooper extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorScoutTrooper(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(Resources.MODID + "." + "scoutTrooper" + this.names[par4]);
		this.setTextureName(Resources.MODID + ":" + "scoutTrooper" + this.names[par4]);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.scoutTrooperHelmet || stack.getItem() == StarWarsMod.scoutTrooperChest || stack.getItem() == StarWarsMod.scoutTrooperBoots)
			return Resources.MODID + ":" + "textures/models/scoutTrooperArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.scoutTrooperLegs)
			return Resources.MODID + ":" + "textures/models/scoutTrooperArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorScoutTrooper.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */