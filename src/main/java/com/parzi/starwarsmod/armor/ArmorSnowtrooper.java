package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorSnowtrooper extends ItemArmor
{
	private String[] names = new String[] { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorSnowtrooper(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + "snowtrooper" + names[par4]);
		setTextureName(StarWarsMod.MODID + ":" + "snowtrooper" + names[par4]);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.snowtrooperHelmet || stack.getItem() == StarWarsMod.snowtrooperChest || stack.getItem() == StarWarsMod.snowtrooperBoots)
		{
			return StarWarsMod.MODID + ":" + "textures/models/snowtrooperArmorLayer1.png";
		}
		else if (stack.getItem() == StarWarsMod.snowtrooperLegs) { return StarWarsMod.MODID + ":" + "textures/models/snowtrooperArmorLayer2.png"; }
		return "";
	}
}