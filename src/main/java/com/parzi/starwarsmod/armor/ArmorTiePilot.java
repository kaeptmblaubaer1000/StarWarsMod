package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorTiePilot extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorTiePilot(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + "tiePilot" + this.names[par4]);
		this.setTextureName(StarWarsMod.MODID + ":" + "tiePilot" + this.names[par4]);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.tiePilotHelmet || stack.getItem() == StarWarsMod.tiePilotChest || stack.getItem() == StarWarsMod.tiePilotBoots) return StarWarsMod.MODID + ":" + "textures/models/tiePilotArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.tiePilotLegs) return StarWarsMod.MODID + ":" + "textures/models/tiePilotArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorTiePilot.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */