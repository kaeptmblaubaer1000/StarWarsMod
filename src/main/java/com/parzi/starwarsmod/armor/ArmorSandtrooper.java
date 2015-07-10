package com.parzi.starwarsmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

public class ArmorSandtrooper extends ItemArmor
{
	private String[] names = new String[] { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorSandtrooper(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		setUnlocalizedName(StarWarsMod.MODID + "." + "sandtrooper" + names[par4]);
		setTextureName(StarWarsMod.MODID + ":" + "sandtrooper" + names[par4]);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.sandtrooperHelmet || stack.getItem() == StarWarsMod.sandtrooperChest || stack.getItem() == StarWarsMod.sandtrooperBoots)
		{
			return StarWarsMod.MODID + ":" + "textures/models/sandtrooperArmorLayer1.png";
		}
		else if (stack.getItem() == StarWarsMod.sandtrooperLegs) { return StarWarsMod.MODID + ":" + "textures/models/sandtrooperArmorLayer2.png"; }
		return "";
	}
}