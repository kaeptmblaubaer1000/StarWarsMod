package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorStormtrooper extends ItemArmor
{
	private String[] names = new String[] { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorStormtrooper(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + "stormtrooper" + names[par4]);
		setTextureName(StarWarsMod.MODID + ":" + "stormtrooper" + names[par4]);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.stormtrooperHelmet || stack.getItem() == StarWarsMod.stormtrooperChest || stack.getItem() == StarWarsMod.stormtrooperBoots)
		{
			return StarWarsMod.MODID + ":" + "textures/models/stormtrooperArmorLayer1.png";
		}
		else if (stack.getItem() == StarWarsMod.stormtrooperLegs) { return StarWarsMod.MODID + ":" + "textures/models/stormtrooperArmorLayer2.png"; }
		return "";
	}
}