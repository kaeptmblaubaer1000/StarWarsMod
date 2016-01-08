package com.parzi.starwarsmod.armor;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorTiePilot extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorTiePilot(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(Resources.MODID + "." + "tiePilot" + this.names[par4]);
		this.setTextureName(Resources.MODID + ":" + "tiePilot" + this.names[par4]);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.tiePilotHelmet || stack.getItem() == StarWarsMod.tiePilotChest || stack.getItem() == StarWarsMod.tiePilotBoots)
			return Resources.MODID + ":" + "textures/models/tiePilotArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.tiePilotLegs)
			return Resources.MODID + ":" + "textures/models/tiePilotArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorTiePilot.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */